package com.netreally.lex.models.request;
// Copyright © 2017, github.com/satr, MIT License


import com.netreally.lex.models.intents.IntentLoaderStrategy;
import com.netreally.lex.models.intents.UnsupportedIntentLoaderStrategy;

import java.util.HashMap;
import java.util.Map;

import static org.apache.http.util.TextUtils.isEmpty;

public class LexRequestFactory {
    private final  Map<String, IntentLoaderStrategy> intentLoaderStrategies = new HashMap<>();
    private final static IntentLoaderStrategy unsupportedIntentLoaderStrategy = new UnsupportedIntentLoaderStrategy();
    private final  String FACEBOOK_ID_PATTERN = "^\\d{16}$";


    public  LexRequest createFromMap(Map<String, Object> input) {
        LexRequest request = new LexRequest();
        if(input == null)
            return request;

        loadMainAttributes(input, request);
        loadBotName(input, request);
        loadSessionAttributes(input, request);

        Map<String, Object> currentIntent = loadCurrentIntent(input);
        if (currentIntent != null)
            loadIntentParameters(currentIntent, request);

        return request;
    }

    private  void loadMainAttributes(Map<String, Object> input, LexRequest request) {
        loadUserId(input, request);
        request.setInputTranscript((String) input.get(LexRequestAttribute.InputTranscript));
        request.setInvocationSource(getInvocationSource(input));
        request.setOutputDialogMode(getOutputDialogMode(input));
    }

    private  void loadUserId(Map<String, Object> input, LexRequest request) {
        String userId = (String) input.get(LexRequestAttribute.UserId);
        request.setUserId(userId);
        if(isEmpty(userId))
            request.setUserIdType(UserIdType.Undefined);
        else {
            if(userId.matches(FACEBOOK_ID_PATTERN))
                request.setUserIdType(UserIdType.Facebook);
            else
                request.setUserIdType(UserIdType.Undefined);
        }
    }

    private  OutputDialogMode getOutputDialogMode(Map<String, Object> input) {
        return LexRequestAttribute.OutputDialogModeValue.Voice.equals((String) input.get(LexRequestAttribute.OutputDialogMode))
                ? OutputDialogMode.Voice : OutputDialogMode.Text;
    }

    private  InvocationSource getInvocationSource(Map<String, Object> input) {
        return LexRequestAttribute.InvocationSourceValue.DialogCodeHook.equals((String) input.get(LexRequestAttribute.InvocationSource))
                                        ? InvocationSource.DialogCodeHook : InvocationSource.FulfillmentCodeHook;
    }

    private  void loadSessionAttributes(Map<String, Object> input, LexRequest request) {
        Map<String, Object> sessionAttrs = (Map<String, Object>) input.get(LexRequestAttribute.SessionAttributes);
        if (sessionAttrs != null)
            request.setSessionAttributes(sessionAttrs);
    }

    private  void loadIntentParameters(Map<String, Object> currentIntent, LexRequest request) {
        request.setConfirmationStatus(getConfirmationStatus(currentIntent));
        request.setIntentName((String) currentIntent.get(LexRequestAttribute.CurrentIntentName));

        loadIntentSlots(currentIntent, request);
    }

    private static ConfirmationStatus getConfirmationStatus(Map<String, Object> currentIntent) {
        String confirmationStatus = (String) currentIntent.get(LexRequestAttribute.InvocationSource);
        return LexRequestAttribute.ConfirmationStatusValue.Confirmed.equals(confirmationStatus)
                ? ConfirmationStatus.Confirmed
                : LexRequestAttribute.ConfirmationStatusValue.Denied.equals(confirmationStatus)
                    ? ConfirmationStatus.Denied
                    : ConfirmationStatus.None;
    }

    private  Map<String, Object> loadCurrentIntent(Map<String, Object> input) {
        return (Map<String, Object>) input.get(LexRequestAttribute.CurrentIntent);
    }

    private  void loadBotName(Map<String, Object> input, LexRequest request) {
        Map<String, Object> bot = (Map<String, Object>) input.get(LexRequestAttribute.Bot);
        if (bot != null)
            request.setBotName((String) bot.get(LexRequestAttribute.BotName));
    }

    private  void loadIntentSlots(Map<String, Object> currentIntent, LexRequest request) {
        IntentLoaderStrategy strategy = getIntentLoadingStrategyBy(request.getIntentName());
        Map<String, Object> slots = (Map<String, Object>) currentIntent.get(LexRequestAttribute.Slots);
        strategy.load(request, slots);
    }

    private  IntentLoaderStrategy getIntentLoadingStrategyBy(String intentName) {
        return intentLoaderStrategies.containsKey(intentName)
                ? intentLoaderStrategies.get(intentName)
                : unsupportedIntentLoaderStrategy;
    }

}

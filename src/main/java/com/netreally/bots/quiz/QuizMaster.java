package com.netreally.bots.quiz;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.netreally.lex.models.LexResponse;
import com.netreally.lex.models.actions.ConfirmIntentDialogAction;

import java.lang.reflect.Type;
import java.util.Map;

public class QuizMaster implements RequestHandler<Map<String, Object>, LexResponse> {


    @Override
    public LexResponse handleRequest(Map<String, Object> input, Context context) {

        LexResponse response = new LexResponse();
        context.getLogger().log("Recieved an Input:" + new Gson().toJson(input));
        response.addSessionAttributes("customerid", "1234");
        response.addSessionAttributes("customername", "binu");

        ConfirmIntentDialogAction action = new ConfirmIntentDialogAction();
        action.addToSlots("Option A", "George Bush");
        action.addToSlots("Option B", "Abraham Lincoln");
        action.addToSlots("Option C", "George Washington");
        action.addToSlots("Option D", "Jefferson");

        response.setDialogAction(action);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<LexResponse>() {}.getType();
        String json = gson.toJson(response, type);
        System.out.println(json);

        return response;
    }

}
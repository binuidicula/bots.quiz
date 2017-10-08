package com.netreally.lex.models.actions;

import com.netreally.lex.models.ActionMessage;
import com.netreally.lex.models.DialogActionType;
import com.netreally.lex.models.ResponseCard;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Informs Amazon Lex that the user is expected to provide a slot value in the response.
 */
public class ElicitSlotDialogAction extends DialogAction {

    private ActionMessage message;
    private String intentName;
    private Map<String, String> slots;
    private String slotToElicit;

    public ResponseCard getResponseCard() {
        return responseCard;
    }

    public void setResponseCard(ResponseCard responseCard) {
        this.responseCard = responseCard;
    }

    private ResponseCard responseCard;

    public ElicitSlotDialogAction(){
        super(DialogActionType.ElicitSlot);
        slots = new LinkedHashMap<>();
    }


    public ActionMessage getMessage() {
        return message;
    }

    public void setMessage(ActionMessage message) {
        this.message = message;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public Map<String, String> getSlots() {
        return slots;
    }

    public void setSlots(Map<String, String> slots) {
        this.slots = slots;
    }


    public void addToSlots(String optionName, String optionValue){
        slots.put(optionName, optionValue);
    }

}

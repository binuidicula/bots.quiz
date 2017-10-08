package com.netreally.lex.models;

import com.netreally.lex.models.actions.DialogAction;

import java.util.LinkedHashMap;
import java.util.Map;

public class LexResponse {

    private Map<String, String> sessionAttributes;
    private DialogAction dialogAction;

    public LexResponse(){
        sessionAttributes = new LinkedHashMap<>();
    }

    public Map<String, String> getSessionAttributes() {
        return sessionAttributes;
    }

    public void setSessionAttributes(Map<String, String> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }

    public DialogAction getDialogAction() {
        return dialogAction;
    }

    public void setDialogAction(DialogAction dialogAction) {
        this.dialogAction = dialogAction;
    }

    public void addSessionAttributes(String name, String value){
        sessionAttributes.put(name, value);
    }
}

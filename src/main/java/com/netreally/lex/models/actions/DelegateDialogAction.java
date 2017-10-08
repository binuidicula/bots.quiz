package com.netreally.lex.models.actions;

import com.netreally.lex.models.DialogActionType;

import java.util.LinkedHashMap;
import java.util.Map;

public class DelegateDialogAction extends DialogAction {

    private Map<String, String> slots;

    public DelegateDialogAction(){
        super(DialogActionType.Delegate);
        slots = new LinkedHashMap<>();
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

package com.netreally.lex.models.actions;

import com.netreally.lex.models.DialogActionType;

public class DialogAction {

    DialogAction(){
        type = null;
    }
    public DialogActionType getType() {
        return type;
    }

    public void setType(DialogActionType type) {
        this.type = type;
    }

    private DialogActionType type;

    public DialogAction(DialogActionType type){
        this.type = type;
    }

}

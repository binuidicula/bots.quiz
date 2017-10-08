package com.netreally.lex.models.actions;

import com.netreally.lex.models.ActionMessage;
import com.netreally.lex.models.DialogActionType;
import com.netreally.lex.models.FulfillmentStateType;
import com.netreally.lex.models.ResponseCard;

public class CloseDialogAction extends DialogAction {
    private FulfillmentStateType fulfillmentState;
    private ActionMessage message;
    private ResponseCard responseCard;

    CloseDialogAction(){
        super(DialogActionType.Close);
    }

    public FulfillmentStateType getFulfillmentState() {
        return fulfillmentState;
    }

    public void setFulfillmentState(FulfillmentStateType fulfillmentState) {
        this.fulfillmentState = fulfillmentState;
    }

    public ActionMessage getMessage() {
        return message;
    }

    public void setMessage(ActionMessage message) {
        this.message = message;
    }

    public ResponseCard getResponseCard() {
        return responseCard;
    }

    public void setResponseCard(ResponseCard responseCard) {
        this.responseCard = responseCard;
    }



}

package com.netreally.lex.models.actions;

import com.netreally.lex.models.ActionMessage;
import com.netreally.lex.models.DialogActionType;
import com.netreally.lex.models.ResponseCard;

/**
 * Informs Amazon Lex that the user is expected to respond with an
 * utterance that includes an intent. For example, "I want a large pizza,"
 * which indicates the OrderPizzaIntent.
 *
 * The utterance "large, on the other hand, is not sufficient for
 * Amazon Lex to infer the user's intent.
 */
public class ElicitIntentDialogAction extends DialogAction {

    private ActionMessage message;

    public ResponseCard getResponseCard() {
        return responseCard;
    }

    public void setResponseCard(ResponseCard responseCard) {
        this.responseCard = responseCard;
    }

    private ResponseCard responseCard;

    public ElicitIntentDialogAction(){
        super(DialogActionType.ElicitIntent);
    }


    public ActionMessage getMessage() {
        return message;
    }

    public void setMessage(ActionMessage message) {
        this.message = message;
    }


}

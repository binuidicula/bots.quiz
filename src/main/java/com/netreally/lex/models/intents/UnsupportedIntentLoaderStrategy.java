package com.netreally.lex.models.intents;
// Copyright © 2017, github.com/satr, MIT License


import com.netreally.lex.models.request.LexRequest;

import java.util.Map;

public class UnsupportedIntentLoaderStrategy extends IntentLoaderStrategy {
    @Override
    public void load(LexRequest request, Map<String, Object> slots) {
        request.setError("Not recognized request.");
    }
}

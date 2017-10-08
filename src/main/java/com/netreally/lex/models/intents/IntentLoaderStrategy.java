package com.netreally.lex.models.intents;
// Copyright © 2017, github.com/satr, MIT License


import com.netreally.lex.models.request.LexRequest;

import java.util.Map;

public abstract class IntentLoaderStrategy {


    protected static void readDepartmentSlots(LexRequest request, Map<String, Object> slots, String productSlotName, String amountSlotName, String unitSlotName) {
        request.setProduct(getSlotValueFor(slots, productSlotName, null));
        request.setRequestedAmount(getSlotValueFor(slots, amountSlotName, null));
        request.setRequestedUnit(getSlotValueFor(slots, unitSlotName, null));
    }

    protected static String getSlotValueFor(Map<String, Object> slots, String productSlotName, String defaultValue) {
        String slotValue = (String)slots.get(productSlotName);
        return slotValue != null ? slotValue : defaultValue;
    }

    public abstract void load(LexRequest request, Map<String, Object> slots);
}

package com.ford.ch.mobileseat.constants;

public enum TransType {
    NEW_BOOKING(1), UPDATE_BOOKING(2), CANCEL_BOOKING(3);
    public final Integer transTypeId;

    private TransType(Integer transTypeId) {
        this.transTypeId = transTypeId;
    }

}

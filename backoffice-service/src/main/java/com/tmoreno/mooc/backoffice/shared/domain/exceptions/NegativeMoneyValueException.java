package com.tmoreno.mooc.backoffice.shared.domain.exceptions;

public final class NegativeMoneyValueException extends InvalidValueException {
    public NegativeMoneyValueException(double value) {
        super(
            "negative-money-value",
            "Money value is not positive: " + value
        );
    }
}

package org.app;

import lombok.Getter;

@Getter
public enum BankProductName {
    DEPOSIT("Депозит"),
    CREDIT("Кредит"),
    SAVINGS_ACCOUNT("Сберегательный счет");

    private final String displayName;

    BankProductName(String displayName) {
        this.displayName = displayName;
    }
}
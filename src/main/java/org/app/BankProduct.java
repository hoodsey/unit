package org.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
@RequiredArgsConstructor
public abstract class BankProduct {
    @NonNull
    protected Currency currency;

    protected BigDecimal balance = BigDecimal.ZERO;

    @NonNull
    protected BankProductName name;

    public void displayBalance() {
        System.out.println("Баланс продукта " + name + ": " + balance + " " + currency.getSymbol());
    }

    public abstract void deposit(BigDecimal amount);
}
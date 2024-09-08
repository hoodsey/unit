package org.app;

import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Currency;

class Deposit extends BankProduct {

    @NonNull
    private int termInMonths; // Срок вклада в месяцах
    @NonNull
    private BigDecimal interestRate; // Процентная ставка

    public Deposit(BankProductName name, Currency currency, int termInMonths, BigDecimal interestRate) {
        super(currency, name);
        this.termInMonths = termInMonths;
        this.interestRate = interestRate;
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Сумма вклада должна быть положительной.");
        }
        balance = balance.add(amount);
    }

    public BigDecimal calculateInterest() {
        return balance.multiply(interestRate).divide(BigDecimal.valueOf(100));
    }

    public void withdraw(BigDecimal amount) {
        throw new UnsupportedOperationException("Снятие средств с депозита не поддерживается до окончания срока вклада.");
    }

    public BigDecimal getTotalAmountAfterTerm() {
        return balance.add(calculateInterest());
    }
}
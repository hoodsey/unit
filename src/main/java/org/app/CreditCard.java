package org.app;

import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Currency;

public class CreditCard extends Card {
    @NonNull
    private BigDecimal debit; // задолженность
    @NonNull
    private BigDecimal interestRate; // % ставка

    public CreditCard(BankProductName name, Currency currency, BigDecimal interestRate) {
        super(currency, name);
        this.interestRate = interestRate;
        this.debit = BigDecimal.ZERO;
    }

    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        paymentDebit(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
        debit = debit.add(amount);
    }

    public BigDecimal getDebit() {
        return debit;
    }

    private void paymentDebit(BigDecimal amount) {
        if (amount.compareTo(debit) > 0) {
            balance = balance.add(amount.subtract(debit));
            debit = BigDecimal.ZERO;
        } else {
            debit = debit.subtract(amount);
        }
    }

    public BigDecimal calculateMonthlyInterest() {
        return debit.multiply(interestRate).divide(BigDecimal.valueOf(12), BigDecimal.ROUND_HALF_UP);
    }

    // метод пополнения для кредитной карты
    @Override
    public void replenish(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной.");
        }
        // Увеличение баланса на сумму пополнения
        balance = balance.add(amount);

        // Погашение задолженности, если она есть
        paymentDebit(amount);
    }
}

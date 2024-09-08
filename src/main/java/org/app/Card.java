package org.app;

import java.math.BigDecimal;
import java.util.Currency;

abstract public class Card extends BankProduct {

    public Card( Currency currency, BankProductName name) {
        super(currency, name);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Недостаточно средств.");
        }
        balance = balance.subtract(amount);
    }

    // Метод для пополнения карты
    public void replenish(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной.");
        }
        balance = balance.add(amount);
    }
}
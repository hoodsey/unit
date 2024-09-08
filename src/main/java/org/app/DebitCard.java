package org.app;

import java.math.BigDecimal;
import java.util.Currency;

class DebitCard extends Card {
    public DebitCard(BankProductName name, Currency currency) {
        super(currency,  name);
    }

    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}

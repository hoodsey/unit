package unit;

import io.qameta.allure.Allure;
import org.app.BankProductName;
import org.app.CreditCard;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTests {


    @BeforeAll
    public static void setupAll() {

    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // позитивный тест оплаты
    @Test
    @DisplayName("S")
    void shouldSuccessPayByApprovedCard() {
        Currency c3 = Currency.getInstance("RUB");
        var Credit = new CreditCard(BankProductName.CREDIT, c3, BigDecimal.valueOf(20));
       System.out.println(Credit.getDebit());
    }

}


package atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAccount {
    private int accountNumber;
    private int pin;
    private Euro availableBalance;
    private Euro totalBalance;

    @BeforeEach
    public void setUp() {
        accountNumber = 12345;
        pin = 54321;
        availableBalance = new Euro(1000.0);
        totalBalance = new Euro(1200.0);
    }

    @Test
    void testValidatePIN() {
        Account account = new Account(accountNumber, pin, availableBalance.getValue(), totalBalance.getValue());
        assertTrue(account.validatePIN(pin));
    }

    @Test
    void testGetAvailableBalance() {
        Account account = new Account(accountNumber, pin, availableBalance.getValue(), totalBalance.getValue());
        assertEquals(1000.0, account.getAvailableBalance().getValue());
    }

    @Test
    void testGetTotalBalance() {
        Account account = new Account(accountNumber, pin, availableBalance.getValue(), totalBalance.getValue());
        assertEquals(1200.0, account.getTotalBalance().getValue());
    }

    @Test
    void testCredit() {
        Account account = new Account(accountNumber, pin, availableBalance.getValue(), totalBalance.getValue());
        account.credit(100.0);
        assertEquals(1300.0, account.getTotalBalance().getValue());
    }

    @Test
    void testDebit() {
        Account account = new Account(accountNumber, pin, availableBalance.getValue(), totalBalance.getValue());
        account.debit(100.0);
        assertEquals(900.0, account.getAvailableBalance().getValue());
        assertEquals(1100.0, account.getTotalBalance().getValue());
    }

    @Test
    void testGetAccountNumber() {
        Account account = new Account(accountNumber, pin, availableBalance.getValue(), totalBalance.getValue());
        assertEquals(12345, account.getAccountNumber());
    }
}

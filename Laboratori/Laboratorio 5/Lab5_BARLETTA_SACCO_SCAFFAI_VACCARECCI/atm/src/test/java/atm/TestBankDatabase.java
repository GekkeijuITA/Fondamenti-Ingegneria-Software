package atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBankDatabase {
    private Account [] accounts;

    @BeforeEach
    void setUp() {
        accounts = new Account[ 2 ];
        accounts[ 0 ] = new Account(12345, 54321, 1000.0, 1200.0);
        accounts[ 1 ] = new Account(98765, 56789, 200.0, 200.0);  
    }

    @Test
    void testAuthenticateUser() {
        BankDatabase bankDatabase = new BankDatabase();
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
        assertTrue(bankDatabase.authenticateUser(98765, 56789));
    }

    @Test
    void testGetAvailableBalance() {
        BankDatabase bankDatabase = new BankDatabase();
        assertEquals(1000.0, bankDatabase.getAvailableBalance(12345).getValue());
        assertEquals(200.0, bankDatabase.getAvailableBalance(98765).getValue());
    }

    @Test
    void testGetTotalBalance() {
        BankDatabase bankDatabase = new BankDatabase();
        assertEquals(1200.0, bankDatabase.getTotalBalance(12345).getValue());
        assertEquals(200.0, bankDatabase.getTotalBalance(98765).getValue());
    }

    @Test
    void testCredit() {
        BankDatabase bankDatabase = new BankDatabase();
        bankDatabase.credit(12345, 100.0);
        assertEquals(1300.0, bankDatabase.getTotalBalance(12345).getValue());

        bankDatabase.credit(98765, 100.0);
        assertEquals(300.0, bankDatabase.getTotalBalance(98765).getValue());
    }

    @Test
    void testDebit() {
        BankDatabase bankDatabase = new BankDatabase();
        bankDatabase.debit(12345, 100.0);
        assertEquals(900.0, bankDatabase.getAvailableBalance(12345).getValue());
        assertEquals(1100.0, bankDatabase.getTotalBalance(12345).getValue());

        bankDatabase.debit(98765, 100.0);
        assertEquals(100.0, bankDatabase.getAvailableBalance(98765).getValue());
        assertEquals(100.0, bankDatabase.getTotalBalance(98765).getValue());
    }
}

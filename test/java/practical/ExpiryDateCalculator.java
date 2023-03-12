package practical;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculator {



    public LocalDate calculatorExpiryDate(LocalDate billingDate, int payAmount){
        return billingDate.plusMonths(1);
    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate){
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculatorExpiryDate(billingDate, payAmount);

        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}

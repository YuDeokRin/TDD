package practical;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class ExpiryDateCalculatorTest{
    @Test
    void 만원_납부하면_한달_뒤_만료일(){
        LocalDate billingDate = LocalDate.of(2022,3,1);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculatorExpiryDate(billingDate, payAmount);

        assertEquals(LocalDate.of(2022,4,1), expiryDate);

        //--------------- 예시 추가 ---------------
        LocalDate billingDate2 = LocalDate.of(2022, 5, 5);
        int payAmount2 = 10_000;

        ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
        LocalDate expiryDate2 = cal2.calculatorExpiryDate(billingDate2, payAmount2);

        assertEquals(LocalDate.of(2022,6,5), expiryDate2);
    }

    @Test
    void 만원_납부하면_한달_뒤가_만료일(){
        assertExpiryDate(LocalDate.of(2022,1,31),10_000,
                LocalDate.of(2022,2,28));
    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate){
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculatorExpiryDate(billingDate, payAmount);

        assertEquals(expectedExpiryDate, realExpiryDate);
    }

}
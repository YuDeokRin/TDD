package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    @Test
    void name(){

    }

    // 강력한 암호
     @Test
    void meetsAllCriteria_Then_Strong(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
         PasswordStrength result = meter.meter("2b12!@AB");
         assertEquals(PasswordStrength.STRONG, result);
         PasswordStrength result2 = meter.meter("abc1!Add");
         assertEquals(PasswordStrength.STRONG, result2);


    }

    //2. 길이만 8글자 미만이고 나머지 조건은 충적하는 경우
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter(); //객체 만들어준다.
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);

        PasswordStrength result2 = meter.meter("Ab12!c");
        assertEquals(PasswordStrength.NORMAL, result2);
    }


    //3. 숫자를 포함하지 않고 나머지 조건을 충족하는 경우
    @Test
    void meetsOtherCriteria_excep_for_number_Then_Nomal(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab!@ABqwer");
        assertEquals(PasswordStrength.NORMAL, result);
    }


}

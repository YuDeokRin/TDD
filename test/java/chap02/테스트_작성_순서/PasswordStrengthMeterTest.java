package chap02.테스트_작성_순서;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {


    // 테스트가 잘 작동되는지 확인
    @Test
    void name(){

    }

    @Test
    void meetsOnlyUpperCreteria_Then_Weak(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcDef");
        assertEquals(PasswordStrength.WEAK, result);
    }

    @Test
    void meetsAllCreteria_Then_Weak(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcDef12");
        assertEquals(PasswordStrength.STRONG, result);
    }

    @Test
    void meetsOtherCreteria_except_for_Length_Then_Normal(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);
        PasswordStrength result2 = meter.meter("Ab12!c");
        assertEquals(PasswordStrength.NORMAL, result2);
    }
}

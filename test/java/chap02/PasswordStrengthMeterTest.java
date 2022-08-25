package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {


    // 테스트가 잘 작동되는지 확인
    @Test
    void name(){

    }

    private PasswordStrengthMeter meter = new PasswordStrengthMeter(); // 공통으로 들어가는 것을 묶어준다.

    //메서드로 분리
    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }


    // 강력한 암호
     @Test
    void meetsAllCriteria_Then_Strong(){
         assertStrength("ab12!@AB",PasswordStrength.STRONG);
         assertStrength("abc1!Add",PasswordStrength.STRONG);
    }

    //2. 길이만 8글자 미만이고 나머지 조건은 충적하는 경우
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A",PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }


    //3. 숫자를 포함하지 않고 나머지 조건을 충족하는 경우
    @Test
    void meetsOtherCriteria_excep_for_number_Then_Nomal(){
        assertStrength("ab!@ABqwer",PasswordStrength.NORMAL);
    }


    //4.값이 없을 경우  - illegalargumentexception을 발생
    //               - 유요하지 않은 암호를 의미하는 PasswordStrength.INVALID를 리턴
    @Test
    void nullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    // "" 빈 문자열일 경우
    @Test
    void emptyInput_Then_Invalid(){
        assertStrength("", PasswordStrength.INVALID);

    }

    //5. 대문자를 포함하지 않고 나머지 조건을 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    //6. 길이가 8글자 이상인 조건만 충족하는 경우  -> 약함
    @Test
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    //7. 숫자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345", PasswordStrength.WEAK);
    }

    //8. 대문자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABCDE", PasswordStrength.WEAK);
    }

}

package chap02;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {

        //5. null 값 또는 빈 문자열일 경우
        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;

        boolean lengthEnough = s.length() >=8;
        boolean containsNum = meetsContainingNumberCriteria(s); // 0 ~ 9 라는 숫자를 포함하는지 안하는지 확인하는 변수
        boolean containsUpp = meetsContainingUppercaseCriteria(s);


        //6. 숫자 포함 x and 대문자 포함 x and 8글자 이상만 포함
        if(lengthEnough && !containsNum && !containsUpp)
            return PasswordStrength.WEAK;
        //7.
        if(!lengthEnough && containsNum && !containsUpp)
            return PasswordStrength.WEAK;
        //8.
        if(!lengthEnough && !containsNum && containsUpp)
            return PasswordStrength.WEAK;

        /* 이전 코드
        // 1. 문자열의 길이가 8이하면
        if (s.length() < 8) {
            return PasswordStrength.NORMAL; // 패스워드의 강도는 보통이다.
        }
         */

        if(!lengthEnough) {
            return PasswordStrength.NORMAL;
        }
        if(!containsNum) return PasswordStrength.NORMAL; // 각 문자를 비교해서 0 ~ 9 사이의 값을 갖는 문자가 없으면 NORMAL
        if(!containsUpp) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG; // 갖고 있으면 강함으로
    }

    //3. 숫자를 포함하지 않고 나머지 조건을 충족하는 경우
    //숫자(0~9)를 포함하고 있는지 확인하는 로직 -> 분리한다.
    public boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    public boolean meetsContainingUppercaseCriteria(String s) {

        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}

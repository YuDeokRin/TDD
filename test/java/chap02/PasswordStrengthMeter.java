package chap02;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {

        //5. null 값 또는 빈 문자열일 경우
        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;
        int metCounts = 0;
        if(s.length() >= 8) metCounts++;
        if(meetsContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUppercaseCriteria(s)) metCounts++;


        if(metCounts <= 1) return PasswordStrength.WEAK;
        if(metCounts == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
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

package chap02;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {

        //5. null 값 또는 빈 문자열일 경우
        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;

        // WEAK(약함)을 반환하는 것들을 처리했다.
        // 충족하는 조건을 개수로 바꾸면 묶어서 처리할 수 있다. (중복제거 )
        
        int metCounts = 0;
        boolean lengthEnough = s.length() >=8;
        if(lengthEnough) metCounts++;
        boolean containsNum = meetsContainingNumberCriteria(s); // 0 ~ 9 라는 숫자를 포함하는지 안하는지 확인하는 변수
        if(containsNum) metCounts++;
        boolean containsUpp = meetsContainingUppercaseCriteria(s);
        if(containsUpp) metCounts++;

        if(metCounts== 1) return PasswordStrength.WEAK; // 공통을 묶어줬따.



        //NORMAL(보통)을 반환하는 로직들을 묶음 처리
        if(metCounts == 2) return PasswordStrength.NORMAL;


        //STRONG(강함)은 1도아니고 2도아니면 else 느낌으로 처리한다.
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

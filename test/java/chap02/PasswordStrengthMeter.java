package chap02;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s.length() < 8) { // 문자열의 길이가 8이하면
            return PasswordStrength.NORMAL; // 패스워드의 강도는 보통이다.
        }
        boolean containsNum = false; // 0 ~ 9 라는 숫자를 포함하는지 안하는지 확인하는 변수
        for (char ch : s.toCharArray()) { // 문자열을 문자로 쪼갠다.
            if (ch >= '0' && ch <= '9') { // 문자열에 문자가 0 ~ 9가 포함되어있으면
                containsNum = true; // 숫자를 포함한다.
                break;
            }
        }
        if(!containsNum) return PasswordStrength.NORMAL; // 각 문자를 비교해서 0 ~ 9 사이의 값을 갖는 문자가 없으면 NORMAL
        return PasswordStrength.STRONG; // 갖고 있으면 강함으로
    }
}

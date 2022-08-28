package chap02;
/*
    마지막 단계 - 테스트에서 메인으로 코드 이동
    마지막 한개가 남았다. 테스트로 작성한 코드들은 테스트를 마쳤고 이제 배포될 폴더로 이동한다.
    src/main/java 이곳으로 이동해야지 비로서 구현이 끝난다.
    옮기는 파일들 목록 : PasswordStrength.java
                     PsswordStrengthMeter.java

 */

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {

        //암호가 null이거나 빈 문자열이면 암호강도는 INVALID이다.
        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;

        //충족하는 규칙 개수를 구한다.
        int metCounts = getMetCriteriaCounts(s);

        //충족하는 규칙 개수가 1개 이하면 암호 강도는 WEAK이다.
        if(metCounts <= 1) return PasswordStrength.WEAK;
        //충족하는 규칙 개수가 2개면 암호 강호는 NORMAL이다.
        if(metCounts == 2) return PasswordStrength.NORMAL;
        //이 외 경우(즉 충족하는 규칙 개수가 2개보다 크면) 암호 강도는 STRONG이다.
        return PasswordStrength.STRONG;
    }

    //meetsContainingNumberCriteria() : 암호에 0 ~ 9 숫자가 들어가는지 확인하는 메서드
    public boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    //meetsContainingUppercaseCriteria : 암호에 대문자가 들어있는지 확인하는 메서
    public boolean meetsContainingUppercaseCriteria(String s) {

        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    // 암호 규칙 : 길이, 숫자 포함 여부, 대문자 포함 여부 확인
    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if(s.length() >= 8) metCounts++;
        if(meetsContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUppercaseCriteria(s)) metCounts++;
        return metCounts;
    }
}

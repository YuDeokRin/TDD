package chap02.테스트_작성_순서;
/*
    마지막 단계 - 테스트에서 메인으로 코드 이동
    마지막 한개가 남았다. 테스트로 작성한 코드들은 테스트를 마쳤고 이제 배포될 폴더로 이동한다.
    src/main/java 이곳으로 이동해야지 비로서 구현이 끝난다.
    옮기는 파일들 목록 : PasswordStrength.java
                     PsswordStrengthMeter.java

 */

public class PasswordStrengthMeter {
//    public PasswordStrength meter(String s){
//        return PasswordStrength.WEAK;
//    }

    public PasswordStrength meter(String s) {
        if (s.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }




}

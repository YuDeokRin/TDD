package codingTest;

public class Main {

    public int solution(String s) {
        int answer = 0;
        s = s.replaceAll("[^0-9]", "");
        answer = Integer.parseInt(s);
        return answer;
    }


    public int solution2(String s) {
        String answer = "";

        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }


    public int solution3(String s) {
        String answer = "";

        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }


    public String solution4(String s){
        String answer = "";
        int cnt = 1;
        s = s + " ";
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            }else {
                answer += s.charAt(i);
                if(cnt > 1){
                    answer += Integer.valueOf(cnt);
                }
                cnt = 1;
            }
        }
        return answer;
    }




}

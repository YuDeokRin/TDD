package codingTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void 정규식추출(){
        Main T = new Main();
        int result = T.solution("g0en2T0s8eSoft");
        assertEquals(T.solution("208"), result);
    }

    @Test
    void 아스키코드(){
        Main T = new Main();
        int result = T.solution2("g0en2T0s8eSoft");
        assertEquals(T.solution2("208"), result);
    }

    @Test
    void isDigit메소드이용(){
        Main T = new Main();
        int result = T.solution3("g0en2T0s8eSoft");
        assertEquals(T.solution3("208"), result);
    }

    @Test
    void 문자열압축(){
        Main T = new Main();
        String result = T.solution4("KKHSSSSSSSE");
        assertEquals(T.solution4("K2HS7E"), result);
    }

}

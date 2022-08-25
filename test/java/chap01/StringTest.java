package chap01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void substring(){
        String str = "안녕하세요";
        assertEquals("하세", str.substring(2, 4));
    }
}

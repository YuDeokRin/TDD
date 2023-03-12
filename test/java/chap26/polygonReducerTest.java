package chap26;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class polygonReducerTest {

    @Test
    void Reducer() {
        Reducer r = new Reducer(new Polygon());
        assertEquals(0, reducer.result().npoints);
        
    }
}

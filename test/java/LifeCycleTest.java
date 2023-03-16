import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifeCycleTest {

    public LifeCycleTest(){
        System.out.println("new LifecycleTest"); // 1. 테스트 메서드를 포함한 객체 생성
    }

    @BeforeEach
    void setUp(){
        System.out.println("setUp"); // (존재하면) @BeforeEach 애노테이션이 붙은 메서드 실행
    }

    @Test
    void a(){
        System.out.println("A"); // @Test 애노테이션이 붙은 메서드 실행
    }

    @Test
    void b(){
        System.out.println("B");
    }

    @AfterEach
    void tearDown(){
        System.out.println("tearDown"); // (존재하면) @AfterEach 애노테이션이 붙은 메서드 실행
    }


}

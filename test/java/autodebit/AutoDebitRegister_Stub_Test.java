package autodebit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static autodebit.CardValidity.INVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Stub_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepositroy;

    @BeforeEach
    void setUp(){
        stubValidator = new StubCardNumberValidator();
        stubRepositroy = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepositroy);
    }


    @Test
    void invalidCard(){
        stubValidator.setInvalidNo("111122223333"); //유효하지 않은 카드 번호 상황 흉내

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(INVALID, result.getValidity());
    }


    @Test
    void theftCard(){
        stubValidator.setTheftNo("1234567890123456");
        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);

        assertEquals(CardValidity.THEFT, result.getValidity());

    }

}

package autodebit;

/**
 * CardNumberValidator의 대역 클래스 구현
 */
public class StubCardNumberValidator extends CardNumberValidator{

    private String invalidNo;
    private String theftNo;


    public void setInvalidNo(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    public void setTheftNo(String theftNo) {
        this.theftNo = theftNo;
    }


    @Override
    public CardValidity validate(String cardNumber) {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID; // 유효하지 않는 카드 번호
        }
        if (theftNo != null && theftNo.equals(cardNumber)) {
            return CardValidity.THEFT; // 도난 카드 번호
        }

        return CardValidity.VALID; // 유효한 카드
    }


}

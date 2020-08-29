package entity;


/**
 * @author 016852/dengguangming
 * @date 2020/08/29
 */
public enum SQLOpreatorSymbol {

    EQUAL("="),
    CONTAINS("contains"),
    NOT_EQUAL("!="),
    IN("in"),
    LIKE("like");


    private String operatorSymbol;

    SQLOpreatorSymbol(String operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    public String getOperatorSymbol() {
        return operatorSymbol;
    }
}

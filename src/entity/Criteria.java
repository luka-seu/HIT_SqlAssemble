package entity;


/**
 * @author 016852/dengguangming
 * @date 2020/08/29
 */
public class Criteria {

    public Criteria(SQLLinkSymbol sqlLinkSymbol, SQLFields sqlFields, SQLOpreatorSymbol opreatorSymbol, String filterCondition) {
        this.sqlLinkSymbol = sqlLinkSymbol;
        this.sqlFields = sqlFields;
        this.opreatorSymbol = opreatorSymbol;
        this.filterCondition = filterCondition;
    }

    public Criteria() {
    }

    //and/or
    private SQLLinkSymbol sqlLinkSymbol;

    //过滤字段
    private SQLFields sqlFields;

    //like/in/contains
    private SQLOpreatorSymbol opreatorSymbol;

    private String filterCondition;

    public SQLLinkSymbol getSqlLinkSymbol() {
        return sqlLinkSymbol;
    }

    public void setSqlLinkSymbol(SQLLinkSymbol sqlLinkSymbol) {
        this.sqlLinkSymbol = sqlLinkSymbol;
    }

    public SQLFields getSqlFields() {
        return sqlFields;
    }

    public void setSqlFields(SQLFields sqlFields) {
        this.sqlFields = sqlFields;
    }

    public SQLOpreatorSymbol getOpreatorSymbol() {
        return opreatorSymbol;
    }

    public void setOpreatorSymbol(SQLOpreatorSymbol opreatorSymbol) {
        this.opreatorSymbol = opreatorSymbol;
    }

    public String getFilterCondition() {
        return filterCondition;
    }

    public void setFilterCondition(String filterCondition) {
        this.filterCondition = filterCondition;
    }

    @Override
    public String toString() {

        return sqlLinkSymbol.getLinkSymbol() + " "
                + sqlFields.getField() + " "
                + opreatorSymbol.getOperatorSymbol() + " "
                + filterCondition + " ";
    }
}

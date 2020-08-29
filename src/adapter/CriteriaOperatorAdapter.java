package adapter;

import entity.Criteria;
import entity.SQLOpreatorSymbol;

import java.util.HashMap;

public class CriteriaOperatorAdapter {
    private static final HashMap<SQLOpreatorSymbol,CriteriaOpereatorProcessor> processMap = new HashMap<>();
    static {
        processMap.put(SQLOpreatorSymbol.IN,new InOperatorProcessor());
        processMap.put(SQLOpreatorSymbol.EQUAL,new NotInOperatorProcessor());
        processMap.put(SQLOpreatorSymbol.NOT_EQUAL,new NotInOperatorProcessor());
        processMap.put(SQLOpreatorSymbol.CONTAINS,new NotInOperatorProcessor());
        processMap.put(SQLOpreatorSymbol.LIKE,new NotInOperatorProcessor());
    }
    public void processorOperator(Criteria criteria){
        CriteriaOpereatorProcessor processor = processMap.get(criteria.getOpreatorSymbol());
        processor.proceessOperator(criteria);
    }

}

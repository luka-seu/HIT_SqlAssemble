package adapter;

import entity.Criteria;


//当select * from table where field in .....
public class InOperatorProcessor implements CriteriaOpereatorProcessor {
    @Override
    public void proceessOperator(Criteria criteria) {
        StringBuilder sb = new StringBuilder("(");
        //如果是in，要求输入的条件以逗号隔开
        String oriCondition = criteria.getFilterCondition();
        String[] conditions = oriCondition.split(",");
        for (String condition:conditions){
            sb.append("\""+condition+"\",");
        }
        criteria.setFilterCondition(sb.substring(0,sb.length()-1)+")");
    }
}

package adapter;

import entity.Criteria;


//不是select * from table where field in .....
public class NotInOperatorProcessor implements CriteriaOpereatorProcessor {
    @Override
    public void proceessOperator(Criteria criteria) {
        criteria.setFilterCondition("\""+criteria.getFilterCondition()+"\"");
    }
}

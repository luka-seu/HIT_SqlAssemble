package service;

import entity.Criteria;
import entity.SQLLinkSymbol;

import java.util.List;


//不存在一个SqlLinkSymbol(and/or)为空的Criteria
public class SQLAssembleServiceWithBeginning extends AbstractSQLAssembleService {
    @Override
    public String getSql(List<Criteria> criterias) {

        Criteria andBeginCriteria = findCriteriaByLink(criterias, SQLLinkSymbol.AND);
        //原有条件集合中移除andBeginCriteria
        criterias.remove(andBeginCriteria);
        return doAssemble(criterias, andBeginCriteria, SQLLinkSymbol.AND);

    }

    protected String doAssemble(List<Criteria> criterias, Criteria andBeginCriteria, SQLLinkSymbol sqlLinkSymbol) {
        //拼接sql,去掉开头的and
        StringBuilder sb = new StringBuilder(andBeginCriteria.toString().substring(3));
        for (Criteria criteria: criterias){
            sb.append(criteria.toString());
        }
        return sb.substring(0,sb.length()-1);
    }


    protected Criteria findCriteriaByLink(List<Criteria> criterias, SQLLinkSymbol sqlLinkSymbol) {
        Criteria andBeginCriteria = new Criteria();
        for (Criteria criteria: criterias){
            if (criteria.getSqlLinkSymbol()== sqlLinkSymbol){
                andBeginCriteria = criteria;
                break;
            }
        }
        return andBeginCriteria;
    }
}

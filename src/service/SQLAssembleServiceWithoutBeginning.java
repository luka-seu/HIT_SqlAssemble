package service;


import entity.Criteria;
import entity.SQLLinkSymbol;

import java.util.List;

/**
 * @author 016852/dengguangming
 * @date 2020/08/29
 */

//存在一个SqlLinkSymbol(and/or)为空的Criteria
public class SQLAssembleServiceWithoutBeginning extends AbstractSQLAssembleService {
    @Override
    public String getSql(List<Criteria> criterias) {
        Criteria noLinkCriteria = findCriteriaByLink(criterias, SQLLinkSymbol.EMPTY);
        //拼接sql
        return doAssemble(criterias,noLinkCriteria, SQLLinkSymbol.EMPTY);

    }

    @Override
    protected String doAssemble(List<Criteria> criterias, Criteria noLinkCriteria, SQLLinkSymbol sqlLinkSymbol) {
        if (noLinkCriteria.getSqlLinkSymbol()==null){
            return "";
        }
        StringBuilder sb = new StringBuilder(noLinkCriteria.toString());
        for (Criteria criteria:criterias){
            //跳过没有连接符(and/or)
            if (criteria.getSqlLinkSymbol()==sqlLinkSymbol){
                continue;
            }
            sb.append(criteria.toString());

        }
        //去掉最后多余的一个空格
        return sb.substring(0,sb.length()-1);
    }

    @Override
    protected Criteria findCriteriaByLink(List<Criteria> criterias, SQLLinkSymbol sqlLinkSymbol) {
        Criteria noLinkCriteria = new Criteria();
        for (Criteria criteria: criterias){
            if (criteria.getSqlLinkSymbol()== sqlLinkSymbol){
                noLinkCriteria = criteria;
                break;
            }
        }
        return noLinkCriteria;
    }

}

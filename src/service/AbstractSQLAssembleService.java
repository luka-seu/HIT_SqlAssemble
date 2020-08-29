package service;

import entity.Criteria;
import entity.SQLLinkSymbol;

import java.util.List;

/**
 * @author 016852/dengguangming
 * @date 2020/08/29
 */
public abstract class AbstractSQLAssembleService {

    public static final AbstractSQLAssembleService EMPTYLINKBEGINNING = new SQLAssembleServiceWithoutBeginning();
    public static final AbstractSQLAssembleService ANDLINKBEGINNING = new SQLAssembleServiceWithBeginning();

    public String assembleSql(List<Criteria> criterias){
        StringBuilder sb = new StringBuilder();
        String sql = "select * from table where";
        return sb.append(sql).append(getSql(criterias)).toString();
    }

    /**
     * 拼装条件
     * @param criterias
     * @return
     */
    protected abstract String getSql(List<Criteria> criterias);

    protected abstract String doAssemble(List<Criteria> criterias, Criteria andBeginCriteria, SQLLinkSymbol sqlLinkSymbol);

    /**
     * 找到and开头的Criteria
     *
     * @param criterias
     * @return
     */
    protected abstract Criteria findCriteriaByLink(List<Criteria> criterias, SQLLinkSymbol sqlLinkSymbol);
}



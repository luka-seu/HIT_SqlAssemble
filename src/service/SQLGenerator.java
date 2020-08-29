package service;


import adapter.CriteriaOperatorAdapter;
import entity.Criteria;

import java.util.List;

public class SQLGenerator {
    private AbstractSQLAssembleService assembleService;
    private CriteriaOperatorAdapter adapter;

    public SQLGenerator(AbstractSQLAssembleService assembleService,CriteriaOperatorAdapter adapter) {
        this.assembleService = assembleService;
        this.adapter = adapter;
    }
    public String generateSql(List<Criteria> criterias){
        for (Criteria criteria:criterias){
            adapter.processorOperator(criteria);
        }
        return assembleService.assembleSql(criterias);
    }

}

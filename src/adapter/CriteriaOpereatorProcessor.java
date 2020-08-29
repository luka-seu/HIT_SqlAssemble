package adapter;

import entity.Criteria;

/**
 * 根据opereator拼接筛选条件
 */
public interface CriteriaOpereatorProcessor {
   void proceessOperator(Criteria criteria);
}

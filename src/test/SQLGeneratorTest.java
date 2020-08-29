package test;

import adapter.CriteriaOperatorAdapter;
import entity.Criteria;
import entity.SQLFields;
import entity.SQLLinkSymbol;
import entity.SQLOpreatorSymbol;
import org.junit.Assert;
import org.junit.Test;
import service.AbstractSQLAssembleService;
import service.SQLGenerator;

import java.util.ArrayList;
import java.util.List;

public class SQLGeneratorTest {

    CriteriaOperatorAdapter adapter = new CriteriaOperatorAdapter();
    Criteria criteria1 = new Criteria(SQLLinkSymbol.EMPTY, SQLFields.CUSTOMERID, SQLOpreatorSymbol.EQUAL, "htsc");
    Criteria criteria2 = new Criteria(SQLLinkSymbol.AND, SQLFields.CONTACTNAME, SQLOpreatorSymbol.EQUAL, "huawei");
    Criteria criteria3 = new Criteria(SQLLinkSymbol.OR, SQLFields.POSTALCODE, SQLOpreatorSymbol.NOT_EQUAL, "3065");
    Criteria criteria4 = new Criteria(SQLLinkSymbol.AND, SQLFields.COMPANYNAME, SQLOpreatorSymbol.CONTAINS, "nanjing");
    Criteria criteria5 = new Criteria(SQLLinkSymbol.AND, SQLFields.CONTACTTITLE, SQLOpreatorSymbol.IN, "hw,jp,ch,am,hg");
    Criteria criteria6 = new Criteria(SQLLinkSymbol.OR, SQLFields.COUNTRY, SQLOpreatorSymbol.IN, "China,Japan,America,Cannada,Austrilia");


    /**
     * 测试有一个条件没有and或or开头的正常情形
     */
    @Test
    public void testAssembleSqlWithoutBeginning1(){
        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(criteria2);
        criteriaList.add(criteria3);
        criteriaList.add(criteria4);
        criteriaList.add(criteria1);
        criteriaList.add(criteria5);
        SQLGenerator SQLGenerator = new SQLGenerator(AbstractSQLAssembleService.EMPTYLINKBEGINNING,adapter);
        String res = "select * from table where customerId = \"htsc\" and contactName = \"huawei\" or postalCode != \"3065\" and companyName contains \"nanjing\" and contactTitle in (\"hw\",\"jp\",\"ch\",\"am\",\"hg\")";
        Assert.assertEquals(SQLGenerator.generateSql(criteriaList),res);
    }

    /**
     * 测试没有and或or开头的正常情形
     */
    @Test
    public void testAssembleSqlWithBeginning(){
        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(criteria2);
        criteriaList.add(criteria3);
        criteriaList.add(criteria4);
        criteriaList.add(criteria6);
        criteriaList.add(criteria5);
        SQLGenerator SQLGenerator = new SQLGenerator(AbstractSQLAssembleService.ANDLINKBEGINNING,adapter);
        String res = "select * from table where contactName = \"huawei\" or postalCode != \"3065\" and companyName contains \"nanjing\" or country in (\"China\",\"Japan\",\"America\",\"Cannada\",\"Austrilia\") and contactTitle in (\"hw\",\"jp\",\"ch\",\"am\",\"hg\")";
        Assert.assertEquals(SQLGenerator.generateSql(criteriaList),res);
    }
    /**
     * 测试有一个条件没有and或or开头的错误情形
     */
    @Test
    public void testAssembleSqlWithoutBeginning2(){
        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(criteria2);
        criteriaList.add(criteria3);
        criteriaList.add(criteria4);
        criteriaList.add(criteria6);
        criteriaList.add(criteria5);
        SQLGenerator SQLGenerator = new SQLGenerator(AbstractSQLAssembleService.EMPTYLINKBEGINNING,adapter);
        String res = "";
        Assert.assertNotEquals(SQLGenerator.generateSql(criteriaList),res);
    }
    /**
     * 测试没有and或or开头的错误情形
     */
    @Test
    public void testAssembleSqlWithBeginning2(){
        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(criteria2);
        criteriaList.add(criteria3);
        criteriaList.add(criteria4);
        criteriaList.add(criteria1);
        criteriaList.add(criteria5);
        SQLGenerator SQLGenerator = new SQLGenerator(AbstractSQLAssembleService.ANDLINKBEGINNING,adapter);
        String res = "select * from table where contactName = \"huawei\" or postalCode != \"3065\" and companyName contains \"nanjing\"  customerId = \"htsc\" and contactTitle in (\"hw\",\"jp\",\"ch\",\"am\",\"hg\")";
        Assert.assertEquals(SQLGenerator.generateSql(criteriaList),res);
    }


    /**
     * 测试where条件无in的情形，有in的情形之前的测试已包含
     */
    @Test
    public void testInOperator(){
        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(criteria2);
        criteriaList.add(criteria3);
        criteriaList.add(criteria4);
        criteriaList.add(criteria1);
        SQLGenerator SQLGenerator = new SQLGenerator(AbstractSQLAssembleService.ANDLINKBEGINNING,adapter);
        String res = "select * from table where contactName = \"huawei\" or postalCode != \"3065\" and companyName contains \"nanjing\"  customerId = \"htsc\"";
        Assert.assertEquals(SQLGenerator.generateSql(criteriaList),res);
    }

}

package com.thc.dao;
import com.thc.domain.Product;
import com.thc.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
//=================dao层专门负责数据库操作
public class ProductDao {

    //===========查询所有商品信息
    public List<Product> findAllProduct() throws SQLException {
        //利用dbutils,创建QueryRunner核心对象
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        //书写sql语句,查询所有的商品
        String sql = "select * from product";
        //把商品到的商品,转为list集合,泛型为product
        List<Product> products = qr.query(sql, new BeanListHandler<>(Product.class));
        return products;
    }
//=======================查询当前页的产品信息=====================
    public List<Product> findProduct(int pageNo, int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql ="select * from product limit ?,?";
        //limit第一个参数:从数据库中的哪里开始查,索引是从0开始的
        //第二个参数:每次查多少个
        //第一个参数的规律是:当前页数减一,乘以每页查询的个数
        List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class), (pageNo - 1) * pageSize, pageSize);
        return productList;
    }
//===============查询总共有多少条数据=================
    public int findTotalCount() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select count(*) from product";
        Long countL =(Long) qr.query(sql, new ScalarHandler());
        return countL.intValue();
    }
}

package com.thc.service;

import com.thc.dao.ProductDao;
import com.thc.domain.PageBean;
import com.thc.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    //在service层,从dao层获取数据,返回数据给web层

    //=========Service层处理所有商品信息的数据给web层====================
    public List<Product> findAllProuct() throws SQLException {
        ProductDao dao = new ProductDao();
        //调用dao层查询所有的商品
        List<Product> allProduct = dao.findAllProduct();
        return allProduct;
    }

    //============service层查询某个特定页面的数据给web层=================================
    public List<Product> findProduct(int pageNo, int pageSize) throws SQLException {
        ProductDao dao = new ProductDao();
        List<Product> product = dao.findProduct(pageNo, pageSize);
        return product;
    }

    //============service层封装pagebean数据===================================
    public PageBean findPageInfo(int pageNo, int pageSize) throws SQLException {
        ProductDao dao = new ProductDao();
        List<Product> product = dao.findProduct(pageNo, pageSize);
        int totalCount = dao.findTotalCount();
        PageBean pb = new PageBean();
        //封装数据
        pb.setTotalCount(totalCount);
        pb.setPageNo(pageNo);
        pb.setPageSize(pageSize);
        pb.setProducts(product);

        //向上取整,计算总页数,不要忘了乘以1.0,否则会少一页数据
        int totalPage = (int) Math.ceil(totalCount*1.0/pageSize);

        pb.setTotalPage(totalPage);
        //把数据给servlet
        return pb;
    }
}

package com.thc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
    //创建连接池对象
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    //对外提供获取连接池对象的方法
    public static DataSource getDataSource(){
        return ds;
    }
    //对外提供获取连接的方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}

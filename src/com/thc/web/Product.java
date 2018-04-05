package com.thc.web;

import com.alibaba.fastjson.JSONObject;
import com.thc.domain.PageBean;
import com.thc.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Product extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理响应与请求的乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //当前页面
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        //每页的显示条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));



        //由于是显示所有的产品信息,没有参数接收
        //需要调用服务层查找所有数据的方法,获取结果,响应给客户端
        ProductService service = new ProductService();

        try {
           /* //调用业务层的方法,获取所有的商品
            List<com.thc.domain.Product> allProuct = service.findAllProuct();

            //把得到的数据,转为json类型的数据
            String jsonString = JSONObject.toJSONString(allProuct);*/

           //根据当前页和每页显示的数目,来从service层,获取数据
            //List<com.thc.domain.Product> product = service.findProduct(pageNo, pageSize);

            //===============从web层拿到pagebean的数据=================================
            PageBean pageBean = service.findPageInfo(pageNo, pageSize);

            //===============把数据转为json===============================
            String jsonString = JSONObject.toJSONString(pageBean);

            //================回写给浏览器====================
            response.getWriter().write(jsonString);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

package com.example.controller;

import com.example.dao.QueryDao;
import com.example.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json="{}";
        QueryDao dao=new QueryDao();
        List<Province> list= dao.queryProviceList();
        if(list!=null){
            ObjectMapper om=new ObjectMapper();
            json = om.writeValueAsString(list);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();

    }


}

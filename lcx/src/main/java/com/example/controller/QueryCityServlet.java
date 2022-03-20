package com.example.controller;

import com.example.dao.QueryDao;
import com.example.entity.City;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QueryDao dao=new QueryDao();
        String provinceId = request.getParameter("provinceId");
//        System.out.println(provinceId);
//        dao.queryCityList();
        List<City> list = dao.queryCityList(Integer.valueOf(provinceId));
        ObjectMapper om=new ObjectMapper();
        String json="{}";
        json=om.writeValueAsString(list);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}

package com.sd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.Dao.Query;
import com.sd.entity.Province;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("proid");

        Query query=new Query();
        Province province= null;
        province = query.queryName(Integer.valueOf(id));
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper=new ObjectMapper();
        String json = objectMapper.writeValueAsString(province);
        out.println(json);
        out.flush();
        out.close();
    }
}

package com.example.dao;

import com.example.entity.City;
import com.example.entity.Province;
import com.example.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryDao {
    //查询所有的省份信息
    JdbcUtil util=new JdbcUtil();
    public List<Province> queryProviceList(){
        List<Province> list=new ArrayList<>();
        String sql="select * from province";
        PreparedStatement ps = util.createStatement(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id=rs.getInt("id");
                String name =rs.getString("name");
                String jiancheng=rs.getString("jiancheng");
                String shenghui=rs.getString("shenghui");
                Province province=new Province(id,name,jiancheng,shenghui);
                list.add(province);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return list;
    }
    public List<City> queryCityList(Integer id1){
        String sql ="select * from city where provinceId=?";
        PreparedStatement ps = util.createStatement(sql);
        List<City> list=new ArrayList<>();
        try {
            ps.setInt(1,id1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id=rs.getInt("id");
                String name =rs.getString("name");
                Integer provinceId=rs.getInt("provinceId");
                City city=new City(id,name,provinceId);
                list.add(city);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return list;
    }
}

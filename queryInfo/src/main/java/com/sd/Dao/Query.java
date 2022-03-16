package com.sd.Dao;

import com.sd.entity.Province;
import com.sd.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {
    private JdbcUtil util=new JdbcUtil();
    public Province queryName(Integer id1){
        String sql="select id,name,jiancheng,shenghui from province where id=?";
        ResultSet resultSet=null;
        String name = null;
        String jiancheng=null;
        String shenghui=null;
        Province province=null;
        PreparedStatement ps = util.createStatement(sql);

        try {
            ps.setInt(1,id1);
            resultSet= ps.executeQuery();
            while (resultSet.next()){
                Integer id= resultSet.getInt("id");
                 name = resultSet.getString("name");
                jiancheng = resultSet.getString("jiancheng");
                shenghui = resultSet.getString("shenghui");
                 province=new Province(id,name,jiancheng,shenghui);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return province;
    }
}

package com.dawn.sqltool;

import com.dawn.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Querry {

    private Connection connection = new SqlConnect().creatConnection();

    public Querry() throws Exception {
    }

    public User querryById(String id) throws Exception {

        String sql = "select * from users where uid=?";
        PreparedStatement prestmt = this.connection.prepareStatement(sql);
        prestmt.setString(1,id);
        ResultSet res = prestmt.executeQuery();

        User user = new User();
        user.setUid(id);
        if(res.next()){
            if(res.getString("date")!=null){
                user.setDate_str(res.getString("date"));
            }
            user.setName(res.getString("name"));
            user.setLatest_dyId(res.getString("dyId"));
        }else{
            user = null;
        }

        res.close();
        prestmt.close();

        return user;
    }

    public List<String> querryId() throws Exception {
        Statement statement = this.connection.createStatement();
        String sql = "select uid from users";
        ResultSet res = statement.executeQuery(sql);
        List<String> list = new ArrayList<>();
        while(res.next()){
            list.add(res.getString("uid"));
        }

        res.close();
        statement.close();

        return list;
    }

    public void close() throws InterruptedException {
        try {
            this.connection.close();
            System.out.println("关闭 connection 成功");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("关闭 connection 异常，稍后重试");
            Thread.sleep(500l);
            this.close();
        }

    }


}

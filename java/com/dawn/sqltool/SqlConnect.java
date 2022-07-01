package com.dawn.sqltool;

import com.dawn.mylog.LogOutput;
import com.dawn.pojo.Configure;
import com.dawn.readtool.Readconf;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class SqlConnect {

    public SqlConnect() {
    }

    public Connection creatConnection() throws Exception {
        //用户信息、URL(固定写法)
        Class.forName("com.mysql.cj.jdbc.Driver");
        Configure configure = new Readconf().read();
        String pwd=configure.getSqlpassword();
        String url="jdbc:mysql://localhost:3306/"+configure.getDatabase()+"?useUnicode=true&useCharacter=utf8&useSSL=true&serverTimezone=Asia/Shanghai&useTimezone=true";
        String user="root";//用户名

        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            System.out.println("Link Successfully " + new Date());
            return connection;
        }catch (SQLException e){
            System.out.println("连接失败,十秒后重试 " + new Date());

            new LogOutput().error_Write("MySQL链接异常 "
                    + new Date() +' '
                    + e.toString() +' '
                    + configure.toString());

            Thread.sleep(10*1000L);
            return this.creatConnection();
        }

    }
}

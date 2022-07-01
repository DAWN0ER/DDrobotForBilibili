package com.dawn.sqltool;

import com.dawn.pojo.TimeUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class Update {
    public Update() {
    }

    public void updateById(String uid,Date date, String dyId) throws Exception {
        Connection con = new SqlConnect().creatConnection();
        String sql = "update users set dyId=?, date=? where uid=?";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,dyId);
        pstmt.setString(2,new TimeUtils().dateToStr(date));
        pstmt.setString(3,uid);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();

        return;
    }

}

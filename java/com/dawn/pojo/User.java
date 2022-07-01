package com.dawn.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String uid;
    private String name;
    private Date latest_date;
    private String date_str;
    private String latest_dyId;

    public User() {
    }

    public String getLatest_dyId() {
        return latest_dyId;
    }

    public void setLatest_dyId(String latest_dyId) {
        this.latest_dyId = latest_dyId;
    }

    public String getDate_str() {
        return date_str;
    }

    public void setDate_str(String date_str) throws ParseException {
        this.date_str = date_str;
        this.latest_date=new TimeUtils().strToDate(date_str);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLatest_date() {
        return latest_date;
    }

    public void setLatest_date(Date latest_date){
        this.latest_date = latest_date;
        this.date_str = new TimeUtils().dateToStr(latest_date);

    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", date_str='" + date_str + '\'' +
                ", latest_dyId='" + latest_dyId + '\'' +
                '}';
    }
}

package com.dawn.pojo;

import java.util.Date;

public class LogInfo {

    private String date;

    private String dynamic_id;
    private String dynamic_content;
    private String comment;

    public LogInfo() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date){
        this.date=new TimeUtils().dateToStr(date);
    }

    public String getDynamic_id() {
        return dynamic_id;
    }

    public void setDynamic_id(String dynamic_id) {
        this.dynamic_id = dynamic_id;
    }

    public String getDynamic_content() {
        return dynamic_content;
    }

    public void setDynamic_content(String dynamic_content) {
        this.dynamic_content = dynamic_content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "LogInfo{" +
                "date='" + date + '\'' +
                ", dynamic_id='" + dynamic_id + '\'' +
                ", dynamic_content='" + dynamic_content + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

}

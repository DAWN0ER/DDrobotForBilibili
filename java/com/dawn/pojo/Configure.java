package com.dawn.pojo;

public class Configure {

    private String sqlpassword = null;
    private String database = null;
    private String SESSDATA = null ;
    private String csrf = null ;
    private String comment = null;

    public Configure() {

    }

    @Override
    public String toString() {
        return "Configure{" +
                "sqlpassword='" + sqlpassword + '\'' +
                ", database='" + database + '\'' +
                ", SESSDATA='" + SESSDATA + '\'' +
                ", csrf='" + csrf + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getSESSDATA() {
        return SESSDATA;
    }

    public String getCsrf() {
        return csrf;
    }

    public String getSqlpassword() {
        return sqlpassword;
    }

    public String getDatabase() {
        return database;
    }

    public String getComment() {
        return comment;
    }

    public void fastSet(String member, String value){
        switch (member){
            case "SESSDATA" : this.SESSDATA=value;break;
            case "sqlpassword" : this.sqlpassword=value;break;
            case "csrf" : this.csrf=value;break;
            case "database" : this.database=value;break;
            case "comment" : this.comment=value;break;
        }
    }

    public void fastSet(String[] a){
        if(a.length==2){
            fastSet(a[0],a[1]);
        }else{
            return;
        }
    }

}

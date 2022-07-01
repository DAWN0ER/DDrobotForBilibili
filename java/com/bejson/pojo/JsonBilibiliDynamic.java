/**
  * Copyright 2022 bejson.com 
  */
package com.bejson.pojo;

/**
 * Auto-generated: 2022-05-22 20:8:12
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonBilibiliDynamic {

    private int code;
    private String msg;
    private String message;
    private Data data;
    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setMsg(String msg) {
         this.msg = msg;
     }
     public String getMsg() {
         return msg;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setData(Data data) {
         this.data = data;
     }
     public Data getData() {
         return data;
     }

     /*
     快速方法
      */
    public String getDynamicId(){
        return this.data.getCards().get(0).getDesc().getDynamic_id_str();
    }


}
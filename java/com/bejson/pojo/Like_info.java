/**
  * Copyright 2022 bejson.com 
  */
package com.bejson.pojo;
import java.util.List;

/**
 * Auto-generated: 2022-05-22 20:8:12
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Like_info {

    private String display_text;
    private List<Like_users> like_users;
    public void setDisplay_text(String display_text) {
         this.display_text = display_text;
     }
     public String getDisplay_text() {
         return display_text;
     }

    public void setLike_users(List<Like_users> like_users) {
         this.like_users = like_users;
     }
     public List<Like_users> getLike_users() {
         return like_users;
     }

}
package com.dawn.pojo;

import com.dawn.readtool.Readconf;
import java.util.Date;

public class Comment {

    public Comment(){
    }

    public String set(String name, Date date) throws Exception {
        String module = null;
        module=new Readconf().read().getComment();
        module=module.replace("#name#",name);
        module=module.replace("#time#",new TimeUtils().natureTime(date));
        return module;
    }
}

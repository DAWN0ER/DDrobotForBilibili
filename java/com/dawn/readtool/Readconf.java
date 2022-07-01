package com.dawn.readtool;

import com.dawn.pojo.Configure;

import java.io.*;

public class Readconf {
    public Readconf() {
    }

    public Configure read() throws Exception{
        File conf = new File("../DDrobot.conf");
        FileInputStream readin = new FileInputStream(conf);
        InputStreamReader reader = new InputStreamReader(readin,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);

        Configure configure = new Configure();
        String txt;

        while((txt=bufferedReader.readLine())!=null){
            char s =txt.trim().charAt(0);
            //reanline读第一行时第一个字符是空字符,替换掉，65279是空字符
            if(s==65279){
                if(txt.length()>1){
                    txt=txt.substring(1);
                }
            }
            configure.fastSet(txt.split("="));
        }


        bufferedReader.close();
        reader.close();
        readin.close();

        return configure;
    }

}

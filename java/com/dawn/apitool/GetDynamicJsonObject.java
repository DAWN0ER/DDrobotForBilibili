package com.dawn.apitool;

import com.alibaba.fastjson.JSON;
import com.bejson.pojo.JsonBilibiliDynamic;
import com.dawn.mylog.LogOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class GetDynamicJsonObject {
    public GetDynamicJsonObject() {
    }

    public JsonBilibiliDynamic getByUid(String uid) throws IOException, InterruptedException {
        String apiStr = "https://api.vc.bilibili.com/dynamic_svr/v1/dynamic_svr/space_history?host_uid=";
        String urlStr = apiStr + uid;
        URL url = new URL(urlStr);
        StringBuffer document=new StringBuffer();
        try{
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line = null;
            while((line=reader.readLine())!=null){
                document.append(line);
            }
            reader.close();
            JsonBilibiliDynamic dynamic = JSON.parseObject(document.toString(),JsonBilibiliDynamic.class);
            return dynamic;
        }catch (IOException e ){
            e.printStackTrace();
            System.out.println("URL请求失败,半小时后重试 " + new Date());

            new LogOutput().error_Write("URL请求获取动态异常 "
                    + new Date() +' '
                    + e.toString());

            Thread.sleep(30*60*1000L);
            return getByUid(uid);

        }catch (NegativeArraySizeException e){
            e.printStackTrace();
            System.out.println("返回空Json，30秒后重试 " + new Date());

            new LogOutput().error_Write("空Json异常 "
                    + new Date() +' '
                    + e.toString());

            Thread.sleep(30*1000L);
            return getByUid(uid);
        }

    }

}

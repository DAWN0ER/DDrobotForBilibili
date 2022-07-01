package com.dawn.apitool;

import com.dawn.pojo.Configure;
import com.dawn.readtool.Readconf;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.util.ArrayList;
import java.util.List;

public class SentComment {
    public SentComment() {
    }

    public String commentByDynamicId(String dynamicId,String comment) throws Exception {
        String url = "https://api.bilibili.com/x/v2/reply/add";
        Configure conf = new Readconf().read();

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost post =new HttpPost(url);

        List<NameValuePair> params=new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("type","17"));
        params.add(new BasicNameValuePair("oid",dynamicId));
        params.add(new BasicNameValuePair("message",comment));
        params.add(new BasicNameValuePair("csrf", conf.getCsrf()));

        post.setHeader("Cookie","SESSDATA="+conf.getSESSDATA());
        post.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
        HttpResponse response = client.execute(post);

        client.close();
        return response.toString();
    }
}

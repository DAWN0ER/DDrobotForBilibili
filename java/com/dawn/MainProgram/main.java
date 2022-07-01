package com.dawn.MainProgram;

import com.bejson.pojo.JsonBilibiliDynamic;
import com.dawn.apitool.GetDynamicJsonObject;
import com.dawn.apitool.SentComment;
import com.dawn.mylog.LogOutput;
import com.dawn.pojo.Comment;
import com.dawn.pojo.DyContent;
import com.dawn.pojo.LogInfo;
import com.dawn.pojo.User;
import com.dawn.sqltool.Querry;
import com.dawn.sqltool.Update;

import java.util.Date;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        while(true){

            Querry querry = new Querry();
            List<String> uidList = querry.querryId();

            for(String uid : uidList){

                JsonBilibiliDynamic dynamic = new GetDynamicJsonObject().getByUid(uid);
                String dyId = dynamic.getDynamicId();
                User user = querry.querryById(uid);
                System.out.println(user.toString());

                if(dyId.compareTo(user.getLatest_dyId())>0){

                    Date now = new Date();
                    String comment = new Comment().set(user.getName(),user.getLatest_date());

                    new SentComment().commentByDynamicId(dyId,comment);
                    new Update().updateById(user.getUid(),now,dyId);

                    LogInfo logInfo = new LogInfo();
                    logInfo.setDynamic_content(new DyContent(dynamic).getContent());
                    logInfo.setDate(now);
                    logInfo.setComment(comment);
                    logInfo.setDynamic_id(dyId);
                    new LogOutput().write(logInfo);

                }

                //休眠防止网页爬崩溃
                Thread.sleep(2*1000l);
            }

            querry.close();
            Thread.sleep(1000l);

        }

    }


}

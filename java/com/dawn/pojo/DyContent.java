package com.dawn.pojo;

import com.bejson.pojo.JsonBilibiliDynamic;

public class DyContent {

    private String content = "视频，专栏，相册，直播或其他动态";

    public DyContent(JsonBilibiliDynamic dynamic) {
        String card=dynamic.getData().getCards().get(0).getCard();
        String prefix=", \"content\": \"";
        String postfix="\", \"ctrl\": \"";
        int begin=card.indexOf(prefix);
        int end=card.indexOf(postfix,begin);
        if(begin>=0&&end>0&&begin<end){
            this.content=card.substring(begin,end).replace(prefix,"");
        }
    }

    public String getContent() {
        return content;
    }

}

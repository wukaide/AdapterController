package com.jsoup;

import android.os.Handler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by 273 on 2016/3/23.
 */
public class TestJsoup {
    public static void getHtml(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://news.163.com/";
                Connection conn = Jsoup.connect(url);
                conn.header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/    20100101 Firefox/32.0");

                try {
                    Document doc = conn.get();
                    //获取tbody元素下的所有tr元素
                    Elements elements = doc.select("div.ns-main");
                    for (Element element:elements){
                        String companyName = element.select("h3").text();
                        String linkHref = element.getElementsByTag("a").attr("href");
                        //String picUrl = element.getElementsByTag("a").select("img").text();
                        System.out.println("标题："+companyName);
                        System.out.println("href："+linkHref);
                        //System.out.println("图片Url：" + picUrl);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}

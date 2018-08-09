package com.veritagis.blitz3news.app;

import com.veritagis.blitz3news.R;
import com.veritagis.blitz3news.Utils.MyApplication;


/**
 * Created by LSN-ANDROID2 on 09-08-2018.
 */

public class AppConfig {
    public static String searchUrl[] = {MyApplication.getInstance().getApplicationContext().getString(R.string.bbc_url_search),
            MyApplication.getInstance().getApplicationContext().getString(R.string.foxnews_url_sarch),
            MyApplication.getInstance().getApplicationContext().getString(R.string.cnn_url_search),
            MyApplication.getInstance().getApplicationContext().getString(R.string.cnbc_url_search),
            MyApplication.getInstance().getApplicationContext().getString(R.string.buzzfeed_url_search),
            MyApplication.getInstance().getApplicationContext().getString(R.string.yahoo_news_url_search)};

}

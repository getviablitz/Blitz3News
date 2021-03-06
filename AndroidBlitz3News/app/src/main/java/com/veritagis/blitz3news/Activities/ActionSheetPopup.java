package com.veritagis.blitz3news.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.veritagis.blitz3news.Adapter.ActionSheetAdapter;
import com.veritagis.blitz3news.R;
import com.veritagis.blitz3news.Utils.ActionSheetGroupItem;
import com.veritagis.blitz3news.Utils.PrefUtil;

import java.util.ArrayList;

public class ActionSheetPopup extends Dialog implements View.OnClickListener {

    public static ArrayList<ActionSheetGroupItem> selectedList = new ArrayList<>(3);
    public Activity mContext;
    private ListView mListView;

    public ActionSheetPopup(Activity mContext) {
        super(mContext);
        this.mContext = mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_action_sheet);

        ImageView cancel_btn = findViewById(R.id.cancel_btn);

        mListView = findViewById(R.id.mlistView);

        cancel_btn.setOnClickListener(this);

        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().setDimAmount(0.3f);
        setCanceledOnTouchOutside(false);
        assert ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)) != null;
        Display display = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        getWindow().setLayout((width), (3 * height) / 6);
        //initCheckBox();
        selectedList.clear();
        ArrayList<ActionSheetGroupItem> mList = getData();
        for (ActionSheetGroupItem modelNew : mList) {
            if (modelNew.url.equals(PrefUtil.getString(mContext, "socialFeedLeft", mContext.getString(R.string.foxnews_url)))) {
                ActionSheetPopup.selectedList.add(modelNew);
            }
            if (modelNew.url.equals(PrefUtil.getString(mContext, "socialFeedMiddle", mContext.getString(R.string.bbc_url)))) {
                ActionSheetPopup.selectedList.add(modelNew);
            }
            if (modelNew.url.equals(PrefUtil.getString(mContext, "socialFeedRight", mContext.getString(R.string.cnn_url)))) {
                ActionSheetPopup.selectedList.add(modelNew);
            }
        }
        ActionSheetAdapter actionSheetAdapter = new ActionSheetAdapter(mContext, mList);
        mListView.setAdapter(actionSheetAdapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel_btn: {
                dismiss();
                break;
            }

        }
    }


    private ArrayList<ActionSheetGroupItem> getData() {

//        Social
//        1)Facebook
//        2)Twitter
//        3)Insta
//        4)LinkedIn
//        5)Google+
//        6)Quora
//
//        E-Commerce
//        1)Best-Buy
//        2)Amazon
//        3)Alibaba
//        4)Wal-mart
//        5)costco
//        6)Nordstorm
//
//         NewsChannels
//        1)Foxnews
//        2)BBC News
//        3)CNN News
//        4)CNBC News
//        5)Buzz feed
//        6)Yahoo News

        ArrayList<ActionSheetGroupItem> mList = new ArrayList<>();

        //social
        mList.add(new ActionSheetGroupItem("FoxNews", true, mContext.getString(R.string.foxnews_url)));
        mList.add(new ActionSheetGroupItem("BBC", true, mContext.getString(R.string.bbc_url)));
        mList.add(new ActionSheetGroupItem("CNN", true, mContext.getString(R.string.cnn_url)));
        mList.add(new ActionSheetGroupItem("CNBC", mContext.getString(R.string.cnbc_url)));
        mList.add(new ActionSheetGroupItem("Buzz", mContext.getString(R.string.buzzfeed_url)));
        mList.add(new ActionSheetGroupItem("Yahoo", mContext.getString(R.string.yahoo_news_url)));

        return mList;
    }

}
package com.example.francoliu.actionbartool;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by franco on 19/11/2016.
 */

public class KlozrBottomToolBar extends RelativeLayout implements  View.OnClickListener {

    boolean debugMode=false;

    public interface ButtomBarButtonEvent{
        public void onButtonClicked(View view);

    }


    private ButtomBarButtonEvent Event;

    public KlozrBottomToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setEventListener(ButtomBarButtonEvent event) {
        Event = event;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    static public KlozrBottomToolBar CreateNewToolBar(Context context,int resource)
    {
        //inflator.inflate(R.id.bottom_tool_layout, null);
        return  (KlozrBottomToolBar)LayoutInflater.from(context).inflate(resource,null);
    }

    public void setResourceId(Context context,int id)
    {
        //inflator.inflate(R.id.bottom_tool_layout, null);
        LayoutInflater.from(context).inflate(R.layout.bottom_tool_bar_view,null);
    }

    public RelativeLayout.LayoutParams getInitLayoutStyle()
    {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);


        return  lp;
    }

    public KlozrBottomToolBar(Context context) {
        super(context );
    }


    public void InitBottomBar()
    {


        if (debugMode)
           this.setBackgroundResource(R.color.colorActionBarDebug);

        for(int index = 0; index<((ViewGroup)this).getChildCount(); ++index) {
            View nextChild = ((ViewGroup)this).getChildAt(index);
            nextChild.setOnClickListener(this);
            if ((nextChild instanceof ImageView)&& (debugMode)) {
                ImageView imageView = (ImageView) nextChild;
                imageView.setImageResource(R.mipmap.ic_launcher);
                imageView.setBackgroundResource(R.color.colorMenuItemDebug);
                // do what you want with imageView
            }
        }

    }



    @Override
    public void onClick(View view) {
        int y=0;
        if (view.getId() == R.id.btn_left) {
            y=0;

        }

        if (view.getId() == R.id.btn_right2) {
            y=0;

        }

        if (view.getId() == R.id.btn_right) {
            y=0;

        }
        Event.onButtonClicked(view);
        return;
    }

    public static class Builder {

        KlozrBottomToolBar KlozrBottomToolBar;
        Context context;

        public Builder(Context context,int resource) {
            this.KlozrBottomToolBar = KlozrBottomToolBar.CreateNewToolBar(context,resource);
            this.context=context;
        }

        public Builder setResourceId(int resourceId)
        {
            this.KlozrBottomToolBar.setResourceId(this.context,resourceId);
            return this;
        }

        public Builder setParent(ViewGroup View)
        {
            View.addView(KlozrBottomToolBar,KlozrBottomToolBar.getInitLayoutStyle());
            return this;
        }

        public Builder setDebugMode(boolean mode)
        {
            KlozrBottomToolBar.setDebugMode(mode);
            return this;
        }
        public Builder setToolBarListener(ButtomBarButtonEvent event)
        {
            KlozrBottomToolBar.setEventListener(event);
            return this;
        }



        public KlozrBottomToolBar build() {

            KlozrBottomToolBar.InitBottomBar();
            return KlozrBottomToolBar;
        }


    }
}

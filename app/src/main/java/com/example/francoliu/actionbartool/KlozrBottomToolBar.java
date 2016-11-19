package com.example.francoliu.actionbartool;

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

    final boolean debugMode=true;

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
    static public KlozrBottomToolBar CreateNewToolBar(Context context)
    {
        //inflator.inflate(R.id.bottom_tool_layout, null);
        return  (KlozrBottomToolBar)LayoutInflater.from(context).inflate(R.layout.bottom_tool_bar_view,null);
    }

    public RelativeLayout.LayoutParams getInitLayoutStyle()
    {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        //lp.setPadding(0,10,0,10);

        return  lp;
    }

    public KlozrBottomToolBar(Context context) {
        super(context );
    }

    public void CreateBottomBar()
    {
        for(int index = 0; index<((ViewGroup)this).getChildCount(); ++index) {
            View nextChild = ((ViewGroup)this).getChildAt(index);
            nextChild.setOnClickListener(this);


        }

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
}

package com.example.francoliu.actionbartool;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements KlozrBottomToolBar.ButtomBarButtonEvent,KlozrActionBar.ActionButtonEvent {

    KlozrBottomToolBar ToolBarViewLayout;
    KlozrBottomToolBar ToolBarViewLayout2;
    KlozrActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout main_Layout = (RelativeLayout) findViewById(R.id.activity_main);


       /* KlozrActionBar actionBar=new KlozrActionBar(this,R.layout.main_menu_view);
        actionBar.CreateActionBar();
        actionBar.setEventListener(this);*/

        actionBar=new KlozrActionBar.Builder(this,R.layout.main_menu_view)
                .setEventListener(this)
                .setDebugMode(true)
                .build();



        ToolBarViewLayout=new KlozrBottomToolBar.Builder(this,R.layout.bottom_tool_bar_view)
                .setParent(main_Layout)
                .setDebugMode(true)
                .setToolBarListener(this)
                .build();


       // main_Layout.setPadding(0,GetActionBarHeiht(),0,0);
    }





    @Override
    public boolean onTouchEvent(MotionEvent event) {



        return super.onTouchEvent(event);



        /*if (actionBar.isShowing())
            actionBar.hide();
        else
            actionBar.show();*/

        //actionBar1.hide();
        //actionBar1.show();


    }


    @Override
    public void onButtonClicked(View view) {
        ActionBar actionBar;

        actionBar=this.getSupportActionBar();
        if (actionBar.isShowing())
            actionBar.hide();
        else
            actionBar.show();
    }

    @Override
    public void onActionButtonClicked(View view) {

    }
}

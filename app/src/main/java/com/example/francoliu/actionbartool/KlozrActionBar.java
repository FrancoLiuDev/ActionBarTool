package com.example.francoliu.actionbartool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by francoliu on 18/11/2016.
 */

public class KlozrActionBar implements View.OnClickListener {

    public interface ActionButtonEvent{
        public void onActionButtonClicked(View view);

    }

    private int MenuResourceID;
    private AppCompatActivity activity;
    private ActionButtonEvent Event;

    final boolean debugMode=false;

    public KlozrActionBar(AppCompatActivity activity,int resource)
    {
        this.activity=activity;
        this.MenuResourceID=resource;
    }

    public void setEventListener(ActionButtonEvent event) {
        Event = event;
    }

    public ActionBar getActionBar()
    {
        return activity.getSupportActionBar();
    }

    public View createActionBarView() {

        LayoutInflater inflator = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view= inflator.inflate(MenuResourceID, null);

        return view;


    }

    public View initActionBarView(View view) {

        view.setOnClickListener(this);

        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);
        parent.setContentInsetsRelative(0,0);

        initActionBarViewListener(view);

        return view;
    }
    public void  initActionBarViewListener(View view){

        for(int index=0; index<((ViewGroup)view).getChildCount(); ++index) {
            View nextChild = ((ViewGroup)view).getChildAt(index);
            nextChild.setOnClickListener(this);
            if ((nextChild instanceof ImageView)&& (debugMode)) {
                ImageView imageView = (ImageView) nextChild;
                imageView.setImageResource(R.mipmap.ic_launcher);
                imageView.setBackgroundResource(R.color.colorMenuItemDebug);
                // do what you want with imageView
            }
        }





    }

    public int GetActionBarHeight()
    {
        int actionBarHeight=0;

        TypedValue tv = new TypedValue();
        if (activity.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,activity.getResources().getDisplayMetrics());
        }

        return actionBarHeight;
    }

    public void CreateActionBar() {

        ActionBar actionBar = getActionBar();
        View view  = createActionBarView();

        if (debugMode)
            view.setBackgroundResource(R.color.colorActionBarDebug);

        ActionBar.LayoutParams layout = new ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT);
        actionBar.setCustomView(view, layout);


        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setShowHideAnimationEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#99ffffff")));

        initActionBarView(view);


        //actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
    }

    private void showActionBar2()
    {
        ActionBar actionBar = activity.getSupportActionBar();

        if (actionBar.isShowing())
            actionBar.hide();
        else
            actionBar.show();
    }

    @Override
    public void onClick(View view) {


        int y=0;
        if (view.getId() == R.id.btn_left) {
            showActionBar2();

        }

        if (view.getId() == R.id.btn_right2) {
            y=0;

        }

        if (view.getId() == R.id.btn_right) {


        }

        Event.onActionButtonClicked(view);
        return;
    }
}

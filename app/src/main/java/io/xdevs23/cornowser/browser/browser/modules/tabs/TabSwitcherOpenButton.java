package io.xdevs23.cornowser.browser.browser.modules.tabs;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.xdevs23.ui.touch.PressHoverTouchListener;

import io.xdevs23.cornowser.browser.CornBrowser;
import io.xdevs23.cornowser.browser.R;
import io.xdevs23.cornowser.browser.browser.modules.ColorUtil;

public class TabSwitcherOpenButton extends RelativeLayout {

    private String tabCount = "0";
    private Context myContext;

    public TabSwitcherOpenButton(Context context) {
        super(context);
        init(context);
    }

    public TabSwitcherOpenButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabSwitcherOpenButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TabSwitcherOpenButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        if(CornBrowser.getContext() != null) {
            if (myContext == null) myContext = context;
            setGravity(Gravity.CENTER);

            ImageView img = new ImageView(getContext());
            img.setImageResource(R.drawable.omnibox_tabswitch_icon);
            addView(img);

            TextView t = new TextView(getContext());
            t.setTextSize(14f);
            t.setText(tabCount);
            addView(t);

            t.bringToFront();

            setOnTouchListener(new PressHoverTouchListener(Color.TRANSPARENT,
                    ColorUtil.getColor(R.color.grey_400)));
        }
    }

    public void setTabCount(int count) {
        tabCount = String.valueOf(count);
        ((TextView)getChildAt(1)).setText(tabCount);
    }

}
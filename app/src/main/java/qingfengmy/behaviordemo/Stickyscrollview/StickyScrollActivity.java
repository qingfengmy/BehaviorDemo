package qingfengmy.behaviordemo.Stickyscrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import qingfengmy.behaviordemo.R;

/**
 * 固定头部的ScrollView
 */
public class StickyScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_scroll);
        setTitle("固定头部的ScrollView");
        StickyScrollView view_hover = (StickyScrollView) findViewById(R.id.stickyScrollview);
        view_hover.setTopView(R.id.top);
    }
}

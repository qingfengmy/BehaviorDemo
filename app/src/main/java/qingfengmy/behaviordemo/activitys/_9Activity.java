package qingfengmy.behaviordemo.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import qingfengmy.behaviordemo.R;

/**
 * 当子View滑动的时候碰到了父View边缘的时候让父View也一起滑动
 *
 * //子View需实现的接口
 * NestedScrollingChild
 *
 * //父View实现的接口
 * NestedScrollingParent
 *
 * //子View的帮助类
 * NestedScrollingChildHelper
 *
 * //父View 的帮助类
 * NestedScrollingParentHelper
 */
public class _9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__9);
    }
}

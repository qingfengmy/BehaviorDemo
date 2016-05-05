package qingfengmy.behaviordemo.Stickyscrollview;

import android.content.Context;
import android.widget.ScrollView;

/**
 * Created by michael on 2016/2/3.
 */
public class MyScrollView extends ScrollView {
    private StickyScrollView mScrollView;

    public MyScrollView(Context context, StickyScrollView scrollView) {
        super(context);
        mScrollView = scrollView;
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        mScrollView.onScroll(t);
    }

}
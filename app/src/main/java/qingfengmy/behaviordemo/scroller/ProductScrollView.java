package qingfengmy.behaviordemo.scroller;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.listchange.DeviceUtil;


/**
 * 商品详情页使用的ScrollView.
 */
public class ProductScrollView extends ScrollView {
    TabLayout tabLayout;
    LinearLayout topLayout;
    ProductViewPager viewPager;
    boolean isFirst;
    int topHeight;
    boolean dispatch;

    public ProductScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    LinearLayout layout;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        topLayout = (LinearLayout) findViewById(R.id.topLayout);
        layout = (LinearLayout) findViewById(R.id.layout);
        isFirst = true;
        viewPager = (ProductViewPager) findViewById(R.id.viewPager);
        postDelayed(new Runnable() {
            @Override
            public void run() {
                topHeight = topLayout.getMeasuredHeight() + DeviceUtil.dp2px(getContext(), 10) - DeviceUtil.dp2px(getContext(),48);
            }
        }, 100);
    }

    public void setDispatch(boolean dispatch) {
        Log.e("aaa","set dispatch="+dispatch);
        this.dispatch = dispatch;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Log.e("aaa", "t=" + t + ",oldt=" + oldt + ",dispatch=" + dispatch);
        if (t > topHeight && !dispatch) {
            setDispatch(true);
        } else if (t == topHeight && (t - oldt) < 0 && !dispatch) {
            setDispatch(true);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("aaa", "scrollview dispatch=" + dispatch);

        if (dispatch) {
            return viewPager.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e("aaa","y="+ev.getY());
        return super.onTouchEvent(ev);
    }
}

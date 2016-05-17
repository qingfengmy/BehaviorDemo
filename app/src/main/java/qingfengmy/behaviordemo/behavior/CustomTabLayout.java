package qingfengmy.behaviordemo.behavior;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/5/17.
 */
public class CustomTabLayout extends TabLayout {
    private boolean intercept;
    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 默认拦截
        this.intercept = true;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return intercept;
    }

    public void setIntercept(boolean intercept) {
        this.intercept = intercept;
    }
}

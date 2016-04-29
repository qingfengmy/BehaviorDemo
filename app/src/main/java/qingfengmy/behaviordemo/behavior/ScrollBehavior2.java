package qingfengmy.behaviordemo.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/4/29.
 */
public class ScrollBehavior2 extends CoordinatorLayout.Behavior {
    public ScrollBehavior2() {
        super();
    }

    public ScrollBehavior2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & View.SCROLL_AXIS_VERTICAL) != 0;
    }
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        dy = dy / 3;
        //简单消耗掉一半的距离
        consumed[1] += dy;
        child.offsetTopAndBottom(dy);
    }
}

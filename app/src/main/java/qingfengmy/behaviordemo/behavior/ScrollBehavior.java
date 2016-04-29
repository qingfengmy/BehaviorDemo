package qingfengmy.behaviordemo.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/4/28.
 */
public class ScrollBehavior extends CoordinatorLayout.Behavior<NestedScrollView> {
    public ScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 这里的返回值表明这次滑动我们要不要关心，我们要关心什么样的滑动
     *
     * @param coordinatorLayout coordinatorLayout
     * @param child             拥有当前Behavior的View
     * @param directTargetChild
     * @param target        参考的View
     * @param nestedScrollAxes  滚动轴
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, NestedScrollView child, View directTargetChild, View target, int nestedScrollAxes) {
        // 关心y轴上的滚动
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, NestedScrollView child, View target, int dx, int dy, int[] consumed) {
        // 当前view根据参考的view滚动
        int leftScrolled = target.getScrollY();
        child.setScrollY(leftScrolled);
    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, NestedScrollView child, View target, float velocityX, float velocityY) {
        ((NestedScrollView) child).fling((int)velocityY);
        return true;
    }
}

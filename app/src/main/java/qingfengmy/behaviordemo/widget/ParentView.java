package qingfengmy.behaviordemo.widget;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;


/**
 * Created by Luo on 2015/9/17.
 * //父View实现的接口
 * NestedScrollingParent
 * //父View 的帮助类
 * NestedScrollingParentHelper
 */
public class ParentView extends FrameLayout implements NestedScrollingParent {
    private NestedScrollingParentHelper parentHelper;


    public ParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        parentHelper = new NestedScrollingParentHelper(this);
    }

    //子类请求滑动startNestedScroll()

    /**
     * 是否是关注的View
     *
     * @param child            当前View
     * @param target           关注的View
     * @param nestedScrollAxes 滚动轴
     * @return
     */
    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.e("aaa", "parent-onStartNestedScroll-axes=" + nestedScrollAxes);
        return true;// super.onStartNestedScroll(child, target, nestedScrollAxes);
    }


    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        parentHelper.onNestedScrollAccepted(child, target, axes);
        Log.e("aaa", "parent-onStartNestedScroll-axes=" + axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        parentHelper.onStopNestedScroll(child);
    }


    /**
     * 子类滑动事件分发回调dispatchNestedPreScroll
     *
     * @param target
     * @param dx       水平滚动的像素值
     * @param dy       垂直滚动的距离像素值
     * @param consumed consumed[0] ：dx消耗掉的部分 consumed[1] : dy消费的部分
     * @return 如果父view消费了一些或全部，则返回true
     */
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        if (dx > 0) {
            if (target.getRight() + dx > getWidth()) {
                dx = target.getRight() + dx - getWidth();
                offsetLeftAndRight(dx);
                consumed[0] += dx;   //将消耗掉的距离返回给子类
            }
        } else {
            if (target.getLeft() + dx < 0) {
                dx = target.getLeft() + dx;
                offsetLeftAndRight(dx);
                consumed[0] += dx;
            }
        }

        if (dy > 0) {
            if (target.getBottom() + dy > getHeight()) {
                dy = target.getBottom() + dy - getHeight();
                offsetTopAndBottom(dy);
                consumed[1] += dy;
            }
        } else {
            if (target.getTop() + dy < 0) {
                dy = target.getTop() + dy;
                offsetTopAndBottom(dy);
                consumed[1] += dy;
            }
        }

    }

    /**
     * 子类滑动事件分发回调
     *
     * @return
     */
    @Override
    public int getNestedScrollAxes() {
        return parentHelper.getNestedScrollAxes();
    }
}

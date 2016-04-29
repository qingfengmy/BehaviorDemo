package qingfengmy.behaviordemo.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/4/28.
 * 根据TextView的位置变化，修改当前View的位置
 */
public class DependentBehavior extends CoordinatorLayout.Behavior<View> {
    // 注意一下，带有参数的这个构造必须要重载，因为在CoordinatorLayout里利用反射去获取这个Behavior的时候就是拿的这个构造。
    public DependentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 判断是否是我们关心的View，Button
     * @param parent CoordinatorLayout
     * @param child 当前View
     * @param dependency 参考/依赖的View
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        Log.e("aaa",dependency.getClass().getName());
        return dependency instanceof Button;
    }

    /**
     * 根据dependency改动，我们的View也改动
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Log.e("aaa","onDependentViewChanged");
        Log.e("aaa",dependency.getClass().getName());
        int offset = dependency.getTop() - child.getTop();
        ViewCompat.offsetTopAndBottom(child, offset);
        return true;
    }
}

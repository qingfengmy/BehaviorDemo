package qingfengmy.behaviordemo.activitys;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import qingfengmy.behaviordemo.R;

/**
 * CoordinatorLayout功能如此强大，而他的神奇之处在于Behavior对象，
 * CoordinatorLayout自己并不控制View，所有的控制权都在Behavior。
 * 前面写到了
 * FloatingActionButton.Behavior，
 * AppBarLayout.Behavior,
 * AppBarLayout.ScrollingViewBehavior。
 * AppBarLayout中有两个Behavior，一个是拿来给它自己用的，另一个是拿来给它的兄弟结点用的。
 * 这些Behavior实现了复杂的控制功能。
 * 系统的Behavior毕竟有限，我们可以通过自定义的方式来实现自己的Behavior。
 *
 * Behavior是CoordinatorLayout的一个抽象内部类
 * public abstract static class Behavior<V extends View> {
        public Behavior() {
        }

         public Behavior(Context context, AttributeSet attrs) {
         }
     ...
     }
 有一个泛型是指定的我们应用这个Behavior的View的类型，
 例如上面的appbar_scrolling_view_behavior对应的字符串其实是Android.support.design.widget.AppBarLayout$ScrollingViewBehavior,
 这个ScrollingViewBehavior内部类指定的泛型是View,所以理论上这个Behavior我们任何的View都可以使用，
 我们在自定义的时候，如果不是特殊的行为，也可以直接指定泛型View。

 在自定义Behavior的时候，我们需要关心的两组四个方法，为什么分为两组呢？看一下下面两种情况

 1. 某个view监听另一个view的状态变化，例如大小、位置、显示状态等
 2. 某个view监听CoordinatorLayout里的滑动状态

 对于第一种情况，我们关心的是：
 layoutDependsOn和onDependentViewChanged方法，
 对于第二种情况，我们关心的是：
 onStartNestedScroll和onNestedPreScroll方法。
 对于这几个方法什么意思，我们需要干什么，稍候我们就能了解到。
 */
public class _7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__7);
        setTitle(getString(R.string._7activity));
        findViewById(R.id.depentent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(v, 5);
            }
        });
        findViewById(R.id.depentent2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(v, 5);
            }
        });
        findViewById(R.id.depentent3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(v, 5);
            }
        });
    }
}

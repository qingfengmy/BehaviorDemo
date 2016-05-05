package qingfengmy.behaviordemo.Stickyscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by michael on 2016/2/3.
 */
public class StickyScrollView extends FrameLayout {
    // 整个子View
    private ViewGroup mContentView;
    // 固定的view的父布局（也是frameLayout）
    private ViewGroup mTopView;
    // 固定view距离屏幕顶端的距离
    private int mTopViewTop;
    // 固定view
    private View mTopContentView;

    public StickyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        post(new Runnable() {
            @Override
            public void run() {
                mContentView = (ViewGroup) getChildAt(0);
                removeAllViews();
                // 把所有子view加到scrollview中
                MyScrollView scrollView = new MyScrollView(getContext(), StickyScrollView.this);
                scrollView.addView(mContentView);
                addView(scrollView);

            }
        });
    }

    // 设置固定view
    public void setTopView(final int id) {
        post(new Runnable() {
            @Override
            public void run() {
                mTopView = (ViewGroup) mContentView.findViewById(id);

                int height = mTopView.getChildAt(0).getMeasuredHeight();
                ViewGroup.LayoutParams params = mTopView.getLayoutParams();
                params.height = height;
                mTopView.setLayoutParams(params);
                mTopViewTop = mTopView.getTop();
                mTopContentView = mTopView.getChildAt(0);

            }
        });
    }

    // 滚动监听
    public void onScroll(final int scrollY) {
        post(new Runnable() {
            @Override
            public void run() {
                if (mTopView == null)
                    return;

                // 滚动距离大于距离顶端距离时，从scrollview中变到stickyScrollView中。只会执行一次，因为parent会变
                if (scrollY >= mTopViewTop
                        && mTopContentView.getParent() == mTopView) {
                    // 先移除，再添加
                    mTopView.removeView(mTopContentView);
                    addView(mTopContentView);
                } else if (scrollY < mTopViewTop
                        && mTopContentView.getParent() == StickyScrollView.this) {
                    // 当滚动距离小于距离订单距离时，说明滚回来了，从stickyScrollView中变到scrollview中。
                    // 先移除，再添加
                    removeView(mTopContentView);
                    mTopView.addView(mTopContentView);
                }

            }
        });
    }
}

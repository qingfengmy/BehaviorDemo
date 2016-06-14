package qingfengmy.behaviordemo.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 商品详情页使用的ListView
 */
public class ProductListView extends ListView {
    private OnScrollChangeListener onScrollChangeListener;

    public ProductListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.onScrollChangeListener = onScrollChangeListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(l - oldl, t - oldt);
        }
    }

    // 是否在滚到最上面
    public boolean isAtTop(){
        return getFirstVisiblePosition()==0 && getChildAt(0).getTop()==0;
    }

    public interface OnScrollChangeListener {
        void onScrollChange(int dx, int dy);
    }
}

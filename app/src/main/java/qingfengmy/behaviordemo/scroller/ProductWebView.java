package qingfengmy.behaviordemo.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * 添加滚动监听的WebView
 */
public class ProductWebView extends WebView {
    private OnScrollChangeListener onScrollChangeListener;

    public ProductWebView(Context context, AttributeSet attrs) {
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

    public interface OnScrollChangeListener {
        void onScrollChange(int dx, int dy);
    }
}

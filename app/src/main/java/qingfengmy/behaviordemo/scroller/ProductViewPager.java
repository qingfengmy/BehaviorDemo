package qingfengmy.behaviordemo.scroller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import qingfengmy.behaviordemo.R;

/**
 * 商品详情页使用的ViewPager
 */
public class ProductViewPager extends ViewPager {
    ProductWebView webView;
    ProductListView listView;
    ProductScrollView productScrollView;
    FragmentPagerAdapter adapter;
    float lastX, lastY;

    public ProductViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setAdapter(final PagerAdapter adapter) {
        super.setAdapter(adapter);
        productScrollView = (ProductScrollView) getParent().getParent().getParent();
        this.adapter = (FragmentPagerAdapter) adapter;
    }

    public void initCurrentView() {
        int currentItem = getCurrentItem();
        Fragment fragment = (Fragment) adapter.instantiateItem(this, currentItem);
        if (fragment instanceof ProductDetailFragment) {
            if (webView == null) {
                View view = fragment.getView();
                if (view != null) {
                    webView = (ProductWebView) view.findViewById(R.id.webView);

                    webView.setOnScrollChangeListener(new ProductWebView.OnScrollChangeListener() {
                        @Override
                        public void onScrollChange(int dx, int dy) {
                            Log.e("aaa", "dy=" + dy);
                            Log.e("aaa", "scrollY=" + webView.getScrollY());
                            if (getCurrentItem() == 0 && webView.getScrollY() == 0) {
                                productScrollView.setDispatch(false);
                            }
                        }
                    });
                }
            }

        } else if (fragment instanceof ProductPropsFragment) {
            if (listView == null) {
                View view = fragment.getView();
                if (view != null) {
                    listView = (ProductListView) view.findViewById(R.id.listView);

                    listView.setOnScrollChangeListener(new ProductListView.OnScrollChangeListener() {
                        @Override
                        public void onScrollChange(int dx, int dy) {
                            Log.e("aaa", "dy=" + dy);
                            Log.e("aaa", "scrollY=" + listView.getScrollY());
                            if (getCurrentItem() == 1 && listView.isAtTop() && dy <= 0) {
                                productScrollView.setDispatch(false);
                            }
                        }
                    });
                }

            }

        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        float y = ev.getY();
        float x = ev.getX();
        initCurrentView();
        float dy = lastY - y;
        float dx = lastX - x;
        lastX = x;
        lastY = y;
        return super.dispatchTouchEvent(ev);
    }

}

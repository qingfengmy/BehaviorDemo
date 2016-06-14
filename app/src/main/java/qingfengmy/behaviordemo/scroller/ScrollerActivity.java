package qingfengmy.behaviordemo.scroller;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import qingfengmy.behaviordemo.R;

public class ScrollerActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("嵌套滚动");
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        List<String> list = new ArrayList<>();
        list.add("最美丽");
        list.add("最可爱");
        list.add("最优雅");
        list.add("最优雅");
        list.add("最优雅");
        list.add("最优雅");
        list.add("最优雅");
        list.add("最优雅");
        list.add("最优雅");
        list.add("最优雅");
        list.add("最优雅");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最赚钱");
        list.add("最优雅");

        ProductDetailFragment productDetailFragment = ProductDetailFragment.newInstance("http://mp.weixin.qq.com/s?__biz=MjAzNzMzNTkyMQ==&mid=2653749414&idx=2&sn=24f11a8defe4dbad33893847728db885&scene=0");
        ProductPropsFragment productPropsFragment = ProductPropsFragment.newInstance(list);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(productDetailFragment, "产品详情");
        adapter.addFragment(productPropsFragment, "产品属性");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

//        getBinding().scrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
//
//            @Override
//            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
//                y = (int) (y * 0.36f);
//                if (y >= 0 && y <= 255) {
//                    getBinding().toolbar.setBackgroundColor(Color.argb(y, 255, 255, 255));
//                }else {
//                    getBinding().toolbar.setBackgroundColor(Color.argb(255, 255, 255, 255));
//                }
//            }
//        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) viewPager.getLayoutParams();
            lp.height = scrollView.getHeight() - tabLayout.getHeight() - toolbar.getHeight();
            viewPager.setLayoutParams(lp);
        }
    }

}

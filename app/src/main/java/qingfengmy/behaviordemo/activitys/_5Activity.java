package qingfengmy.behaviordemo.activitys;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import qingfengmy.behaviordemo.fragments.NestScrollViewFragment;
import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.fragments.RecyclerViewFragment;
import qingfengmy.behaviordemo.fragments.WebVewFragment;

public class _5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__5);
        setTitle(getString(R.string._5activity));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        tabLayout.setTabTextColors(Color.WHITE, Color.YELLOW);//设置文本在选中和为选中时候的颜色
        tabLayout.addTab(tabLayout.newTab().setText("RecyclerView"), true);//添加 Tab,默认选中
        tabLayout.addTab(tabLayout.newTab().setText("NestscrollView"), false);//添加 Tab,默认不选中
        tabLayout.addTab(tabLayout.newTab().setText("WebView"), false);//添加 Tab,默认不选中

        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new RecyclerViewFragment(), "RecyclerView");
        adapter.addFragment(new NestScrollViewFragment(), "NestscrollView");
        adapter.addFragment(new WebVewFragment(), "WebView");
        viewPager.setAdapter(adapter);

        //用来设置tab的，同时也要覆写  PagerAdapter 的 CharSequence getPageTitle(int position) 方法，要不然 Tab 没有 title
        tabLayout.setupWithViewPager(viewPager);
        //关联 TabLayout viewpager
        tabLayout.setTabsFromPagerAdapter(adapter);
        // 模式可以设置为滚动或者固定等
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

}

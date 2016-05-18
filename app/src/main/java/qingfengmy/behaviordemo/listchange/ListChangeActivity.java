package qingfengmy.behaviordemo.listchange;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import qingfengmy.behaviordemo.ItemGridBinding;
import qingfengmy.behaviordemo.ItemListBinding;
import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.adapter.CommonRecyclerAdapter;

/**
 * 单双列商品切换
 */
public class ListChangeActivity extends AppCompatActivity {

    List<String> dates = new ArrayList<>();
    RecyclerView recyclerView;
    TabLayout tabLayout;
    CommonRecyclerAdapter listAdapter;
    CommonRecyclerAdapter gridAdapter;
    boolean isList;
    PriceView priceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_change);

        recyclerView = (RecyclerView) findViewById(R.id.listRecyclerView);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("新品"));
        priceView = new PriceView(this);
        tabLayout.addTab(tabLayout.newTab().setCustomView(priceView));
        // 先释放，后选中
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.e("aaa","tab onTabSelected:::"+tab.getPosition());
                if (tab.getPosition()==1){
                    priceView.click();
                }else if (tab.getPosition() == 0){
                    priceView.reset();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.e("aaa","tab onTabReselected:::"+tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.e("aaa","tab onTabReselected:::"+tab.getPosition());
                if (tab.getPosition()==1){
                    priceView.click();
                }
            }
        });
        listAdapter = new CommonRecyclerAdapter<String, ItemListBinding>(this) {
            @Override
            public ItemListBinding createBinding(LayoutInflater inflater, ViewGroup parent, boolean attachToRoot) {
                return ItemListBinding.inflate(inflater, parent, attachToRoot);
            }

            @Override
            public void bindDate(ItemListBinding itemListBinding, String s) {
                itemListBinding.setText(s);
            }
        };

        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .color(R.color.colorAccent)
                .sizeResId(R.dimen.divider)
                .build());
        gridAdapter = new CommonRecyclerAdapter<String, ItemGridBinding>(this) {
            @Override
            public ItemGridBinding createBinding(LayoutInflater inflater, ViewGroup parent, boolean attachToRoot) {
                return ItemGridBinding.inflate(inflater, parent, attachToRoot);
            }

            @Override
            public void bindDate(ItemGridBinding itemGridBinding, String s) {
                itemGridBinding.setText(s);
            }
        };
        for (int i = 0; i < 20; i++) {
            dates.add("hello--" + i + ";;;");
        }
        listAdapter.addAll(dates);
        gridAdapter.addAll(dates);

        changeList();
        isList = true;

        findViewById(R.id.img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void changeGrid() {
        int position = 0;
        if (recyclerView.getLayoutManager() != null) {
            View topView = recyclerView.getLayoutManager().getChildAt(0);
            if (topView != null)
                position = recyclerView.getLayoutManager().getPosition(topView);  //得到该View的数组位置
        }
        Log.e("aaa", "position=" + position);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(gridAdapter);
        recyclerView.scrollToPosition(position);
    }

    private void changeList() {
        int position = 0;
        if (recyclerView.getLayoutManager() != null) {
            View topView = recyclerView.getLayoutManager().getChildAt(0);
            if (topView != null)
                position = recyclerView.getLayoutManager().getPosition(topView);  //得到该View的数组位置
        }
        Log.e("aaa", "position=" + position);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
        recyclerView.scrollToPosition(position);
    }

    private void showDialog(){
        DialogPlus dialog = DialogPlus.newDialog(this).setContentHolder(new ViewHolder(R.layout.layout_pop))
                .setGravity(Gravity.TOP)
//                .setMargin(0, DeviceUtil.dp2px(this,48),0,0)
                .setInAnimation(R.anim.fade_in_center)
                .setOutAnimation(R.anim.fade_out_center)
                .setOutMostMargin(0,DeviceUtil.dp2px(this,48),0,0)
//                .setOverlayBackgroundResource(android.R.color.transparent)
                .create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listchange, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change) {
            if (isList) {
                changeGrid();
            } else {
                changeList();
            }
            isList = !isList;
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

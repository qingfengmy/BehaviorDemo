package qingfengmy.behaviordemo.searchview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import qingfengmy.behaviordemo.ItemSearchBinding;
import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.adapter.CommonListAdapter;

/**
 * android searchView控件的使用
 */
public class SearchViewActivity extends AppCompatActivity {
    SearchView mSearchView;
    SearchView.SearchAutoComplete mEdit;
    String mSearchText;
    ListView listView;
    List<String> textList = new ArrayList<>();
    CommonListAdapter<String, ItemSearchBinding> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        setTitle(getString(R.string.searchView));

        listView = (ListView) findViewById(R.id.listView);
        adapter = new CommonListAdapter<String, ItemSearchBinding>(this) {
            @Override
            public ItemSearchBinding createBinding(LayoutInflater inflate) {
                return ItemSearchBinding.inflate(inflate);
            }

            @Override
            public void bindDate(ItemSearchBinding itemSearchBinding, String s) {
                itemSearchBinding.setText(s);
            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchview, menu);
        final MenuItem item = menu.findItem(R.id.menu_search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(item);
        mEdit = (SearchView.SearchAutoComplete) mSearchView.findViewById(R.id.search_src_text);
        // 一开始就处于显示SearchView的状态
//        mSearchView.setIconified(false);
//        不想让它隐藏SearchView
//        mSearchView.setIconifiedByDefault(false);
        setSearchView(this);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mSearchText = newText;
                doSearch();
                return true;
            }
        });
        return true;
    }

    private void setSearchView(Context context) {
        final float density = getResources().getDisplayMetrics().density;
        mSearchView.setIconified(false);
        mSearchView.setIconifiedByDefault(false);
        final int closeImgId = context.getResources().getIdentifier("search_close_btn", "id", getPackageName());
        ImageView closeImg = (ImageView) mSearchView.findViewById(closeImgId);
        if (closeImg != null) {
            LinearLayout.LayoutParams paramsImg = (LinearLayout.LayoutParams) closeImg.getLayoutParams();
            paramsImg.topMargin = (int) (-2 * density);
            closeImg.setImageResource(R.mipmap.clear_img);
            closeImg.setLayoutParams(paramsImg);
        }
        final int editViewId = context.getResources().getIdentifier("search_src_text", "id", getPackageName());
        mEdit = (SearchView.SearchAutoComplete) mSearchView.findViewById(editViewId);
        if (mEdit != null) {
            mEdit.setHintTextColor(getResources().getColor(R.color.colorAccent));
            mEdit.setTextColor(getResources().getColor(R.color.colorAccent));
            mEdit.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            mEdit.setHint(getResources().getString(R.string.search_hint_tip));
        }
        LinearLayout rootView = (LinearLayout) mSearchView.findViewById(R.id.search_bar);
        rootView.setBackgroundResource(R.drawable.bg_edit);
        rootView.setClickable(true);
        LinearLayout editLayout = (LinearLayout) mSearchView.findViewById(R.id.search_plate);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) editLayout.getLayoutParams();
        LinearLayout tipLayout = (LinearLayout) mSearchView.findViewById(R.id.search_edit_frame);
        LinearLayout.LayoutParams tipParams = (LinearLayout.LayoutParams) tipLayout.getLayoutParams();
        tipParams.leftMargin = 0;
        tipParams.rightMargin = 0;
        tipLayout.setLayoutParams(tipParams);
        ImageView icTip = (ImageView) mSearchView.findViewById(R.id.search_mag_icon);
        icTip.setImageResource(R.mipmap.ic_search_tip);
        params.topMargin = (int) (4 * density);
        editLayout.setLayoutParams(params);
        mSearchView.setSubmitButtonEnabled(false);
    }

    private void doSearch() {
        textList.clear();
        for (int i = 0; i < 20; i++) {
            textList.add(mSearchText);
        }
        adapter.clear();
        adapter.addAll(textList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_search) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

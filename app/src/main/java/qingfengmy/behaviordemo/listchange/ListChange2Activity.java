package qingfengmy.behaviordemo.listchange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import qingfengmy.behaviordemo.R;

public class ListChange2Activity extends AppCompatActivity {

    List<String> dates = new ArrayList<>();
    RecyclerView recyclerView;
    ListChangeAdapter adapter;
    boolean isList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_change2);

        recyclerView = (RecyclerView) findViewById(R.id.listRecyclerView);

        adapter = new ListChangeAdapter(this);

        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .color(R.color.colorAccent)
                .sizeResId(R.dimen.divider)
                .build());

        for (int i = 0; i < 20; i++) {
            dates.add("hello--" + i + ";;;");
        }
        adapter.addAll(dates);
        recyclerView.setAdapter(adapter);
        changeList();
        isList = true;
    }

    private void changeGrid() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter.setList(false);
    }

    private void changeList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setList(true);
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

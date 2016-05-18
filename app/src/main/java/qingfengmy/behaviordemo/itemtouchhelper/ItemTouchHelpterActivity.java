package qingfengmy.behaviordemo.itemtouchhelper;

import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import qingfengmy.behaviordemo.R;

/**
 * RecyclerView 拖动
 */
public class ItemTouchHelpterActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_touch_helpter);
        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container, new ItemTouchMainFragment()).commit();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.list) {
            // list
            fm.beginTransaction().replace(R.id.container, new ItemTouchListFragment())
                    .addToBackStack(null).commit();
        } else if (v.getId() == R.id.grid) {
            // grid
            fm.beginTransaction().replace(R.id.container, new ItemTouchGridFragment())
                    .addToBackStack(null).commit();
        }
    }
}

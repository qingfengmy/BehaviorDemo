package qingfengmy.behaviordemo.activitys;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import qingfengmy.behaviordemo.R;

/**
 * CoordinatorLayout与FloatingActionButton
 * 1. CoordinatorLayout是“super-powered FrameLayout”，其父类是ViewGroup
 * 2. FloatingActionButton是最简单的使用CoordinatorLayout的例子，
 * FloatingActionButton默认使用FloatingActionButton.Behavior。
 */
public class _1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__1);
        setTitle(getString(R.string._1activity));
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"FAB",Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件
                                Log.e("aaa", "fab clicked");
                            }
                        })
                        .show();
            }
        });
    }
}

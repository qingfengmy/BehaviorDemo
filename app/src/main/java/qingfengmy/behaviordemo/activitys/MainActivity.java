package qingfengmy.behaviordemo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import qingfengmy.behaviordemo.FlexBoxLayout.FlexBoxActivity;
import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.Stickyscrollview.StickyScrollActivity;
import qingfengmy.behaviordemo.itemtouchhelper.ItemTouchHelpterActivity;
import qingfengmy.behaviordemo.listchange.ListChange2Activity;
import qingfengmy.behaviordemo.listchange.ListChangeActivity;
import qingfengmy.behaviordemo.okhttp.OkHttpActivity;
import qingfengmy.behaviordemo.rxbus.RxBusActivity;
import qingfengmy.behaviordemo.rxjavadownload.RxjavaDownloadActivity;
import qingfengmy.behaviordemo.scroller.ScrollerActivity;
import qingfengmy.behaviordemo.searchview.SearchViewActivity;
import qingfengmy.behaviordemo.shareapk.ShareApkActivity;
import qingfengmy.behaviordemo.theme.ThemeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id._1activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _1Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id._2activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _2Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id._3activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _3Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id._4activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _4Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id._5activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _5Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id._6activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _6Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id._7activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _7Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id._8activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _8Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id._9activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _9Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id._10activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _10Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.shareapk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShareApkActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.stickyScrollview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StickyScrollActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.searchView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.rxbus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RxBusActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.listchange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListChangeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.listchange2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListChange2Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.flexbox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FlexBoxActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.itemTouchHelper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemTouchHelpterActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.scroller).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.retrofit_download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RxjavaDownloadActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.okhttp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OkHttpActivity.class);
                startActivity(intent);
            }
        });
    }
}

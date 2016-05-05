package qingfengmy.behaviordemo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.Stickyscrollview.StickyScrollActivity;
import qingfengmy.behaviordemo.searchview.SearchViewActivity;
import qingfengmy.behaviordemo.shareapk.ShareApkActivity;

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
    }
}

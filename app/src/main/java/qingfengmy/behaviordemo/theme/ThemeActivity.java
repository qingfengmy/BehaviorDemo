package qingfengmy.behaviordemo.theme;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import qingfengmy.behaviordemo.R;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private Resources.Theme mTheme;
    private int mThemeResource;

    Resources.Theme getThemes() {
        final boolean first = mTheme == null;
        if (first) {
            mTheme = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                mTheme.setTo(theme);
            }
        }
        onApplyThemeResource(mTheme, mThemeResource, first);
        return mTheme;
    }
}

package qingfengmy.behaviordemo.theme;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.ThemeActivityBinding;

public class ThemeActivity extends AppCompatActivity {

    ThemeActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_theme);

        StyleInfo styleInfo = new StyleInfo();
        styleInfo.setStyleId(R.style.textStyle1);
        binding.setStyleInfo(styleInfo);

//        binding.text.setBackgroundColor(R.co);
    }

}

package qingfengmy.behaviordemo.FlexBoxLayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import qingfengmy.behaviordemo.R;

public class FlexBoxActivity extends AppCompatActivity {
    TagFlowLayout tagFlowLayout;
    LayoutInflater mInflater;

    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex_box);

        mInflater = LayoutInflater.from(this);

        tagFlowLayout = (TagFlowLayout) findViewById(R.id.id_tagFlowLayout);
        tagFlowLayout.setAdapter(new TagAdapter<String>(mVals)
        {
            @Override
            protected View getView(ViewGroup parent, int position, String s)
            {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_text,
                        parent, false);
                tv.setText(s);
                return tv;
            }

            @Override
            protected void onSelect(ViewGroup parent, View view, int position)
            {
                view.setSelected(true);
            }

            @Override
            protected void onUnSelect(ViewGroup parent, View view, int position)
            {
                view.setSelected(false);
            }

            //            @Override
//            protected boolean select(int position)
//            {
////                if (position == 0) return true;
//
//                return super.select(position);
//            }

        });

//        tagFlowLayout.setJustifyContent(FlexboxLayout.JUSTIFY_CONTENT_CENTER);
    }
}

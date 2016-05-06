package qingfengmy.behaviordemo.rxbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import qingfengmy.behaviordemo.R;

public class RxBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus);
        setTitle(getString(R.string.rxbus));
    }

    public static class FragmentEvent{}
}

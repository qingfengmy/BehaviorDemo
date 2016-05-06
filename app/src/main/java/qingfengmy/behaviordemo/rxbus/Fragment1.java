package qingfengmy.behaviordemo.rxbus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import qingfengmy.behaviordemo.R;

/**
 * 事件发送
 */
public class Fragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 发送事件
                RxBus.getDefault().post(new RxBusActivity.FragmentEvent());
            }
        });
        return view;
    }

}

package qingfengmy.behaviordemo.rxbus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import qingfengmy.behaviordemo.R;
import rx.Subscription;
import rx.functions.Action1;

/**
 * 事件注册
 */
public class Fragment2 extends Fragment {

    TextView textView;
    Subscription subscription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        subscription = RxBus.getDefault().toObserverable(RxBusActivity.FragmentEvent.class).subscribe(new Action1<RxBusActivity.FragmentEvent>() {
            @Override
            public void call(RxBusActivity.FragmentEvent fragmentEvent) {
                textView.setVisibility(View.VISIBLE);
                textView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        textView = (TextView) view.findViewById(R.id.text);
        textView.setVisibility(View.INVISIBLE);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}

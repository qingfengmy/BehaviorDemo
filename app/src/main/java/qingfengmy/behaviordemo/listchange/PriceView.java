package qingfengmy.behaviordemo.listchange;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import qingfengmy.behaviordemo.R;

/**
 * Created by Administrator on 2016/5/17.
 */
public class PriceView extends LinearLayout {
    LayoutInflater inflater;
    ImageView up, down;
    TextView price;
    int state; // 初始0;up-1;down-2
    StateChangeListenner listenner;
    OnClickListener clickListener;

    public PriceView(Context context) {
        super(context);

        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_price, this);
        price = (TextView) view.findViewById(R.id.price);
        up = (ImageView) view.findViewById(R.id.up);
        down = (ImageView) view.findViewById(R.id.down);
    }

    boolean intercept;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return intercept;
    }

    public void setListenner(StateChangeListenner listenner) {
        this.listenner = listenner;
    }

    public void click() {
        if (state == 0 || state == 2) {
            // 下一个状态 up
            up.setSelected(true);
            down.setSelected(false);
            state = 1;
            if (listenner != null)
                listenner.changeUp();
        } else if (state == 1) {
            // 下一个状态 down
            up.setSelected(false);
            down.setSelected(true);
            state = 2;
            if (listenner != null)
                listenner.changeDown();
        }
        Log.e("aaa","state="+state);
    }

    public void reset() {
        up.setSelected(false);
        down.setSelected(false);
        price.setSelected(false);
        state=0;
    }

    public interface StateChangeListenner {
        void changeUp();

        void changeDown();
    }
}

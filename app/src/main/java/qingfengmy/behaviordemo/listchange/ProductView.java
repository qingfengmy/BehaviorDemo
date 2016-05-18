package qingfengmy.behaviordemo.listchange;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import qingfengmy.behaviordemo.ItemProductBinding;

/**
 * Created by Administrator on 2016/5/18.
 */
public class ProductView extends LinearLayout {
    LayoutInflater inflater;
    ViewSwitcher switcher;
    String text;
    ItemProductBinding binding;

    public ProductView(Context context, AttributeSet attrs) {
        super(context, attrs);

        inflater = LayoutInflater.from(context);
        binding = ItemProductBinding.inflate(inflater, this, false);

    }

    public void setText(String text) {
        this.text = text;
        binding.setText(text);
    }

    public void changeList() {
        switcher.setDisplayedChild(0);
    }

    public void changeGrid() {
        switcher.setDisplayedChild(1);
    }
}

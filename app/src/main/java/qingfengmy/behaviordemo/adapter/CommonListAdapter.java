package qingfengmy.behaviordemo.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by michael on 2016/1/13.
 */
public abstract class CommonListAdapter<T, B extends ViewDataBinding> extends ArrayAdapter<T> {
    private LayoutInflater inflate;

    public CommonListAdapter(Context context) {
        super(context, -1);
        inflate = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            B b = createBinding(inflate);
            convertView = b.getRoot();
            convertView.setTag(b);
        }
        B b = (B) convertView.getTag();
        bindDate(b, getItem(position));
        return convertView;
    }

    public abstract B createBinding(LayoutInflater inflate);

    public abstract void bindDate(B b, T t);
}

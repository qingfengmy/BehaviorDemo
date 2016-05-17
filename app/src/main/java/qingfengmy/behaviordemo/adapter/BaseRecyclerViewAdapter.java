package qingfengmy.behaviordemo.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/29.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> dateList = new ArrayList<>();

    public void addAll(List<T> list) {
        dateList.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        dateList.clear();
    }

    public T getItem(int position) {
        return position >= 0 && position < dateList.size() ? dateList.get(position) : null;
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

}

package qingfengmy.behaviordemo.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/5/5.
 */
public abstract class CommonRecyclerAdapter<T, B extends ViewDataBinding> extends BaseRecyclerViewAdapter<T> {
    Context context;
    LayoutInflater inflater;

    public CommonRecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public abstract B createBinding(LayoutInflater inflater, ViewGroup parent, boolean attachToRoot);

    public abstract void bindDate(B b, T t);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        B binding = ((CommonViewHolder) holder).binding;
        bindDate(binding, getItem(position));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommonViewHolder(createBinding(inflater, parent, false));
    }

    class CommonViewHolder extends RecyclerView.ViewHolder {
        B binding;

        public CommonViewHolder(B binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

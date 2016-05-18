package qingfengmy.behaviordemo.listchange;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import qingfengmy.behaviordemo.ItemProductBinding;
import qingfengmy.behaviordemo.adapter.BaseRecyclerViewAdapter;

/**
 * Created by Administrator on 2016/5/18.
 */
public class ListChangeAdapter extends BaseRecyclerViewAdapter<String> {
    boolean isList;
    Context context;
    LayoutInflater inflater;

    public ListChangeAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListViewHolder(ItemProductBinding.inflate(inflater, parent, false));
    }

    public void setList(boolean list) {
        isList = list;
        for (int i=0; i<getItemCount();i++){
            notifyItemChanged(i);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemProductBinding binding = ((ListViewHolder) holder).binding;
        binding.setText(getItem(position));
        binding.switcher.setDisplayedChild(isList ? 0 : 1);
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ItemProductBinding binding;

        public ListViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

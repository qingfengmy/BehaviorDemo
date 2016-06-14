package qingfengmy.behaviordemo.scroller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import qingfengmy.behaviordemo.ItemListBinding;
import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.adapter.CommonListAdapter;


/**
 * 产品属性
 */
public class ProductPropsFragment extends Fragment {

    List<String> properties;

    public static ProductPropsFragment newInstance(List<String> properties) {
        ProductPropsFragment fragment = new ProductPropsFragment();
        Bundle args = new Bundle();
        args.putSerializable("properties", (Serializable) properties);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            properties = (List<String>) getArguments().getSerializable("properties");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_props, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        CommonListAdapter<String, ItemListBinding> propsAdapter = new CommonListAdapter<String, ItemListBinding>(getContext()) {
            @Override
            public ItemListBinding createBinding(LayoutInflater inflate) {
                return ItemListBinding.inflate(inflate);
            }

            @Override
            public void bindDate(ItemListBinding itemProductPropsBinding, String s) {
                itemProductPropsBinding.setText(s);
            }
        };
        listView.setAdapter(propsAdapter);
        propsAdapter.addAll(properties);
    }

}

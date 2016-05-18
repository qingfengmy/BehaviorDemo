package qingfengmy.behaviordemo.itemtouchhelper;

import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import qingfengmy.behaviordemo.ItemGridBinding;
import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.adapter.CommonRecyclerAdapter;

/**
 * recyclerview grid itemtouchhelper
 */
public class ItemTouchGridFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_touch_grid, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        final CommonRecyclerAdapter<String, ItemGridBinding> adapter = new CommonRecyclerAdapter<String, ItemGridBinding>(getContext()) {
            @Override
            public ItemGridBinding createBinding(LayoutInflater inflater, ViewGroup parent, boolean attachToRoot) {
                return ItemGridBinding.inflate(inflater, parent, attachToRoot);
            }

            @Override
            public void bindDate(ItemGridBinding itemListBinding, String s) {
                itemListBinding.setText(s);
            }
        };
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("hello --- " + (i + 1) + ";;;;;;");
        }
        list.add("更多更多更多更多更多更多更多");
        adapter.addAll(list);

        recyclerView.addItemDecoration(new DividerGridItemDecoration(getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);
        // itemtouchhelper
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback() {
            @Override
            protected void onMove(int fromPosition, int toPosition) {

                if (fromPosition == adapter.getDateList().size() - 1 || toPosition == adapter.getDateList().size() - 1) {
                    return;
                }
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(adapter.getDateList(), i, i + 1);
                        Log.e("aaa", i + "和" + (i + 1) + "互换");
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(adapter.getDateList(), i, i - 1);
                        Log.e("aaa", i + "和" + (i + 1) + "互换");
                    }
                }
                adapter.notifyItemMoved(fromPosition, toPosition);
                Log.e("aaa", "list=" + list.toString());
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(recyclerView) {
            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {
                super.onLongClick(vh);
                // 最后一个是 更多按钮，不可长按
                if (vh.getLayoutPosition() != list.size() - 1) {
                    //获取系统震动服务
                    Vibrator vib = (Vibrator) getActivity().getSystemService(Service.VIBRATOR_SERVICE);
                    //震动70毫秒
                    vib.vibrate(700);
                    itemTouchHelper.startDrag(vh);
                }
            }
        });
    }
}

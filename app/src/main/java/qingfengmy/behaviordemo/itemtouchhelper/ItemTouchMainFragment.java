package qingfengmy.behaviordemo.itemtouchhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import qingfengmy.behaviordemo.R;

/**
 * 首页面
 */
public class ItemTouchMainFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.list).setOnClickListener(this);
        view.findViewById(R.id.grid).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ((ItemTouchHelpterActivity) getActivity()).onClick(v);
    }
}

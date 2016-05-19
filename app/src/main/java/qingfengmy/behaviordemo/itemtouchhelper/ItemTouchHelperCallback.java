package qingfengmy.behaviordemo.itemtouchhelper;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Administrator on 2016/5/18.
 */
public abstract class ItemTouchHelperCallback extends ItemTouchHelper.Callback {

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = 0, swipeFlags = 0;
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            // list上下
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        }
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager){
            // grid 上下左右
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();//得到拖动ViewHolder的position
        int toPosition = target.getAdapterPosition();//得到目标ViewHolder的position
        onMove(fromPosition, toPosition);
        return true;
    }

    protected abstract void onMove(int fromPosition, int toPosition);

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    // 当长按选中item的时候（拖拽开始的时候）调用
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    // 当手指松开的时候（拖拽完成的时候）调用
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(0);
    }

    // 是否需要RecyclerView支持长按拖拽，默认返回是ture（即支持）
    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }
}

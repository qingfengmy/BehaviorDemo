package qingfengmy.behaviordemo.theme;

import android.databinding.ObservableInt;

/**
 * Created by Administrator on 2016/5/19.
 */
public class StyleInfo {
    private ObservableInt styleId = new ObservableInt();

    public int getStyleId() {
        return styleId.get();
    }

    public void setStyleId(int styleId) {
        this.styleId.set(styleId);
    }
}

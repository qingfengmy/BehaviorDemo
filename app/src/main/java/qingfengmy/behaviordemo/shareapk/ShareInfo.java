package qingfengmy.behaviordemo.shareapk;

import android.graphics.drawable.Drawable;

import java.io.File;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ShareInfo {
    private String name;
    private Drawable icon;
    private String lastUpdateTime;
    private String firstInstallTime;
    private String size;
    private File apkFile;

    public ShareInfo(String name, Drawable icon, String lastUpdateTime, String firstInstallTime, String size, File apkFile) {
        this.name = name;
        this.icon = icon;
        this.lastUpdateTime = lastUpdateTime;
        this.firstInstallTime = firstInstallTime;
        this.size = size;
        this.apkFile = apkFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getFirstInstallTime() {
        return firstInstallTime;
    }

    public void setFirstInstallTime(String firstInstallTime) {
        this.firstInstallTime = firstInstallTime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public File getApkFile() {
        return apkFile;
    }

    public void setApkFile(File apkFile) {
        this.apkFile = apkFile;
    }
}

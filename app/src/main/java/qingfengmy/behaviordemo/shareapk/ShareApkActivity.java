package qingfengmy.behaviordemo.shareapk;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import qingfengmy.behaviordemo.ItemShareApkBinding;
import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.adapter.CommonListAdapter;

public class ShareApkActivity extends AppCompatActivity {
    private PackageManager mPackageManager;
    private List<ShareInfo> infoList = new ArrayList<>();
    private CommonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_apk);
        setTitle(getString(R.string.shareapk));

        new Thread() {
            @Override
            public void run() {
                super.run();
                initShareInfos();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.addAll(infoList);
                    }
                });
            }
        }.start();

        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new CommonListAdapter<ShareInfo, ItemShareApkBinding>(this) {
            @Override
            public ItemShareApkBinding createBinding(LayoutInflater inflate) {
                return ItemShareApkBinding.inflate(inflate);
            }

            @Override
            public void bindDate(ItemShareApkBinding itemShareApkBinding, ShareInfo shareInfo) {
                itemShareApkBinding.setShareInfo(shareInfo);
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File apkFile = infoList.get(position).getApkFile();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(apkFile));
                startActivity(intent);
            }
        });
    }

    private void initShareInfos() {
        mPackageManager = getPackageManager();
        List<PackageInfo> packageInfoList = mPackageManager.getInstalledPackages(0);
        for (int i = 0; i < packageInfoList.size(); i++) {
            PackageInfo packageInfo = packageInfoList.get(i);
            String name = getApplicationName(packageInfo.packageName, mPackageManager);
            Drawable icon = packageInfo.applicationInfo.loadIcon(mPackageManager);
            long lastUpdateTime = packageInfo.lastUpdateTime;
            long firstInstallTime = packageInfo.firstInstallTime;
            String sourceDir = packageInfo.applicationInfo.sourceDir;
            File apkFile = new File(sourceDir);
            float size = apkFile.length() * 1.0f / 1024 / 1024;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            DecimalFormat decimalFormat = new DecimalFormat("0.00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
            infoList.add(new ShareInfo(name,
                    icon,
                    format.format(new Date(lastUpdateTime)),
                    format.format(new Date(firstInstallTime)),
                    decimalFormat.format(size) + "M",
                    apkFile));
        }
    }

    /**
     * 获取应用的名称
     */
    public String getApplicationName(String packageName, PackageManager packageManager) {
        String applicationName = null;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            applicationName = (String) packageManager.getApplicationLabel(applicationInfo);
        } catch (PackageManager.NameNotFoundException e) {

        }
        return applicationName;
    }

}

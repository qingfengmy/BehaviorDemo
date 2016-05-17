

package qingfengmy.behaviordemo.listchange;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

//hardware related functions
public class DeviceUtil {
	public static final String TAG = "DeviceUtil";

	public static String getInfo(Context context) {
		String model = android.os.Build.MODEL;
		String device = android.os.Build.DEVICE;
		String brand = android.os.Build.BRAND;
		String product = android.os.Build.PRODUCT;
		String display = android.os.Build.DISPLAY;
		String manufacture = android.os.Build.MANUFACTURER;

		Resources resources = context.getResources();
		DisplayMetrics dm = resources.getDisplayMetrics();
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;
		float density = dm.density;

		StringBuilder sb = new StringBuilder();
		String finalInfo = sb.append("MODEL " + model)
				.append("\nDEVICE " + device).append("\nBRAND " + brand)
				.append("\nPRODUCT " + product).append("\nDISPLAY " + display)
				.append("\nMANUFACTURE " + manufacture)
				.append("\nSCREEN_WIDTH " + screenWidth)
				.append("\nSCREEN_HEIGHT " + screenHeight)
				.append("\nDENSITY " + density).toString();
		return finalInfo;
	}

	public static final String getBluetoothMac() {
		BluetoothAdapter adapter = null;
		String bluetoothMac = null;
		try {
			adapter = BluetoothAdapter.getDefaultAdapter();
			bluetoothMac = adapter.getAddress();
		} catch (Exception e) {
		}
		return bluetoothMac;
	}

	public static final String getWlanMac(Context context) {
		String wlanMac = null;
		try {
			WifiManager wm = (WifiManager) context
					.getSystemService(Context.WIFI_SERVICE);
			wlanMac = wm.getConnectionInfo().getMacAddress();
		} catch (Exception e) {

		}
		return wlanMac;
	}

	public static final String getAndroidId(Context context) {
		String androidID = null;
		try {
			androidID = Secure.getString(context.getContentResolver(),
					Secure.ANDROID_ID);
		} catch (Exception e) {

		}
		return androidID;
	}

	public static final String getIMEI(Context context) {
		String deviceIMEI = null;
		try {
			TelephonyManager teleManager = (TelephonyManager) context
					.getSystemService(Context.TELEPHONY_SERVICE);
			deviceIMEI = teleManager.getDeviceId();
		} catch (Exception e) {

		}
		return deviceIMEI;
	}

	public static float getScreenInches(Context context) {
		float screenInches = -1;
		try {
			Resources resources = context.getResources();
			DisplayMetrics dm = resources.getDisplayMetrics();
			double width = Math.pow(dm.widthPixels / dm.xdpi, 2);
			double height = Math.pow(dm.heightPixels / dm.ydpi, 2);
			screenInches = (float) (Math.sqrt(width + height));
		} catch (Exception e) {
		}
		return screenInches;
	}

	public static int getScreenWidth(Context context) {
		int screenWidth = -1;
		try {
			Resources resources = context.getResources();
			DisplayMetrics dm = resources.getDisplayMetrics();
			screenWidth = dm.widthPixels;
		} catch (Exception e) {
		}
		return screenWidth;
	}
	public static int getScreenHeight(Context context) {
		int screenHeight = -1;
		try {
			Resources resources = context.getResources();
			DisplayMetrics dm = resources.getDisplayMetrics();
			screenHeight = dm.heightPixels;
		} catch (Exception e) {
		}
		return screenHeight;
	}

	public static int dp2px(Context context,int dip) {
		Resources resources = context.getResources();
		int px = Math
				.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
						dip, resources.getDisplayMetrics()));
		return px;
	}

	public static int px2dp(Context context,int px) {
		DisplayMetrics displayMetrics = context.getResources()
				.getDisplayMetrics();
		int dp = Math.round(px
				/ (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
		return dp;
	}

	public static int sp2px(Context context,float sp) {
		final float scale = context.getResources().getDisplayMetrics().scaledDensity;
		int px = Math.round(sp * scale);
		return px;
	}

	public static int getDensity(Context context) {
		DisplayMetrics metrics = new DisplayMetrics();
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(metrics);
		int density = metrics.densityDpi;
		return density;
	}


	/**
	 * 设置添加屏幕的背景透明度
	 *
	 * @param bgAlpha
	 */
	public static  void backgroundAlpha(Activity activity, float bgAlpha) {
		WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
		lp.alpha = bgAlpha; //0.0-1.0
		activity.getWindow().setAttributes(lp);
	}
}

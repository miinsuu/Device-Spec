package com.loungelab.devicespec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PhoneState";
    private TextView spec_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spec_txt = findViewById(R.id.spec_txt);

        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        // 디바이스 가로, 세로 (pixel)
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        Display dis = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics metrics2 = new DisplayMetrics();
        dis.getMetrics(metrics2);


        String spec = "";




        spec += "모델명 = " + Build.MODEL + "\n";
        spec += "제조사 = " + Build.MANUFACTURER + "\n"; // 제조사
        spec += "VERSION.RELEASE = " + Build.VERSION.RELEASE + "\n\n";

        spec += "CPU_ABI = " + Build.CPU_ABI + "\n";
        spec += "DISPLAY = " + Build.DISPLAY + "\n";
        spec += "BOARD = " + Build.BOARD + "\n";
//        spec += "BRAND = " + Build.BRAND + "\n";
        spec += "DEVICE = " + Build.DEVICE + "\n";
        spec += "PRODUCT = " + Build.PRODUCT + "\n";
        spec += "FINGERPRINT = " + Build.FINGERPRINT + "\n";
        spec += "HOST = " + Build.HOST + "\n";
        spec += "ID = " + Build.ID + "\n";
        spec += "TAGS = " + Build.TAGS + "\n";
        spec += "TYPE = " + Build.TYPE + "\n";
        spec += "USER = " + Build.USER + "\n\n";


        spec += "dpi (해상도) = " + metrics.densityDpi + "dpi" + "\n";
        spec += "Width (pixel) = " + width + "px" +"\n";
        spec += "Height (pixel) = " + height + "px" + "\n";
        spec += "Width (dp) = " + (width * 160 / metrics.densityDpi) + "dp" + "\n";
        spec += "Height (dp) = " + (height * 160 / metrics.densityDpi) + "dp" + "\n";


        spec_txt.setText(spec);

        hideNavigationBar();

    }

    // 내비게이션 바 없애기
    private void hideNavigationBar() {
        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        boolean isImmersiveModeEnabled =
                ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
        if (isImmersiveModeEnabled) {
            Log.d("off", "Turning immersive mode mode off. ");
        } else {
            Log.d("on", "Turning immersive mode mode on.");
        }
        newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
    }
}
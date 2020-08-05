package tdc.edu.vn.myapplication.GiaoDien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import tdc.edu.vn.myapplication.R;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView image;
    private Thread mThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setControl();
    }

    private void setControl() {
        image = (ImageView) findViewById(R.id.image);
        starAnimation();
    }

    private void starAnimation() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        image.startAnimation(rotate);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
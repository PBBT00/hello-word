package com.example.demo02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView tv;
    int array[]={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imgView);
        tv = (TextView) findViewById(R.id.tv);
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            int i = 1;
            @Override
            //每隔1秒就会调用onTick()方法一次
            public void onTick(long l) {
                tv.setText("换图剩余时间"+(l/1000+1)+"秒");
            }
            //完成一次倒计时就会调用onFinish()方法更新图片
            @Override
            public void onFinish() {
                imageView.setImageDrawable(getResources().getDrawable(array[i]));
                i++;
                if(i==array.length)
                    i=0;
                start();  //启动倒计时
            }
        }.start();
    }
    public void clickExit(View v){
        finish();
    }
}

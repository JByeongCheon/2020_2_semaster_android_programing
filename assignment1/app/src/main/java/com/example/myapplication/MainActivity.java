package com.example.myapplication;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    //activity_main.xml에 사용되는 id호출
    Button image_view_btn; //다음 사진 버튼
    ImageView image_view1; //image viwe
    int i = 0; //사진 넘길 떄 사용 값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("자기 소개 앱"); //앱 타이틀 변경
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE); //앱 타이틀 text 색상 변경

        image_view1 = findViewById(R.id.image_view1);
        image_view_btn = findViewById(R.id.image_view_btn);


        image_view_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) { //버튼을 누를 때 마다 계산하여 조건에 따라 출력되는 사진을 달리한다.
                i += 1;

                if (i > 2){ //2다음 사진은 다시 첫번쨰 사진으로 돌아오기 위해
                    i = 0;
                }

                if ( i == 0 ){
                    image_view1.setImageResource(R.drawable.image1);
                }

                else if (i == 1){
                    image_view1.setImageResource(R.drawable.image2);
                }

                else if(i == 2){
                    image_view1.setImageResource(R.drawable.image3);
                }

            }
        });
    }
}






package com.example.assignment2_reservationapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnstart, btnend;
    RadioButton  rdate, rtime;
    RadioGroup radiogroup;
    TimePicker selecttime;
    DatePicker selectday;
    TextView tyear,tmonth , tday,thour, tmin;

    //timepicker의 시간 계산위해
    int select_year, select_month, select_day;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("201658073 전병천 시간 예약");

        btnstart = (Button) findViewById(R.id.btn_start);
        btnend = (Button) findViewById(R.id.end_btn);

        chronometer = (Chronometer)findViewById(R.id.chronometer1);

        radiogroup = (RadioGroup)findViewById(R.id.radiogroup1);
        rdate = (RadioButton)findViewById(R.id.radiodate);
        rtime = (RadioButton)findViewById(R.id.radiotime);

        selecttime = (TimePicker) findViewById(R.id.select_time);
        selectday = (DatePicker) findViewById(R.id.select_date);

        tyear = (TextView)findViewById(R.id.Tyear);
        tmonth = (TextView)findViewById(R.id.Tmonth);
        tday = (TextView)findViewById(R.id.Tday);
        thour = (TextView)findViewById(R.id.Thour);
        tmin = (TextView)findViewById(R.id.Tminutes);



        //시작 버튼 클릭시 라디오 버튼을 시작으로
        //코로노미터 시간 시작
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radiogroup.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        //라디오 버튼 클릭 시 각각 date와 시간
        rdate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                selectday.setVisibility(View.VISIBLE);
                selecttime.setVisibility(View.INVISIBLE);
            }
        });

        rtime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                selecttime.setVisibility(View.VISIBLE);
                selectday.setVisibility(View.INVISIBLE);
            }
        });

        //롱 클릭시 종료 및 감추기
        btnend.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public  boolean onLongClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                selectday.setVisibility(View.INVISIBLE);
                selecttime.setVisibility(View.INVISIBLE);
                radiogroup.setVisibility(View.INVISIBLE);

                //예약 날짜와 시간
                tyear.setText(Integer.toString(select_year));
                tmonth.setText(Integer.toString(select_month));
                tday.setText(Integer.toString(select_day));
                thour.setText(Integer.toString(selecttime.getCurrentHour()));
                tmin.setText(Integer.toString(selecttime.getCurrentMinute()));
                return false; //true: 다른이벤트 실행안함. False면 다른이벤트 실행
            }
        });

     //선택 날짜와 연도를 선택
    selectday.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            select_year = year;
            select_month = monthOfYear + 1;
            select_day = dayOfMonth;
        }
    });











    }

}
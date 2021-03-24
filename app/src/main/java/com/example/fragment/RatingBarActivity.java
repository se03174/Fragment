package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarActivity extends AppCompatActivity {




    private RatingBar rating_indicator;
    private Button button;

private Dialog dilaog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        dilaog = new Dialog(RatingBarActivity.this);
       // dilaog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dilaog.setContentView(R.layout.review_write_layout);
        rating_indicator = findViewById(R.id.ratingBarInficator);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    public void showDialog(){
        dilaog.show();
        /* 이 함수 안에 원하는 디자인과 기능을 구현하면 된다. */

        // 위젯 연결 방식은 각자 취향대로~
        // '아래 아니오 버튼'처럼 일반적인 방법대로 연결하면 재사용에 용이하고,
        // '아래 네 버튼'처럼 바로 연결하면 일회성으로 사용하기 편함.
        // *주의할 점: findViewById()를 쓸 때는 -> 앞에 반드시 다이얼로그 이름을 붙여야 한다.

rating();

        Button btnSave = dilaog.findViewById(R.id.btnSave);
        dilaog.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(RatingBarActivity.this,"저장 되었습니다.",Toast.LENGTH_SHORT).show();
                dilaog.dismiss();
                rating();
            }
        });

        dilaog.findViewById(R.id.btnCancle).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(RatingBarActivity.this,"취소 되었습니다.",Toast.LENGTH_SHORT).show();

            // 원하는 기능 구현
            dilaog.dismiss();
        }
    });


    }



public void rating() {


    class Listener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            rating_indicator.setRating(rating);
            int i = rating_indicator.getNumStars();
            Log.d("ddd",Integer.toString(i) );

        }
    }
}
}



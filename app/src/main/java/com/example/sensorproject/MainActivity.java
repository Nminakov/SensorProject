package com.example.sensorproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_data);
        constraintLayout = findViewById(R.id.cl_main);
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int count = event.getPointerCount();
                textView.setText(count + " fingers");
                for(int i = 0; i < count; ++i){
                    MotionEvent.PointerCoords coords = new MotionEvent.PointerCoords();
                    event.getPointerCoords(i,coords);
                    textView.append(String.format("\nпалец %d x=%f, y=%f", event.getPointerId(i),coords.x,coords.y ));
                }
                textView.append("\n"+event.getAction());
                return true;
            }
        });
    }

}

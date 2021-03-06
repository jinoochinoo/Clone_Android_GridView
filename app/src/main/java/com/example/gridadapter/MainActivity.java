package com.example.gridadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    private int[] data = {R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4,
            R.drawable.s5, R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9,
            R.drawable.s10, R.drawable.s11, R.drawable.s12, R.drawable.s13, R.drawable.s14,
            R.drawable.s15, R.drawable.s16, R.drawable.s17};

    private CustomAdapter adapter = null;
    private GridView gv = null;

    private LinearLayout ll;
    private ImageView[] ivs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomAdapter(this, data);
        gv = findViewById(R.id.gv_01);
        gv.setAdapter(adapter);

        ll = findViewById(R.id.ll_01);
        ivs = new ImageView[5];

        for (int i=0; i<5; i++){
            ivs[i] = new ImageView(this);
            ivs[i].setImageResource(data[i]);
            ll.addView(ivs[i]);
        }
    }


}
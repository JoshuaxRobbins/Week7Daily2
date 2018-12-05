package com.example.josh.week7daily1;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DynamicActivity extends AppCompatActivity {

    public static final String TAG = "_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(addTextViews());

    }

    public LinearLayout addTextViews(){
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView tvOne = new TextView(this);
        tvOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        tvOne.setText("One");
        tvOne.setVisibility(View.VISIBLE);
        tvOne.setPadding(20,20,20,20);
        tvOne.setRotation(45f);

        TextView tvTwo = new TextView(this);
        tvTwo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        tvTwo.setText("Two");
        tvTwo.setVisibility(View.VISIBLE);
        tvTwo.setRotation(45f);
        tvTwo.setPadding(20,20,20,20);
        
        linearLayout.addView(tvOne);
        linearLayout.addView(tvTwo);

        Log.d(TAG, "addTextViews: ");
        return linearLayout;
    }
}

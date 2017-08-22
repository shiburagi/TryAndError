package com.infideap.tryanderror;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.infideap.tryanderror.util.TextViewUtils;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        TextViewUtils.getInstance().printIncrement(textView, 895, 5);

    }


}

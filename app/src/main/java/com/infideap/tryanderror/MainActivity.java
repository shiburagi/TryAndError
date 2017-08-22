package com.infideap.tryanderror;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.app.infideap.stylishwidget.view.Stylish;
import com.infideap.tryanderror.util.TextViewUtils;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String folder = "Raleway/Raleway-";
        Stylish.getInstance().set(
                folder.concat("Regular.ttf"),
                folder.concat("Bold.ttf"),
                folder.concat("Italic.ttf"),
                folder.concat("BoldItalic.ttf")
        );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        TextViewUtils.getInstance().printIncrement(textView, 895, 2000);

    }


}

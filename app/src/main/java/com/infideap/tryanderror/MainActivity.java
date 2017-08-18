package com.infideap.tryanderror;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.infideap.tryanderror.entity.Action;
import com.infideap.tryanderror.entity.Answer;
import com.infideap.tryanderror.entity.Data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        textView.setText("");
        Gson gson = new Gson();

        String s = getJsonString(R.raw.data);
        Log.d(TAG, s);

        Data data = gson.fromJson(s, Data.class);


        textView.append(gson.toJson(data));
        textView.append("\n=========================\n");
        int i = 0;
        for (Answer answer : data.answers) {
            textView.append("Answer " + (++i));
            textView.append("\n=========================\n");
            int j = 0;
            for (Action action : answer.actions) {
                textView.append("Action Column " + (++j));
                textView.append("\n=========================\n");
                Map<String, Object> map = action.columns;

                Set<Map.Entry<String, Object>> set = map.entrySet();
                Iterator<Map.Entry<String, Object>> iterator = set.iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, Object> entry = iterator.next();
                    textView.append(
                            String.format(
                                    Locale.getDefault(),
                                    "\tKey\t= %s, \n\tValue\t= %s\n\n",
                                    entry.getKey(),
                                    String.valueOf(entry.getValue())
                            )
                    );

                }
                textView.append("=========================\n");

            }
            textView.append("\n=========================\n");

        }


    }

    public String getJsonString(int dataResId) {
        InputStream inputStream = getResources().openRawResource(dataResId);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return byteArrayOutputStream.toString();
    }
}

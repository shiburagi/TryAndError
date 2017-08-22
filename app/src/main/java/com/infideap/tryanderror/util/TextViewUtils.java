package com.infideap.tryanderror.util;

import android.widget.TextView;

/**
 * Created by Shiburagi on 22/08/2017.
 */

public class TextViewUtils {
    private static final String TAG = TextViewUtils.class.getSimpleName();
    private static TextViewUtils instance;

    static {
        instance = new TextViewUtils();
    }

    public static TextViewUtils getInstance() {
        return instance;
    }

    public void printIncrement(TextView textView, long endNumber, long millis) {
        printIncrement(textView, 0, endNumber, millis);
    }

    public void printIncrement(TextView textView, long startNumber, long endNumber, long millis) {
        textView.setText(String.valueOf(startNumber));
        printIncrementPostDelayed(textView, startNumber, endNumber, millis);

    }

    private void printIncrementPostDelayed(final TextView textView, final long startNumber, final long endNumber, final long millis) {
        new Thread() {
            @Override
            public void run() {
                long counter = startNumber;
                double delayDuration = (double) millis / (double) (endNumber - startNumber);
                long increment;
                if (delayDuration < 1) {
                    increment = (long) Math.ceil(1f / delayDuration);
                    delayDuration *= increment;
                } else
                    increment = 1;
                try {
                    while (counter < endNumber) {
                        sleep((long) delayDuration);
                        counter += increment;
                        final String displayText = String.valueOf(counter);
                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(displayText);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


}

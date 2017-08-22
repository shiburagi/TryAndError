package com.infideap.tryanderror.util;

import android.widget.TextView;

import java.util.Locale;

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
        printIncrement(textView, "%d", startNumber, endNumber, millis);
    }

    public void printIncrement(TextView textView, String format, long startNumber, long endNumber, long millis) {
        printIncrement(textView, Locale.getDefault(), format, startNumber, endNumber, millis);

    }

    public void printIncrement(final TextView textView, final Locale locale, final String format, final long startNumber, final long endNumber, final long millis) {
        textView.post(new Runnable() {
            @Override
            public void run() {
                printIncrementPostDelayed(textView, locale, format, startNumber, endNumber, millis);
            }
        });

    }

    private void printIncrementPostDelayed(final TextView textView, final Locale locale,
                                           final String format, final long startNumber,
                                           final long endNumber, final long millis) {
        new Thread() {
            @Override
            public void run() {
                try {
                    long counter = startNumber;
                    double delayDuration = (double) millis / (double) (endNumber - startNumber);
                    long increment;
                    if (delayDuration < 1) {
                        increment = (long) Math.ceil(1f / delayDuration);
                        delayDuration *= increment;
                    } else
                        increment = 1;

                    textView.setText(getString(locale, format, counter));
                    while (counter < endNumber) {
                        sleep((long) delayDuration);
                        counter += increment;
                        final String displayText = getString(locale, format, counter);
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

    private String getString(Locale locale, String format, long counter) {
        return String.format(
                locale, format, counter
        );
    }


}

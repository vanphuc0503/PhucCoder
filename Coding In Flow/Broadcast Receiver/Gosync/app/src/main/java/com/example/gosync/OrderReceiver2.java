package com.example.gosync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Toast;

public class OrderReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        final Handler handler = new Handler();
        final PendingResult pendingResult = goAsync();

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(10000);

                int resultsCode = pendingResult.getResultCode();
                String resultData = pendingResult.getResultData();
                Bundle resultExtras = pendingResult.getResultExtras(true);
                String stringExtra = resultExtras.getString("stringExtra");

                resultsCode++;
                stringExtra += "->OR2";

                final String toastText = "OR2\n" + "resultCode: "+resultsCode + "\n" +
                        "resultData: " + resultData + "\n" +
                        "stringExtra: " + stringExtra;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
                    }
                });


                resultData = "OR2";
                resultExtras.putString("stringExtra", stringExtra);

                pendingResult.setResult(resultsCode, resultData, resultExtras);
                pendingResult.finish();
            }
        }).start();



        //abortBroadcast();
    }
}

package com.example.gosync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class OrderReceiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int resultsCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");

        resultsCode++;
        stringExtra += "->OR1";

        String toastText = "OR1\n" + "resultCode: "+resultsCode + "\n" +
                "resultData: " + resultData + "\n" +
                "stringExtra: " + stringExtra;

        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        resultData = "OR1";
        resultExtras.putString("stringExtra", stringExtra);

        setResult(resultsCode, resultData, resultExtras);
    }
}

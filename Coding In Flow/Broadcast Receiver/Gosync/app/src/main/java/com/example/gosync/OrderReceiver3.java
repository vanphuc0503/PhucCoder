package com.example.gosync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class OrderReceiver3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int resultsCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");

        resultsCode++;
        stringExtra += "->OR3";

        String toastText = "OR3\n" + "resultCode: "+resultsCode + "\n" +
                "resultData: " + resultData + "\n" +
                "stringExtra: " + stringExtra;

        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        resultData = "OR3";
        resultExtras.putString("stringExtra", stringExtra);

        setResult(resultsCode, resultData, resultExtras);
    }
}

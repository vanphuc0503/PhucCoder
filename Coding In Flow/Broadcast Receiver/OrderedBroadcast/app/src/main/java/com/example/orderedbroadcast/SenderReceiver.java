package com.example.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SenderReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int resultsCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");

        resultsCode++;
        stringExtra += "->SenderReceiver";

        String toastText = "SenderReceiver\n" + "resultCode: "+resultsCode + "\n" +
                "resultData: " + resultData + "\n" +
                "stringExtra: " + stringExtra;

        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        resultData = "SenderReceiver";
        resultExtras.putString("stringExtra", stringExtra);

        setResult(resultsCode, resultData, resultExtras);
    }
}

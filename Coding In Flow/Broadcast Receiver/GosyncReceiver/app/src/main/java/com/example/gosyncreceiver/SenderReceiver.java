package com.example.gosyncreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SenderReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int resultCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");
        resultCode++;
        stringExtra += "->SenderReceiver";
        String toastText = "SenderReceiver\n" +
                "resultCode: " + resultCode + "\n" +
                "resultData: " + resultData + "\n" +
                "stringExtra: " + stringExtra;
        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();
        resultData = "SenderReceiver";
        resultExtras.putString("stringExtra", stringExtra);
        setResult(resultCode, resultData, resultExtras);
    }
}

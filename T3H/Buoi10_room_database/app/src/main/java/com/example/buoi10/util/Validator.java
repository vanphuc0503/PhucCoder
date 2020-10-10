package com.example.buoi10.util;

import android.widget.EditText;

public class Validator {
    public static boolean isEmpty(EditText ... edts){
        boolean isEmpty = false;
        for (EditText edt: edts
             ) {
            if (edt.getText().toString().isEmpty()){
                isEmpty = true;
                edt.setError("Input empty");
            }
        }
        return isEmpty;
    }
}

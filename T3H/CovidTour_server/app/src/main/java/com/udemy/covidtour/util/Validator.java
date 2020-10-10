package com.udemy.covidtour.util;

import android.widget.EditText;

public class Validator {
    public static boolean isEmpty(EditText... editTexts) {
        boolean isEmpty = false;
        for (EditText edt : editTexts) {
            if (edt.getText().toString().isEmpty()) {
                isEmpty = true;
                edt.setError("Empty");
            }
        }
        return isEmpty;
    }
}

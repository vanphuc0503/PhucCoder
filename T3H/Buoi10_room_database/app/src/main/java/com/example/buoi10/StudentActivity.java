package com.example.buoi10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buoi10.dao.AppDatabase;
import com.example.buoi10.model.Student;
import com.example.buoi10.util.Validator;

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtName;
    private EditText edtAge;
    private EditText edtAddress;
    private EditText edtPhone;
    private Button btnOk;
    private Student student = new Student();

    public static Intent getInstance(Context context, Student student){
        Intent intent = new Intent(context, StudentActivity.class);
        if (student != null){
            intent.putExtra(Student.class.getName(), student);
            Toast.makeText(context, "dsads", Toast.LENGTH_SHORT).show();
        }
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Intent intent = getIntent();
        if (intent.hasExtra(Student.class.getName())){
            student = (Student) intent.getSerializableExtra(Student.class.getName());
        }
        initViews();
    }

    private void initViews() {
        edtName = findViewById(R.id.edt_name);
        edtAge = findViewById(R.id.edt_age);
        edtAddress = findViewById(R.id.edt_address);
        edtPhone = findViewById(R.id.edt_phone);
        btnOk = findViewById(R.id.btn_ok);

        edtName.setText(student.getName());
        edtAge.setText(""+student.getAge());
        edtAddress.setText(student.getAddress());
        edtPhone.setText(student.getPhone());

        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (Validator.isEmpty(edtAddress, edtAge, edtName, edtPhone)){
            return;
        }
        student.setAddress(edtAddress.getText().toString());
        student.setAge(Integer.parseInt(edtAge.getText().toString()));
        student.setName(edtName.getText().toString());
        student.setPhone(edtPhone.getText().toString());
        if (student.getId()>0){
            AppDatabase.getInstance(this).getStudentDao().update(student);
        }else {
            AppDatabase.getInstance(this).getStudentDao().insert(student);
        }
        setResult(RESULT_OK);
        finish();
    }
}
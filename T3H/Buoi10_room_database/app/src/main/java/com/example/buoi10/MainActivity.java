package com.example.buoi10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.buoi10.adapter.StudentAdapter;
import com.example.buoi10.dao.AppDatabase;
import com.example.buoi10.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_STUDENT = 1;
    private RecyclerView lvStudent;
    private StudentAdapter adapter;
    private FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loadData();
    }

    private void loadData() {
        adapter.setStudents(AppDatabase.getInstance(this).getStudentDao().getAll());
    }

    private void initView() {
        lvStudent = findViewById(R.id.lv_student);
        btnAdd = findViewById(R.id.btn_add);
        adapter = new StudentAdapter(getLayoutInflater());
        lvStudent.setAdapter(adapter);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = StudentActivity.getInstance(this, null);
        startActivityForResult(intent, REQUEST_STUDENT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_STUDENT && resultCode == RESULT_OK){
            loadData();
        }
    }
}
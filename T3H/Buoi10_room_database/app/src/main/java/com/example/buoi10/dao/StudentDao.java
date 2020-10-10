package com.example.buoi10.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.buoi10.model.Student;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT*FROM Student")
    List<Student> getAll();

    @Query("SELECT*FROM Student WHERE name like:name")
    List<Student> getStudent(String name);

    @Insert
    void insert(Student ... students);

    @Update
    void update(Student ... students);

    @Delete
    void delete(Student ... students);
}

package com.example.buoi10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buoi10.R;
import com.example.buoi10.model.Student;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
    private List<Student> data;
    private LayoutInflater inflater;

    public StudentAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setStudents(List<Student> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_student, parent, false);
        return new StudentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        holder.bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView age;
        private TextView address;
        private TextView phone;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            age = itemView.findViewById(R.id.tv_age);
            address = itemView.findViewById(R.id.tv_address);
            phone = itemView.findViewById(R.id.tv_phone);
        }

        public void bindView(Student student) {
            name.setText(student.getName());
            age.setText(""+student.getAge());
            address.setText(student.getAddress());
            phone.setText(student.getPhone());
        }
    }
}

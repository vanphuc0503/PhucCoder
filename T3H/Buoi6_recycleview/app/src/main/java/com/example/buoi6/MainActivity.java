package com.example.buoi6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FaceAdapter.FaceListener {

    private RecyclerView lvFace;
    private FaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        lvFace = findViewById(R.id.lv_face);
        adapter = new FaceAdapter(getLayoutInflater());
        lvFace.setAdapter(adapter);
        adapter.setFaces(initData());
        adapter.setOnFaceItemListener(this);
    }

    private ArrayList<Face> initData(){
        ArrayList<Face> faces = new ArrayList<>();
        faces.add(new Face(R.drawable.love, "Love"));
        faces.add(new Face(R.drawable.beauty, "Beauty"));
        faces.add(new Face(R.drawable.cry, "Cry"));
        faces.add(new Face(R.drawable.smile, "Simle"));
        faces.add(new Face(R.drawable.love, "Love"));
        faces.add(new Face(R.drawable.beauty, "Beauty"));
        faces.add(new Face(R.drawable.cry, "Cry"));
        faces.add(new Face(R.drawable.smile, "Simle"));
        faces.add(new Face(R.drawable.love, "Love"));
        faces.add(new Face(R.drawable.beauty, "Beauty"));
        faces.add(new Face(R.drawable.cry, "Cry"));
        faces.add(new Face(R.drawable.smile, "Simle"));
        faces.add(new Face(R.drawable.love, "Love"));
        faces.add(new Face(R.drawable.beauty, "Beauty"));
        faces.add(new Face(R.drawable.cry, "Cry"));
        faces.add(new Face(R.drawable.smile, "Simle"));
        faces.add(new Face(R.drawable.love, "Love"));
        faces.add(new Face(R.drawable.beauty, "Beauty"));
        faces.add(new Face(R.drawable.cry, "Cry"));
        faces.add(new Face(R.drawable.smile, "Simle"));
        faces.add(new Face(R.drawable.love, "Love"));
        faces.add(new Face(R.drawable.beauty, "Beauty"));
        faces.add(new Face(R.drawable.cry, "Cry"));
        faces.add(new Face(R.drawable.smile, "Simle"));
        faces.add(new Face(R.drawable.love, "Love"));
        faces.add(new Face(R.drawable.beauty, "Beauty"));
        faces.add(new Face(R.drawable.cry, "Cry"));
        faces.add(new Face(R.drawable.smile, "Simle"));
        faces.add(new Face(R.drawable.love, "Love"));
        faces.add(new Face(R.drawable.beauty, "Beauty"));
        faces.add(new Face(R.drawable.cry, "Cry"));
        faces.add(new Face(R.drawable.smile, "Simle"));
        return faces;
    }

    @Override
    public void onItemFaceClicked(Face face) {
        Toast.makeText(this, face.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemFaceLongClicked(final int position) {
        //tao dialog
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Do you want to delete?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.getFaces().remove(position);
                        adapter.notifyItemRemoved(position);
                        adapter.notifyItemRangeChanged(position, adapter.getItemCount());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.setCanceledOnTouchOutside(false); // khong cho bam ra ngoai
        dialog.setCancelable(false);   //Khong cho ca back
        dialog.show();
//        dialog.setOnDismissListener();

    }
}
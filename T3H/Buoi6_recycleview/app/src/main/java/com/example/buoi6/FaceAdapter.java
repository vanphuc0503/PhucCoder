package com.example.buoi6;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.FaceHolder> {

    private FaceListener listener;
    private ArrayList<Face> faces;
    private LayoutInflater inflater;

    public FaceAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setOnFaceItemListener(FaceListener listener){
        this.listener = listener;
    }

    public void setFaces(ArrayList<Face> faces) {
        this.faces = faces;
        notifyDataSetChanged();
    }

    public ArrayList<Face> getFaces() {
        return faces;
    }

    @NonNull
    @Override
    public FaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e("FaceAdapter", "OnCreateViewHolder");
        View v = inflater.inflate(R.layout.item_face, parent, false);
        return new FaceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceHolder holder, final int position) {
        Log.e("FaceAdapter", "OnBindViewHolder: "+ position);
        holder.bindView(faces.get(position));
        if (listener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemFaceClicked(faces.get(position));
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemFaceLongClicked(position);
                    return true;
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return faces == null ? 0:faces.size();
    }

    public class FaceHolder extends RecyclerView.ViewHolder{
        private ImageView imFace;
        private TextView tvFace;

        public FaceHolder(@NonNull View itemView) {
            super(itemView);
            imFace = itemView.findViewById(R.id.im_face);
            tvFace = itemView.findViewById(R.id.tv_face);
        }

        public void bindView(Face item){
            imFace.setImageResource(item.getResId());
            tvFace.setText(item.getName());
        }
    }

    interface FaceListener{
        void onItemFaceClicked(Face face);
        void onItemFaceLongClicked(int position);
    }

}

package com.example.buoi12.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buoi12.databinding.ItemSongBinding;
import com.example.buoi12.model.Song;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> implements Filterable {
    private SongFilter filter = new SongFilter();
    private LayoutInflater inflater;
    private ArrayList<Song> data;
    private ArrayList<Song> dataAll;
    private SongItemClickListener lister;

    public void setData(ArrayList<Song> data) {
        this.dataAll = data;
        this.data = data;
        notifyDataSetChanged();
    }

    public SongAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setLister(SongItemClickListener lister) {
        this.lister = lister;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSongBinding binding = ItemSongBinding.inflate(inflater, parent, false);
        return new SongHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, int position) {
        holder.binding.setItem(data.get(position));
        if (lister!=null){
            holder.binding.setListener(lister);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0:data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    public class SongHolder extends RecyclerView.ViewHolder{
        private ItemSongBinding binding;
        public SongHolder(@NonNull ItemSongBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface SongItemClickListener{
        void onSongItemClicked(Song item);
    }

    public class SongFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence key) {
            ArrayList<Song> result = new ArrayList<>();
            for (Song s: dataAll){
                if (s.getTitle().toLowerCase().contains(key.toString().toLowerCase())){
                    result.add(s);
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.count = result.size();
            filterResults.values = result;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            data = (ArrayList<Song>) results.values;
            notifyDataSetChanged();
        }
    }
}

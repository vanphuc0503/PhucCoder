package com.udemy.basemodule.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.udemy.basemodule.models.BaseModel;

import java.util.List;

public class BaseBindingAdapter<T extends BaseModel> extends RecyclerView.Adapter<BaseBindingAdapter.BaseBindingHolder>{

    private List<T> data;
    private int resId;
    private BaseBindingItemListener listener;
    private int brItem;
    private int brListener;
    private LayoutInflater inflater;

    public BaseBindingAdapter(LayoutInflater inflater, int resId, int brItem) {
        this.resId = resId;
        this.brItem = brItem;
        this.inflater = inflater;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setListener(BaseBindingItemListener listener, int brListener) {
        this.listener = listener;
        this.brListener = brListener;
    }


    @NonNull
    @Override
    public BaseBindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                inflater,
                resId,
                parent,
                false);
        return new BaseBindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter.BaseBindingHolder holder, int position) {
        T item = data.get(position);
        holder.binding.setVariable(brItem, item);
        if (listener != null){
            holder.binding.setVariable(brListener, listener);
        }
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class BaseBindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BaseBindingHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface BaseBindingItemListener {
    }
}

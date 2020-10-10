package com.t3h.mp3music.ui.screen.album;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.mp3music.R;
import com.t3h.mp3music.databinding.FragmentAlbumBinding;
import com.t3h.mp3music.model.Album;
import com.t3h.mp3music.ui.base.BaseBindingAdapter;
import com.t3h.mp3music.ui.base.BaseFragment;

public class AlbumFragment extends BaseFragment<FragmentAlbumBinding,AlbumViewModel> {
    private BaseBindingAdapter<Album> adapter;

    @Override
    protected Class<AlbumViewModel> getViewModelClass() {
        return AlbumViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_album;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseBindingAdapter<>(
                R.layout.item_album, getLayoutInflater());
        binding.setAdapter(adapter);
        adapter.setData(viewModel.getAlbum(getContext()));
    }}

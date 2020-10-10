package com.t3h.mp3music.ui.screen.artist;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.mp3music.R;
import com.t3h.mp3music.databinding.FragmentAlbumBinding;
import com.t3h.mp3music.databinding.FragmentArtistBinding;
import com.t3h.mp3music.model.Album;
import com.t3h.mp3music.model.Artist;
import com.t3h.mp3music.ui.base.BaseBindingAdapter;
import com.t3h.mp3music.ui.base.BaseFragment;
import com.t3h.mp3music.ui.screen.album.AlbumViewModel;

public class ArtistFragment extends BaseFragment<FragmentArtistBinding, ArtistViewModel> {
    private BaseBindingAdapter<Artist> adapter;

    @Override
    protected Class<ArtistViewModel> getViewModelClass() {
        return ArtistViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_artist;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseBindingAdapter<>(
                R.layout.item_artist, getLayoutInflater());
        binding.setAdapter(adapter);
        adapter.setData(viewModel.getArtist(getContext()));
    }}

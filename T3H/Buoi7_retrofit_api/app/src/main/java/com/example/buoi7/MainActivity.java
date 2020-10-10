package com.example.buoi7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buoi7.api.Api;
import com.example.buoi7.api.ApiBuilder;
import com.example.buoi7.model.NewsAdapter;
import com.example.buoi7.model.NewsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<NewsResponse> {
    private EditText edtSearch;
    private Button btnSearch;
    private RecyclerView lvNews;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        edtSearch = findViewById(R.id.edt_search);
        btnSearch = findViewById(R.id.btn_search);
        lvNews = findViewById(R.id.lv_news);
        btnSearch.setOnClickListener(this);
        adapter = new NewsAdapter(getLayoutInflater());
        lvNews.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        String key = edtSearch.getText().toString();
        if (key.isEmpty()) return;
        ApiBuilder.getInstance().getNews(key, "e25e694a051347628f8ec21251c4a47b").
                enqueue(this);
    }

    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        NewsResponse newsResponse = response.body();
        adapter.setData(newsResponse.getArrNews());
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        Toast.makeText(this, "Search false", Toast.LENGTH_SHORT).show();
    }
}
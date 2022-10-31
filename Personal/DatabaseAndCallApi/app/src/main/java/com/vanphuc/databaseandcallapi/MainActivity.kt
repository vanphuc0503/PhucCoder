package com.vanphuc.databaseandcallapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vanphuc.databaseandcallapi.data.model.Photo
import com.vanphuc.databaseandcallapi.data.resource.remote.PhotoApi
import com.vanphuc.databaseandcallapi.databinding.ActivityMainBinding
import com.vanphuc.databaseandcallapi.ui.base.BaseRecyclerview
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var service: PhotoApi? = null
    private val recyclerView by lazy {
        BaseRecyclerview<Photo>(
            R.layout.photo_item
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PhotoApi::class.java)
        binding!!.apply {
            recyclerPhoto.adapter = recyclerView
        }
        binding?.btnLoad?.setOnClickListener {
            service?.listPhoto()?.enqueue(object : Callback<List<Photo>> {
                override fun onResponse(
                    call: Call<List<Photo>>,
                    response: Response<List<Photo>>
                ) {
                    response.body()?.let { it1 -> recyclerView.updateData(it1) }
                }

                override fun onFailure(call: Call<List<Photo>>, t: Throwable) {

                }
            })
        }
    }
}
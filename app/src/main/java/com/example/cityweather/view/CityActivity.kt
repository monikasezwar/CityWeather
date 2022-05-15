package com.example.cityweather.view

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cityweather.R
import com.example.cityweather.databinding.ActivityCityBinding
import com.example.cityweather.viewmodel.CityViewModel

class CityActivity: AppCompatActivity() {

    private lateinit var mBinding: ActivityCityBinding
    private lateinit var mCityViewModel: CityViewModel
    private lateinit var mCityName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_city)
        mCityViewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        mCityName = findViewById(R.id.city)
        mCityName.text = intent.getStringExtra("city_name").toString()
        mBinding.cityViewModel = mCityViewModel
        mBinding.lifecycleOwner = this
        mCityViewModel.getCityWeather(intent.getStringExtra("city_name").toString()).observe(this,
            Observer {
                if(it == null){
                    Toast.makeText(this, "You might have entered wrong city name...please try again", Toast.LENGTH_LONG).show()
                    onBackPressed()
                }
            })
    }
}
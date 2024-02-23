package com.avoxis.diskominfointerview.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.avoxis.diskominfointerview.R
import com.avoxis.diskominfointerview.base.BaseActivity
import com.avoxis.diskominfointerview.databinding.ActivityMainBinding
import com.avoxis.diskominfointerview.main.adapter.WidgetAdapter
import com.avoxis.diskominfointerview.main.model.GetAllWidgetResponse
import com.avoxis.diskominfointerview.main.presenter.MainPresenter
import com.avoxis.diskominfointerview.main.view.MainView

class MainActivity : BaseActivity(), MainView {
    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding

    lateinit var presenter: MainPresenter

    lateinit var adapter: WidgetAdapter

    var page = 1
    var pageSize = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        initRecycler()

        requestData()
    }

    private fun requestData() {
        presenter.getAllWidget(sessionManager.getToken()!!, page, pageSize)
    }

    private fun initRecycler() {
        adapter = WidgetAdapter()
        binding.rvWidgetList.adapter = adapter
    }

    override fun onSuccessGetListWidget(response: GetAllWidgetResponse) {
        adapter.addAllWidget(response.data)
    }

    override fun onError(error: Throwable) {
        Log.e(TAG, error.message.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposePresenter()
    }
}
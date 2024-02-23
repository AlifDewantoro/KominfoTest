package com.avoxis.diskominfointerview.main.presenter

import com.avoxis.diskominfointerview.base.BasePresenter
import com.avoxis.diskominfointerview.main.model.GetAllWidgetResponse
import com.avoxis.diskominfointerview.main.view.MainView
import com.avoxis.diskominfointerview.network.ApiInterface
import com.avoxis.diskominfointerview.network.NetworkConfig
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class MainPresenter(view: MainView): BasePresenter() {
    private var view: MainView
    private var service: ApiInterface

    init {
        this.view = view
        this.service = NetworkConfig().services
    }

    fun getAllWidget(token: String, page: Int, pageSize: Int){
        view.onShowLoading()
        disposable = retrofit.services.getAllWidget("Bearer $token", page, pageSize)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::onResponseGetAllWidget, this::handleError)
    }

    fun onResponseGetAllWidget(response: GetAllWidgetResponse){
        view.onHideLoading()
        view.onSuccessGetListWidget(response)
    }


    private fun handleError(error: Throwable){
        view.onHideLoading()
        view.onError(error)
    }
}
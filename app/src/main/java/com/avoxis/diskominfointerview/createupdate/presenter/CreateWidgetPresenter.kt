package com.avoxis.diskominfointerview.createupdate.presenter

import com.avoxis.diskominfointerview.base.BasePresenter
import com.avoxis.diskominfointerview.createupdate.model.CreateWidgetResponse
import com.avoxis.diskominfointerview.createupdate.view.CreateUpdateView
import com.avoxis.diskominfointerview.main.model.GetAllWidgetResponse
import com.avoxis.diskominfointerview.network.ApiInterface
import com.avoxis.diskominfointerview.network.NetworkConfig
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody

open class CreateWidgetPresenter(view: CreateUpdateView): BasePresenter() {
    private var view: CreateUpdateView
    private var service: ApiInterface

    init {
        this.view = view
        this.service = NetworkConfig().services
    }

    fun createWidget(token: String, data: RequestBody){
        view.onShowLoading()
        disposable = retrofit.services.createWidget("Bearer $token", data)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::onResponseCreateWidget, this::handleError)
    }

    fun onResponseCreateWidget(response: CreateWidgetResponse){
        view.onHideLoading()
        view.onSuccessCreateWidget(response)
    }


    private fun handleError(error: Throwable){
        view.onHideLoading()
        view.onError(error)
    }
}
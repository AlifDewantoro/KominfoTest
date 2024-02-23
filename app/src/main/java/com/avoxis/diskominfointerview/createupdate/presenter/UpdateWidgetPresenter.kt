package com.avoxis.diskominfointerview.createupdate.presenter

import com.avoxis.diskominfointerview.base.BasePresenter
import com.avoxis.diskominfointerview.createupdate.model.CreateWidgetResponse
import com.avoxis.diskominfointerview.createupdate.model.UpdateWidgetResponse
import com.avoxis.diskominfointerview.createupdate.view.CreateUpdateView
import com.avoxis.diskominfointerview.main.model.GetAllWidgetResponse
import com.avoxis.diskominfointerview.network.ApiInterface
import com.avoxis.diskominfointerview.network.NetworkConfig
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody

open class UpdateWidgetPresenter(view: CreateUpdateView): BasePresenter() {
    private var view: CreateUpdateView
    private var service: ApiInterface

    init {
        this.view = view
        this.service = NetworkConfig().services
    }

    fun updateWidget(token: String, id: String, data: RequestBody){
        view.onShowLoading()
        disposable = retrofit.services.updateWidget("Bearer $token", data, id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::onResponseUpdateWidget, this::handleError)
    }

    fun onResponseUpdateWidget(response: UpdateWidgetResponse){
        view.onHideLoading()
        view.onSuccessUpdateWidget(response)
    }


    private fun handleError(error: Throwable){
        view.onHideLoading()
        view.onError(error)
    }
}
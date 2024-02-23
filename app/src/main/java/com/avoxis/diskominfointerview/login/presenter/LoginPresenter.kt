package com.avoxis.diskominfointerview.login.presenter

import android.content.Context
import com.avoxis.diskominfointerview.BuildConfig
import com.avoxis.diskominfointerview.base.BasePresenter
import com.avoxis.diskominfointerview.login.view.LoginView
import com.avoxis.diskominfointerview.network.ApiInterface
import com.avoxis.diskominfointerview.network.NetworkConfig
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody
import okhttp3.ResponseBody

open class LoginPresenter(view: LoginView): BasePresenter() {
    private var view: LoginView
    private var service: ApiInterface

    init {
        this.view = view
        this.service = NetworkConfig().services
    }

    fun getLogin(data : RequestBody){
        view.onShowLoading()
        disposable = retrofit.services.getLogin(BuildConfig.STATIC_TOKEN_V2, data)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::onResponseLogin, this::handleError)
    }

    fun onResponseLogin(response: ResponseBody){
        view.onHideLoading()
        view.onSuccessLogin(response.toString())
    }


    private fun handleError(error: Throwable){
        view.onHideLoading()
        view.onError(error)
    }
}
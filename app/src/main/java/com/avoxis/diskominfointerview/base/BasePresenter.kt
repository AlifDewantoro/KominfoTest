package com.avoxis.diskominfointerview.base

import android.util.Log
import com.avoxis.diskominfointerview.network.NetworkConfig
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import org.json.JSONObject


open class BasePresenter {
    var retrofit = NetworkConfig()
    var disposable: Disposable? = null

    open fun disposePresenter(){
        disposable?.dispose()
    }
}
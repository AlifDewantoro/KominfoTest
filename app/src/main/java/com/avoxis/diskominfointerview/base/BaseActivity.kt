package com.avoxis.diskominfointerview.base

import android.app.Dialog
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.avoxis.diskominfointerview.BuildConfig
import com.avoxis.diskominfointerview.R
import com.avoxis.diskominfointerview.helper.SessionManager

open class BaseActivity: AppCompatActivity(), BaseView {
    lateinit var sessionManager: SessionManager
    lateinit var loading: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(this);
        initLoading()
    }

    fun initLoading() {
        loading = Dialog(this, R.style.DialogTheme)
        loading.setContentView(R.layout.dialog_loading)
        loading.window?.setBackgroundDrawableResource(R.color.colorTransparent)
        loading.setCancelable(false)
    }

    override fun onShowLoading() {
        loading.show()
    }

    override fun onHideLoading() {
        loading.hide()
    }

    override fun onError(error: Throwable) {
        Toast.makeText(this, error.localizedMessage, Toast.LENGTH_LONG).show()
    }
}
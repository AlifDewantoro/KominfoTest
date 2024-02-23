package com.avoxis.diskominfointerview.base

interface BaseView {
    fun onShowLoading()
    fun onHideLoading()
    fun onError(error: Throwable)
}
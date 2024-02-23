package com.avoxis.diskominfointerview.login.view

import com.avoxis.diskominfointerview.base.BaseView

interface LoginView : BaseView{
    fun onSuccessLogin(token: String)
}
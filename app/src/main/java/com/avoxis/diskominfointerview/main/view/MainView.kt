package com.avoxis.diskominfointerview.main.view

import com.avoxis.diskominfointerview.base.BaseView
import com.avoxis.diskominfointerview.main.model.GetAllWidgetResponse

interface MainView : BaseView{
    fun onSuccessGetListWidget(response: GetAllWidgetResponse)
}
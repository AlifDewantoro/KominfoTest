package com.avoxis.diskominfointerview.createupdate.view

import com.avoxis.diskominfointerview.base.BaseView
import com.avoxis.diskominfointerview.createupdate.model.CreateWidgetResponse
import com.avoxis.diskominfointerview.createupdate.model.UpdateWidgetResponse
import com.avoxis.diskominfointerview.main.model.GetAllWidgetResponse

interface CreateUpdateView : BaseView{
    fun onSuccessCreateWidget(response: CreateWidgetResponse)
    fun onSuccessUpdateWidget(response: UpdateWidgetResponse)
}
package com.avoxis.diskominfointerview.createupdate

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.avoxis.diskominfointerview.base.BaseActivity
import com.avoxis.diskominfointerview.createupdate.model.CreateWidgetResponse
import com.avoxis.diskominfointerview.createupdate.model.UpdateWidgetResponse
import com.avoxis.diskominfointerview.createupdate.presenter.CreateWidgetPresenter
import com.avoxis.diskominfointerview.createupdate.presenter.UpdateWidgetPresenter
import com.avoxis.diskominfointerview.createupdate.view.CreateUpdateView
import com.avoxis.diskominfointerview.databinding.ActivityCreateUpdateBinding
import okhttp3.MultipartBody
import okhttp3.RequestBody


class CreateUpdateActivity : BaseActivity(), CreateUpdateView {

    private val TAG = "CreateUpdateActivity"
    lateinit var binding: ActivityCreateUpdateBinding
    lateinit var presenterCreate:CreateWidgetPresenter
    lateinit var presenterUpdate:UpdateWidgetPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenterCreate = CreateWidgetPresenter(this)
        presenterUpdate = UpdateWidgetPresenter(this)
        initListener()
    }

    private fun initListener(){
        binding.btnSave.setOnClickListener {

            var allpages = if (binding.RbIsAllPageYes.isChecked) 1 else 0
            var publish = if (binding.RbIsPublishYes.isChecked) 1 else 0

            val requestBody: RequestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("title", binding.edTitle.text.toString())
                .addFormDataPart("opt", binding.edPopUp.text.toString())
                .addFormDataPart("message", binding.edMessage.text.toString())
                .addFormDataPart("allpages", allpages.toString())
                .addFormDataPart("publish", publish.toString())
                .build()

            presenterCreate.createWidget(sessionManager.getToken()!!, requestBody)

        }
    }

    override fun onSuccessCreateWidget(response: CreateWidgetResponse) {
        Toast.makeText(this, "Success Create", Toast.LENGTH_LONG).show()
    }

    override fun onSuccessUpdateWidget(response: UpdateWidgetResponse) {
        Toast.makeText(this, "Success Update", Toast.LENGTH_LONG).show()
    }

    override fun onError(error: Throwable) {
        Log.e(TAG, error.message.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenterCreate.disposePresenter()
        presenterUpdate.disposePresenter()
    }
}
package com.avoxis.diskominfointerview.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.avoxis.diskominfointerview.R
import com.avoxis.diskominfointerview.base.BaseActivity
import com.avoxis.diskominfointerview.databinding.ActivityLoginBinding
import com.avoxis.diskominfointerview.login.presenter.LoginPresenter
import com.avoxis.diskominfointerview.login.view.LoginView
import com.avoxis.diskominfointerview.main.MainActivity
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

class LoginActivity : BaseActivity(), LoginView {
    private val TAG = "LoginActivity"
    lateinit var binding: ActivityLoginBinding

    lateinit var presenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this)

        setListener()
        binding.edUsername.setText("admin@gmail.com")
        binding.edPassword.setText("12345678")
    }

    private fun setListener() {
        binding.btnLogin.setOnClickListener {
            val data = HashMap<String, String>()
            data.put("email", binding.edUsername.text.toString())
            data.put("password", binding.edPassword.text.toString())
            val body = RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), Gson().toJson(data).toString())
            presenter.getLogin(body)
        }
    }

    override fun onSuccessLogin(token: String) {
        sessionManager.setToken(token)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onShowLoading() {
        loading.show()
    }

    override fun onHideLoading() {
        loading.dismiss()
    }

    override fun onError(error: Throwable) {
        Log.e(TAG, error.message.toString())
        Toast.makeText(this, error.localizedMessage, Toast.LENGTH_LONG).show()
    }
}
package com.example.developers

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.developers.api.DisplayMessageActivity
import com.example.developers.databinding.DatabindingLaoutBinding


class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding:DatabindingLaoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.test_layout)
         dataBinding= setContentView(this, R.layout.databinding_laout)
        val user = User("User")
        dataBinding.user = user

    }

    fun sendMessage(view: View) {
        val intent = Intent(this, DisplayMessageActivity::class.java)
        val editText = findViewById<View>(R.id.editText) as EditText
        val message = editText.text.toString()
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, message)
        startActivity(intent)
    }
}
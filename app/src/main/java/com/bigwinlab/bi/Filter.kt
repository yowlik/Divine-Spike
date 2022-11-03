package com.bigwinlab.bi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bigwinlab.bi.cl.Gamea

class Filter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        val nameTest: String? = sharPref.getString(Appcl.C1, "null")
        val deepTest: String? = sharPref.getString(Appcl.D1, "null")
        if (nameTest!!.contains("tdb2")){
            Log.d("zero_filter", "nameWeb")
            Intent(this, Web::class.java)
                .also { startActivity(it) }
            finish()
        }
        else if(deepTest!!.contains("tdb2")){
            Log.d("zero_filter", "deepWeb")
            Intent(this, Web::class.java)
                .also { startActivity(it) }
            finish()
        }
        else{
            Log.d("zero_filter", "toGame")
            Intent(this, Gamea::class.java)
                .also { startActivity(it) }
            finish()
        }

    }
}
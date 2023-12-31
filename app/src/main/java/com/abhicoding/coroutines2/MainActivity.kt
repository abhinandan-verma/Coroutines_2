package com.abhicoding.coroutines2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.abhicoding.coroutines2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            Log.v("TAG","The App has Started ✅")
            val one = async {
                doSomething1()
            }
            val two = async {
                doSomething2()
            }

            val result = one.await() + two.await()
            Log.v("TAG","The result is $result")
        }

    }

    private suspend fun doSomething1(): Int{
        delay(3500)
        Log.v("TAG","fun1 is Done")
        return  11
    }
    private suspend fun doSomething2(): Int{
        delay(7000)
        Log.v("TAG","fun2 is Done")
        return 8

    }

}
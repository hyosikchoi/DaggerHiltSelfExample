package kr.co.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kr.co.daggerhilt.remote.ExternalApi
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@AndroidEntryPoint
class MainActivity : AppCompatActivity() , CoroutineScope {

    val job : Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    @Inject lateinit var api : ExternalApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView()  = launch {
        withContext(Dispatchers.IO) {
            val response = api.pingPong()
            if(response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity , "response : ${response.body()}" , Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}
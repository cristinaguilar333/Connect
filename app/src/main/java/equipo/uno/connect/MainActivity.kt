package equipo.uno.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import java.util.Timer;
import java.util.TimerTask;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Connect)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
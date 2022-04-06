package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import java.util.Timer;
import java.util.TimerTask;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Connect)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        var intent:Intent = Intent(this, Registro::class.java)
        startActivity(intent)
        finish()

    }
}
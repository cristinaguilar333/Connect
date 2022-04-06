package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class activity_iniciosesion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciosesion)

        val iniciar : Button = findViewById(R.id.btnEntrar)

        iniciar.setOnClickListener{
            var intent : Intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
    }
}
//comentario random
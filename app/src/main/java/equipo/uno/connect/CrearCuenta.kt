package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class CrearCuenta : AppCompatActivity() {

    val imagen: ImageView = findViewById(R.id.imageView2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)
    }

    fun onclick(view: View) {
        cargarImgen()
    }

    fun cargarImgen(){

    }
}
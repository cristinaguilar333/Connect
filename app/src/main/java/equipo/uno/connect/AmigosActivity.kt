package equipo.uno.connect

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class AmigosActivity : AppCompatActivity() {
    var listaAmigos = ArrayList<Amigo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amigos)

        agregarAmigos()

        var listView: ListView = findViewById(R.id.listAmigos_view) as ListView
        var adaptador: AdaptadorAmigos=AdaptadorAmigos(this,listaAmigos)
        listView.adapter=adaptador

        var btn_RegresarAmigos: ImageButton = findViewById(R.id.btn_RegresarAmigos)

        btn_RegresarAmigos.setOnClickListener{
            var intent : Intent = Intent(this,ChatActivity::class.java)
            startActivity(intent)
        }

    }

    fun agregarAmigos(){
        listaAmigos.add(Amigo("María", R.drawable.circulo))
        listaAmigos.add(Amigo("Ernesto", R.drawable.circulo))
        listaAmigos.add(Amigo("Felipe", R.drawable.circulo))
        listaAmigos.add(Amigo("Juan", R.drawable.circulo))
        listaAmigos.add(Amigo("Michelle", R.drawable.circulo))
    }

    private class AdaptadorAmigos: BaseAdapter {
        var amigos = ArrayList<Amigo>()
        var contexto: Context?=null

        constructor(contexto: Context, amigo: ArrayList<Amigo>){
            this.amigos = amigo
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return amigos.size
        }

        override fun getItem(p0: Int): Any {
            return amigos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var ami = amigos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.amigos_view,null)

            var imagen = vista.findViewById(R.id.amigos_img) as ImageView
            var nombre = vista.findViewById(R.id.amigo_nombre) as TextView

            imagen.setImageResource(ami.img)
            nombre.setText(ami.name)

            return vista
        }


    }

}
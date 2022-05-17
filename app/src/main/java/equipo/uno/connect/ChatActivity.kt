package equipo.uno.connect

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity


class ChatActivity : AppCompatActivity() {
    var listaChats = ArrayList<Chat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        agregarChats()

        var listView: ListView = findViewById(R.id.listChat_view) as ListView
        var adaptador: ChatActivity.AdaptadorChat =
            ChatActivity.AdaptadorChat(this, listaChats)
        listView.adapter=adaptador

        val nombreUsuario = intent.getStringExtra("nombreUsuario")




        //val chatIn : ImageButton= findViewById(R.id.botonchatIndv)

        val chats : ListView=findViewById(R.id.listChat_view)

        val accesoRapido : TextView = findViewById(R.id.tvAccesoRapido)
        val calendario: TextView = findViewById(R.id.tvCalendario)
        val ajustes : ImageButton = findViewById(R.id.btnAjustes)
        val amigos : ImageButton = findViewById(R.id.btnAmigos)
        val btnperfil : ImageButton = findViewById(R.id.btnPerfil)



        chats.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            // Position es el indice del elemento del ListView donde hacemos click
            var intent : Intent = Intent(this, chatIndividual::class.java)
            intent.putExtra("nombre", "María")
            intent.putExtra("nombreUsuario", nombreUsuario)
            startActivity(intent)
        })


        //chatIn.setOnClickListener {
         //   var intent : Intent = Intent(this,chatIndividual::class.java)
         //   startActivity(intent)
       // }


        accesoRapido.setOnClickListener {
            var intent : Intent = Intent(this,AccesoRapidoActivity::class.java)
            startActivity(intent)
        }

        calendario.setOnClickListener {
            var intent : Intent = Intent(this, Calendario::class.java)
            startActivity(intent)
        }

        ajustes.setOnClickListener {
            var intent : Intent = Intent(this, configuracion::class.java)
            startActivity(intent)
        }

        amigos.setOnClickListener {
            var intent : Intent = Intent(this, AmigosActivity::class.java)
            startActivity(intent)
        }

        btnperfil.setOnClickListener {
            var intent : Intent = Intent(this, perfil::class.java)
            startActivity(intent)
        }

    }

    fun agregarChats(){
        listaChats.add(Chat("María", R.drawable.circulo, "Hola ¿Cómo estás?"))
        listaChats.add(Chat("Equipo 3", R.drawable.circulo, "Felipe: ¡Bienvenidos al grupo!"))
        listaChats.add(Chat("Ernesto", R.drawable.circulo, "Archivo adjunto"))
    }

    private class AdaptadorChat: BaseAdapter {
        var chats = ArrayList<Chat>()
        var contexto: Context?=null

        constructor(contexto: Context, chat: ArrayList<Chat>){
            this.chats = chat
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return chats.size
        }

        override fun getItem(p0: Int): Any {
            return chats[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var cha = chats[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.chats_view,null)

            var imagen = vista.findViewById(R.id.chat_img) as ImageView
            var nombre = vista.findViewById(R.id.chat_nombre) as TextView
            var mensaje = vista.findViewById(R.id.chat_mensaje) as TextView

            imagen.setImageResource(cha.image)
            nombre.setText(cha.name)
            mensaje.setText(cha.mensaje)

            return vista
        }
    }

}
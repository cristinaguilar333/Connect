package equipo.uno.connect.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import equipo.uno.connect.Nota
import equipo.uno.connect.R

class NotaAdapter(private val empList : ArrayList<Nota>) : RecyclerView.Adapter<NotaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.notas_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotaAdapter.ViewHolder, position: Int) {
        val currentNota = empList[position]
        holder.tvTitulo.text = currentNota.titulo
    }

    override fun getItemCount(): Int {
        return empList.size
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo : TextView = itemView.findViewById(R.id.tvTituloNota)
    }
}
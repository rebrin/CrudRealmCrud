package mx.edu.itsp.curso.crudrealm.clases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_row_dog.view.*
import mx.edu.itsp.curso.crudrealm.R

class DogAdapter(val data: MutableList<Dog>, var listenerG: onDogItemListener):
        RecyclerView.Adapter<DogAdapter.ViewHolder>() {
     var perros:MutableList<Dog>?=null


    init {
        this.perros=data
    }

    class ViewHolder(view:View,listener:onDogItemListener):RecyclerView.ViewHolder(view),View.OnClickListener{
        var tvNombre:TextView?=null
        var tvEdad:TextView?=null
        var tvRaza:TextView?=null
        var listener:onDogItemListener?=null

        init {
            tvNombre=view.tvNombre
            tvEdad=view.tvEdad
            tvRaza=view.tvRaza
            this.listener=listener
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener!!.onClickDog(v!!,adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item=LayoutInflater.from(parent?.context)
            .inflate(R.layout.layout_row_dog,parent,false)
        return ViewHolder(item,listenerG)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=perros?.get(position)
        holder.tvNombre?.text=item?.nombre.toString()
        holder.tvEdad?.text=item?.edad.toString()
        holder.tvRaza?.text=item?.raza.toString()
    }

    override fun getItemCount(): Int {
        return perros!!.count()
    }

    interface onDogItemListener{
        fun onClickDog(item:View,position: Int)
    }

}
package com.hfad.ls04demo.adapter

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hfad.ls04demo.R
import edu.quinnipiac.ser210.ls04_recycleview.model.Affirmation

class itemAdapter(private val context: Context, private var dataset: List<Affirmation>):RecyclerView.Adapter<itemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View, private val context:Context): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        private var currAffirmation: Affirmation? =null;

        init {
            itemView.setOnClickListener(){
                Toast.makeText(context, "a click event", Toast.LENGTH_LONG).show()
            }
        }

        fun bind(affirmation: Affirmation){
            textView.text = context.resources.getString(affirmation.stringResourceId)
            if(affirmation.image !=null){
                imageView.setImageResource(affirmation.image)
            } else
                imageView.setImageResource(R.drawable.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(adapterLayout,context)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item)
    }

    fun addItemToDataset():Int{
        dataset = dataset + Affirmation(R.string.affirmation1,R.drawable.img)
        notifyItemInserted(dataset.size)
        return dataset.size
    }
}
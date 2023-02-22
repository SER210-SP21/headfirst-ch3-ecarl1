package com.hfad.ls04demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hfad.ls04demo.adapter.itemAdapter
import edu.quinnipiac.ser210.ls04_recycleview.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)
        recyclerView.adapter = itemAdapter(this,myDataset)

        recyclerView.setHasFixedSize(true)

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fab)
        floatingActionButton.setOnClickListener(){
            val dataSetSize:Int = (recyclerView.adapter as itemAdapter).addItemToDataset()
            recyclerView.smoothScrollToPosition(dataSetSize)
        }
    }
}
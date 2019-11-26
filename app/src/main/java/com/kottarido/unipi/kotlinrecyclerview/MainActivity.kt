package com.kottarido.unipi.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.kottarido.unipi.kotlinrecyclerview.models.BlogPost
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // to lateinit var simenei oti i metavliti den exei timi prostoparon
    // alla tha arxikopoieithei sintoma
    // (einai san auto pou diloname global tis metavlites stin java kai tis arxikopoiousame meta)
    private lateinit var  blogAdapter: BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // arxikopoiei ta data
        val data = DataSource.createDataSet()
        initRecyclerView(data)
    }

    // ftiaxnw tin methodo pou arxikopoiei to recycler view
    private fun initRecyclerView(data : ArrayList<BlogPost>){
        recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            blogAdapter = BlogRecyclerAdapter(data)
            adapter = blogAdapter
        }
    }
}

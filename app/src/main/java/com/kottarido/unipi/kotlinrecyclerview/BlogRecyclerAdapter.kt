package com.kottarido.unipi.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kottarido.unipi.kotlinrecyclerview.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

// H ano kato telia simeni extends
// H class mas kanei extend tin RecyclerviewAdapter class
class BlogRecyclerAdapter(blogList :ArrayList<BlogPost>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // dilonoume to dataset pou tha kanoume display
    private var items = blogList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // auto einai to idio opos to kaname stin java
        // pernoume to context tou viewGroup (parent), kanoume inflate to layout tou item kai to pername ston viewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        return BlogViewHolder(view)
    }

    // ti tha ginete otan kanw bind ton view holder me to view
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //an exw pola diaforetika layouts -> ara kai polous viewHolders kanw to e3is
        when(holder){
            is BlogViewHolder ->{
                // kanei bind ta items tou view me ta stixia tou post
                holder.bind(items.get(position))
            }
            // an eixa kialous viewHolders tha tous evaza edo
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // auti i class pernei ta data apo to dataset kai ta vazei ston view holder
    // kathe item tou recycler view apotelite apo enan viewholder pou krataei ta views to Item
    // kanei extend ton recyclerview viewHolder kai tou pernaei to item view opos ekana kai stin
    // java sto super tou constructor
    class BlogViewHolder (
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        // auto einai san na kaname itemView.findViewById() stin java
        // anaferete sto imageView pou exei to item opou to blog_image einai to id
        var blogImage = itemView.blog_image
        // anaferete sto textView pou exei to item kai periexei ton titlo opou to blog_title einai to id
        var blogTitle = itemView.blog_title
        // anaferete sto textView pou exei to item kai periexei ton sigkrafea opou to blog_author einai to id
        var blogAuthor = itemView.blog_author

        // ftiaxnei tin bind method i opoia einai ipeuthini gia na dimirougei to item tou kathe post sto recycler view
        // kai dexete to BlogPost san orisma
        fun bind(blogPost: BlogPost){
            blogTitle.setText(blogPost.title)
            blogAuthor.setText(blogPost.username)

            // edo fortonei to url pou einai apothikeumeno sto blog post kai to metatrepei se eikona
            // gia arxi ftiaxnoume ena request object to opoio einai ena glide object
            // sto opoio leme ti eikona tha provalei se periptosei pou iparxei error
            // i an gia kapio logo i eikona den mpori na ginei display (placeholder)
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            // edo leme ston glide pia eikona tha fortosei
            // kai se pio view na tin valei
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blogImage)
        }
    }


    // methodos pou xrisimopoiite gia na kanoume set tin list me ta post
    fun submitList(blogList: ArrayList<BlogPost>){
        items=blogList
    }

}
package eu.tutorials.assignment_task1.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import eu.tutorials.assignment_task1.R
import eu.tutorials.assignment_task1.model.Shopping
import kotlinx.coroutines.NonDisposableHandle.parent

class RecyclerAdapter(var con : Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var itemList: ArrayList<Shopping> = ArrayList()
//    private lateinit var con : Context

    private lateinit var bundle: Bundle


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.gridlist_cardlayout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(con).load(itemList[position].image).into(holder.image)
        holder.icon.setImageResource(R.drawable.hearticon)
//        holder.image.setImageResource(R.drawable.searchicon)
        holder.name.text = itemList[position].name
        holder.description.text = itemList[position].description
//        bundle = Bundle()
//        holder.L1.setOnClickListener {
//            clickListner.onclick(position, bundle)
//
//        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val icon: ImageView = itemView.findViewById(R.id.wishlist)
        val image: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.desc)
//        val L1 : RelativeLayout = itemView.findViewById(R.id.L1)
    }

    fun getList(list: ArrayList<Shopping>) {
        itemList = list
        notifyDataSetChanged()
    }

}
package com.example.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val arrayList: ArrayList<Model>, val context: Context) :
        RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: Model) {
            itemView.title_tv.text = model.title
            itemView.description_tv.text = model.des
            itemView.iv.setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
        var e = arrayList.get(arrayList.size -1)

        holder.itemView.setOnClickListener{
           val model = arrayList.get(position) //선택된 아이템의 순서 얻기

            // get title and description of selected item with intent
            val gTitle : String = model.title
            var gDescription : String = model.des
            // get image with intent, which position
            var gImageView : Int = model.image


            // create intent in kotlin
            //배열값 비교 후 어레이리스트 마지막 인자일 경우 connect 엑티비티 호출
            if (arrayList.get(position) == e  ){
                val intent = Intent(context,ConnectActivity::class.java)
                context.startActivity(intent)
            }
            else {
                val intent = Intent(context, ClickActivity::class.java)
                //now put all these items with putExtra intnet
                intent.putExtra("iTitle", gTitle)
                intent.putExtra("iDescription", gDescription)
                intent.putExtra("iImageView", gImageView)



                context.startActivity(intent)
                }
            }
        }
}

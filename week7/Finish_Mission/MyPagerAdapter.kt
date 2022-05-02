package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPagerBinding

class MyPagerViewHolder(val binding1: ItemPagerBinding) : RecyclerView.ViewHolder(binding1.root)
class MyPagerAdapter( val datas:MutableList<String>, val context: Context, var fragmentManager: FragmentManager) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder =
        MyPagerViewHolder(ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder:RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyPagerViewHolder).binding1
        val datas = mutableListOf<String>()
        for (i in 1..20) {
            datas.add("item $i")
        }
        var onClicked = false
        if (position == 0) {
            binding.fragBut1.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.INVISIBLE

            binding.fragBut1.setOnClickListener {
                if (onClicked) {
                    onClicked = false
                    val transaction : FragmentTransaction = fragmentManager.beginTransaction()
                    val frameLayout = fragmentManager.findFragmentById(binding.fragmentContent.id)
                    transaction.remove(frameLayout!!).commit()
                } else {
                    onClicked = true
                    val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                    transaction.add(binding.fragmentContent.id, OneFragment()).commit()
                }
            }
        } else if (position == 1) {
            binding.fragBut1.visibility = View.INVISIBLE
            binding.fragmentContent.visibility = View.INVISIBLE
            binding.recyclerView.visibility = View.VISIBLE

            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter = MyAdapter(datas)
            binding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                    context, LinearLayoutManager.VERTICAL
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}
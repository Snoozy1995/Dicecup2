package easv.oe.dicecup2.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData

import easv.oe.dicecup2.placeholder.PlaceholderContent.PlaceholderItem
import easv.oe.dicecup2.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: MutableList<List<Int>>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values?.get(position);
        holder.idView.text = position.toString()

        var res:String="";
        if (item != null) {
            for (it in item){
                res+= " $it";
            }
        }

        holder.contentView.text = res;
    }

    override fun getItemCount(): Int {
        return values?.size ?: 0;
    }

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}
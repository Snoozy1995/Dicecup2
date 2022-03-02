package easv.oe.dicecup2.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import easv.oe.dicecup2.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [List<List<Int>>].
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
        val item = values[position];
        holder.idView.text =(values.size-position).toString()

        var res:String="";
        for (it in item){
            res+= " $it";
        }

        holder.contentView.text = res;
    }

    override fun getItemCount(): Int {
        return values.size
    }

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}
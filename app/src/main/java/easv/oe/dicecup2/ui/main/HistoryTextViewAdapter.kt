package easv.oe.dicecup2.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import easv.oe.dicecup2.DicePlay

import easv.oe.dicecup2.databinding.FragmentItemBinding
import java.text.SimpleDateFormat

/**
 * [RecyclerView.Adapter] that can display a [List<List<Int>>].
 */
class HistoryTextViewAdapter(
    private val values: MutableList<DicePlay>
) : RecyclerView.Adapter<HistoryTextViewAdapter.ViewHolder>() {

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
        val sdf = SimpleDateFormat("dd/M hh:mm")
        val currentDate = sdf.format(item.timestamp)
        holder.idView.text =(values.size-position).toString()+". "+currentDate

        var res:String="";
        for (it in item.playHistory){
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
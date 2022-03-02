package easv.oe.dicecup2.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import easv.oe.dicecup2.DicePlay
import easv.oe.dicecup2.R
import easv.oe.dicecup2.databinding.FragmentItemImageBinding
import java.text.SimpleDateFormat


/**
 * [RecyclerView.Adapter] that can display a [List<List<Int>>].
 */
class HistoryImageViewAdapter(
    private val values: MutableList<DicePlay>
) : RecyclerView.Adapter<HistoryImageViewAdapter.ViewHolder2>() {
    // mapping from 1..6 to drawables, the first index is unused
    private val diceId = intArrayOf(0, R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {

        return ViewHolder2(
            FragmentItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        val item = values[position];
        val sdf = SimpleDateFormat("dd/M hh:mm")
        val currentDate = sdf.format(item.timestamp)
        holder.idView.text =(values.size-position).toString()+". "+currentDate

        var x=item.playHistory.size;
        while (x > 0) {
            when (x) {
                1 -> { holder.imageView1.setImageResource(diceId[item.playHistory[x-1]]) }
                2 -> { holder.imageView2.setImageResource(diceId[item.playHistory[x-1]]) }
                3 -> { holder.imageView3.setImageResource(diceId[item.playHistory[x-1]]) }
                4 -> { holder.imageView4.setImageResource(diceId[item.playHistory[x-1]]) }
                5 -> { holder.imageView5.setImageResource(diceId[item.playHistory[x-1]]) }
                6 -> { holder.imageView6.setImageResource(diceId[item.playHistory[x-1]]) }
            }
            x--
        }

        //Not really how id like it to go eh...
        if(item.playHistory.size>=2){
            holder.imageView2.visibility= View.VISIBLE;
        }else{
            holder.imageView2.visibility= View.GONE;
        }

        if(item.playHistory.size>=3){
            holder.imageView3.visibility= View.VISIBLE;
        }else{
            holder.imageView3.visibility= View.GONE;
        }

        if(item.playHistory.size>=4){
            holder.imageView4.visibility= View.VISIBLE;
        }else{
            holder.imageView4.visibility= View.GONE;
        }

        if(item.playHistory.size>=5){
            holder.imageView5.visibility= View.VISIBLE;
        }else{
            holder.imageView5.visibility= View.GONE;
        }

        if(item.playHistory.size>=6){
            holder.imageView6.visibility= View.VISIBLE;
        }else{
            holder.imageView6.visibility= View.GONE;
        }

        //holder.contentView.text = res;
    }

    override fun getItemCount(): Int {
        return values.size
    }

    inner class ViewHolder2(binding: FragmentItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber

        val imageView1: ImageView = binding.imageView1
        val imageView2: ImageView = binding.imageView2
        val imageView3: ImageView = binding.imageView3
        val imageView4: ImageView = binding.imageView4
        val imageView5: ImageView = binding.imageView5
        val imageView6: ImageView = binding.imageView6

    }

}
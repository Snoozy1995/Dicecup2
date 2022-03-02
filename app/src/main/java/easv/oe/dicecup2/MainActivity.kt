package easv.oe.dicecup2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val TAG: String = "xyz"
    var diceCount=3
    // mapping from 1..6 to drawables, the first index is unused
    private val diceId = intArrayOf(0, R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6)

    private val mRandomGenerator = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRoll.setOnClickListener { v -> onClickRoll() }
        Log.d(TAG, "OnCreate")
        btnHistory.setOnClickListener { v ->
            onClickHistory()
        }

        minusBtn.setOnClickListener{v->addDice(-1)}
        plusBtn.setOnClickListener{v->addDice(+1)}
        if(savedInstanceState!=null){
            diceCount=savedInstanceState.getInt("diceCount");
            if(DicePlays.playHistory.size>0){
                updateDicesWith(DicePlays.playHistory[0]);
            }
        }
        diceCountTextView.setText(diceCount.toString());
        refreshDices();

    }

    override fun onSaveInstanceState(icicle: Bundle) {
        super.onSaveInstanceState(icicle)
        icicle.putInt("diceCount",diceCount)
    }

    private fun addDice(amount:Int){
        if(diceCount+amount<1) return;
        if(diceCount+amount>6) return;
        diceCount += amount;
        diceCountTextView.setText(diceCount.toString());
        refreshDices();
    }

    private fun onClickRoll(){ //Generate dice rolls...
        var list: ArrayList<Int> = ArrayList();
        for (i in 1..diceCount) {
            list.add(mRandomGenerator.nextInt(6) + 1)
        }
        DicePlays.addHistory(list);
        updateDicesWith(list);
        Log.d(TAG, "Roll")
    }

    private fun onClickHistory(){
        intent= Intent(this@MainActivity, HistoryActivity::class.java);
        startActivity(intent)
    }

    private fun updateDicesWith(nums:List<Int>) {
        //Not really how id like it to go eh... Preferably have them in some group/list so they could be iterated instead of manually coding.
        var x=nums.size;
        while (x > 0) {
            when (x) {
                1 -> { imgDice1.setImageResource(diceId[nums[x-1]]) }
                2 -> { imgDice2.setImageResource(diceId[nums[x-1]]) }
                3 -> { imgDice3.setImageResource(diceId[nums[x-1]]) }
                4 -> { imgDice4.setImageResource(diceId[nums[x-1]]) }
                5 -> { imgDice5.setImageResource(diceId[nums[x-1]]) }
                6 -> { imgDice6.setImageResource(diceId[nums[x-1]]) }
            }
            x--
        }
    }

    private fun refreshDices(){
        //Not really how id like it to go eh...
        if(diceCount>=2){
            imgDice2.visibility= View.VISIBLE;
        }else{
            imgDice2.visibility= View.GONE;
        }

        if(diceCount>=3){
            imgDice3.visibility= View.VISIBLE;
        }else{
            imgDice3.visibility= View.GONE;
        }

        if(diceCount>=4){
            layoutDices2.visibility=View.VISIBLE;
            imgDice4.visibility= View.VISIBLE;
        }else{
            layoutDices2.visibility=View.INVISIBLE;
            imgDice4.visibility= View.GONE;
        }

        if(diceCount>=5){
            imgDice5.visibility= View.VISIBLE;
        }else{
            imgDice5.visibility= View.GONE;
        }

        if(diceCount>=6){
            imgDice6.visibility= View.VISIBLE;
        }else{
            imgDice6.visibility= View.GONE;
        }
    }

}

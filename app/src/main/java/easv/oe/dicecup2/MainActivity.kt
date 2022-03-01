package easv.oe.dicecup2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val TAG: String = "xyz"
    var playHistory=arrayListOf<List<Int>>()
    var diceCount=2

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

    }

    private fun onClickRoll(){
        var x=diceCount;
        var list: ArrayList<Int> = ArrayList();
        while (x > 0) {
            list.add(mRandomGenerator.nextInt(6) + 1)
            x--
        }
        playHistory.add(list);
        updateDicesWith(list);
        Log.d(TAG, "Roll")
    }

    private fun onClickHistory(){
        intent= Intent(this@MainActivity, HistoryActivity::class.java);
        intent.putExtra("plays",playHistory);
        startActivity(intent)
    }

    private fun updateDicesWith(nums:List<Int>) {
        imgDice1.isEnabled=false;
        imgDice2.isEnabled=false;
        //Not really how id like it to go eh...
        var x=nums.size;
        while (x > 0) {
            when (x) {
                1 -> {
                    imgDice1.setImageResource(diceId[nums[x-1]]);
                    imgDice1.isEnabled = true;
                }
                2 -> {
                    imgDice2.setImageResource(diceId[nums[x-1]]);
                    imgDice2.isEnabled = false;
                }
                3 -> {

                }
                4 -> {

                }
                5 -> {

                }
                6 -> {

                }
            }
            x--
        }
    }



}

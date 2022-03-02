package easv.oe.dicecup2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import easv.oe.dicecup2.ui.main.HistoryImageFragment
import easv.oe.dicecup2.ui.main.HistoryTextFragment
import kotlinx.android.synthetic.main.history_activity.*


class HistoryActivity : AppCompatActivity() {

    var viewState : Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)
        if (savedInstanceState == null) {
            resetView()
        }
        backBtn.setOnClickListener { v -> goBack() }
        clearHistoryBtn.setOnClickListener { v ->
            clearHistory()
        }
        imagesSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            switchViewState(isChecked)
        }
    }

    private fun switchViewState(value : Boolean){
        Log.d("HistoryActivity","switchViewState");
        viewState=value;
        resetView()
    }

    private fun resetView(){  //Probably much better way to do this
        if(viewState){
            Log.d("HistoryActivity","resetView viewState==true")
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerItem, HistoryImageFragment.newInstance(1))
                .commitNow()
        }else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerItem, HistoryTextFragment.newInstance(1))
                .commitNow()
        }
    }

    private fun goBack(){
        finish()
    }

    private fun clearHistory(){
        DicePlays.clearHistory();
        resetView()
    }
}
package easv.oe.dicecup2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import easv.oe.dicecup2.ui.main.ItemFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.history_activity.*

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ItemFragment.newInstance(1))
                .commitNow()
        }
        backBtn.setOnClickListener { v -> goBack() }
        clearHistoryBtn.setOnClickListener { v ->
            clearHistory()
        }
    }

    private fun goBack(){
        finish()
    }

    private fun clearHistory(){
        DicePlays.clearHistory();
        supportFragmentManager.beginTransaction() //Probably much better way to do this
            .replace(R.id.container, ItemFragment.newInstance(1))
            .commitNow()
    }
}
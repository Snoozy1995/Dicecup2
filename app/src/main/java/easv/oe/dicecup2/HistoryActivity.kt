package easv.oe.dicecup2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import easv.oe.dicecup2.ui.main.HistoryFragment

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HistoryFragment.newInstance())
                .commitNow()
        }
    }
}
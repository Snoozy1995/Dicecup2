package easv.oe.dicecup2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import easv.oe.dicecup2.ui.main.ItemFragment

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ItemFragment.newInstance(1))
                .commitNow()
        }
    }
}
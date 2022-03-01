package easv.oe.dicecup2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import easv.oe.dicecup2.ui.main.ItemFragment

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)
        val frag=ItemFragment.newInstance(1);
        val extras = intent.extras
        if (extras != null) {
            val value = extras.getSerializable("plays")
            val bundle = Bundle()
            bundle.putSerializable("plays",value);
            frag.setArguments(bundle);
            //The key argument here must match that used in the other activity
        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, frag)
                .commitNow()
        }
    }
}
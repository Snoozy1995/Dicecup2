package easv.oe.dicecup2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import easv.oe.dicecup2.placeholder.PlaceholderContent

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    public val playHistory: MutableList<List<Int>> = ArrayList();

    //val playHistory=arrayListOf<List<Int>>();
    fun addPlay( Value:List<Int>){
        var test=playHistory;
        if (test == null) {
            test=ArrayList();
        }
        test.add(Value);
        playHistory.add(Value);
    }

    fun emptyPlays(){
        //_playHistory.postValue(ArrayList());
    }

    override fun onCleared() {
        super.onCleared()
        // Dispose All your Subscriptions to avoid memory leaks
    }
    //val obj = intent.getSerializableExtra("plays") as ArrayList<Any>?
    /*if (obj != null) {
        for (i in obj.indices) {
            val `object` = obj[i] as List<Int>
            playHistory.add(`object`);
            //Log.d(javaClass.simpleName, "OBJ : " + `object`[0])
        }
    }

    val fragmentDemo: DicePlayFragment? = supportFragmentManager.findFragmentById(R.id.frame_container) as DicePlayFragment?
    val fragmentManager: FragmentManager = supportFragmentManager
    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
    if (fragmentDemo != null) {
        val bundle = Bundle()
        bundle.putSerializable("plays",obj);
        fragmentDemo.setArguments(bundle);
        fragmentTransaction.replace(R.id.content, fragmentDemo)
        fragmentTransaction.commit()
    }*/
}
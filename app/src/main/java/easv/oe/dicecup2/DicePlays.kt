package easv.oe.dicecup2

class DicePlays {
    companion object {
        var playHistory=arrayListOf<List<Int>>()
        fun getHistory(): ArrayList<List<Int>> {
            return playHistory
        }
        fun clearHistory(){
            playHistory=arrayListOf()
        }
        fun addHistory(plays  :List<Int>){
            playHistory.add(plays )
        }
    }
}
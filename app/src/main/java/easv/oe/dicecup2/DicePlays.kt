package easv.oe.dicecup2

class DicePlays {
    companion object {
        var playHistory=arrayListOf<DicePlay>()
        fun getHistory(): ArrayList<DicePlay> {
            return playHistory
        }
        fun clearHistory(){
            playHistory=arrayListOf()
        }
        fun addHistory(plays  : DicePlay){
            playHistory.add(0,plays )
        }
    }
}
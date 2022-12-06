fun main(){

    fun part1(): Int {

        var pointsPlayer1 = 0
        var pointsPlayer2 = 0

        // A | X = Rock, B | Y = Paper, C | Z = Scissors
        val pointSelection = mapOf(
            "A" to 1,
            "B" to 2,
            "C" to 3,
            "X" to 1,
            "Y" to 2,
            "Z" to 3)

        val pointResult = mapOf("lost" to 0, "draw" to 3, "win" to 6)

        fun resultPoints(result1: String, selection1: String, result2: String, selection2: String){
            pointsPlayer1 += pointResult[result1]!! + pointSelection[selection1]!!
            pointsPlayer2 += pointResult[result2]!! + pointSelection[selection2]!!
        }

        fun draw(selection: String){
            pointsPlayer1 += pointResult["draw"]!! + pointSelection[selection]!!
            pointsPlayer2 += pointResult["draw"]!! + pointSelection[selection]!!
        }

        val input = readInput("Day02")
        for(i in input){

            when(i.split(" ")){
                listOf("A","X") -> draw("A")
                listOf("A","Y") -> resultPoints("lost", "A","win","Y")
                listOf("A","Z") -> resultPoints("win","A", "lost", "Z")
                listOf("B","X") -> resultPoints("win","B", "lost","X")
                listOf("B","Y") -> draw("B")
                listOf("B","Z") -> resultPoints("lost", "B" ,"win","Z")
                listOf("C","X") -> resultPoints("lost","C","win","X")
                listOf("C","Y") -> resultPoints("win","C","lost","Y")
                listOf("C","Z") -> draw("C")
                else -> continue
            }
        }

        return if (pointsPlayer1 > pointsPlayer2) pointsPlayer1
        else pointsPlayer2
    }

    fun part2(): Int {

        var pointsPlayer1 = 0
        var pointsPlayer2 = 0

        // A | X = Rock, B | Y = Paper, C | Z = Scissors
        val pointSelection = mapOf(
            "A" to 1,
            "B" to 2,
            "C" to 3)

        val pointResult = mapOf("lost" to 0, "draw" to 3, "win" to 6)

        fun resultPoints(result1: String, selection1: String, result2: String, selection2: String){
            pointsPlayer1 += pointResult[result1]!! + pointSelection[selection1]!!
            pointsPlayer2 += pointResult[result2]!! + pointSelection[selection2]!!
        }

        fun draw(selection: String){
            pointsPlayer1 += pointResult["draw"]!! + pointSelection[selection]!!
            pointsPlayer2 += pointResult["draw"]!! + pointSelection[selection]!!
        }

        val input = readInput("Day02")
        for(i in input){

            when(i.split(" ")){
                listOf("A","X") -> resultPoints("lost","C","win","A")
                listOf("A","Y") -> draw("A")
                listOf("A","Z") -> resultPoints("win","B", "lost", "A")
                listOf("B","X") -> resultPoints("lost","A", "win","B")
                listOf("B","Y") -> draw("B")
                listOf("B","Z") -> resultPoints("win", "C" ,"lost","B")
                listOf("C","X") -> resultPoints("lost","B","win","C")
                listOf("C","Y") -> draw("C")
                listOf("C","Z") -> resultPoints("win","A","lost","C")
                else -> continue
            }
        }
        return if (pointsPlayer1 > pointsPlayer2) pointsPlayer1
        else pointsPlayer2
    }

    println(part1())
    println(part2())
}
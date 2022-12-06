fun main(){

    fun getPriorityValue(): MutableMap<Char,Int> {

        val mapPriority = mutableMapOf<Char,Int>()

        for (i in 'a'..'z'){
            mapPriority.put(i,26 - ('z'.code - i.code))
        }

        for (i in 'A'..'Z'){
            mapPriority.put(i,52 - ('Z'.code - i.code))
        }

        return mapPriority
    }

    fun part1(){
        val input = readInput("Day03")

        val elementRepeat = mutableListOf<Char>()

        val priorityValue = getPriorityValue()

        for (i in input){
            val value = i.chunked(i.count() / 2)

            val set1 = value[0].toSet()
            val set2 = value[1].toSet()

            for (j in set1) {
                if (set2.contains(j)) {
                    elementRepeat.add(j)
                    break
                }
            }
        }

        var sumValuePriority = 0
        for (i in elementRepeat){
            sumValuePriority += priorityValue[i]!!
        }
        println(sumValuePriority)
    }

    fun part2(){
        val input = readInput("Day03")

        val elementRepeat = mutableListOf<Char>()

        val priorityValue = getPriorityValue()

        val sizeInput = input.count()

        for (i in 2..sizeInput step 3) {

            val set1 = input[i-2].toSet()
            val set2 = input[i-1].toSet()
            val set3 = input[i-0].toSet()

            for (j in set1) {
                if (set2.contains(j)) {
                    if (set3.contains(j)) {
                        elementRepeat.add(j)
                        break
                    }
                }
            }
        }

        var sumValuePriority = 0
        for (i in elementRepeat){
            sumValuePriority += priorityValue[i]!!
        }
        println(sumValuePriority)
    }

    part1()
    part2()
}
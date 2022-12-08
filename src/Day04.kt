fun main(){

    fun part1(): Int{

        val list = mutableListOf<String>()

        var countRepeatWork = 0

        for (i in readInput("Day04")){

            for (j in i.split(",")){

                val v = j.split('-').map { it.toInt() }
                var rangeText = ""

                for (k in v[0].rangeTo(v[1]) ){
                    rangeText += " $k "
                }
                list.add(rangeText)
            }
        }

        for (i in 0 until list.size - 1 step 2){
            if (list[i] in list[i+1]  || list[i+1] in list[i]) {
                countRepeatWork++
            }
        }

        return countRepeatWork
    }

    fun part2(): Int{

        val listRange = mutableListOf<List<Int>>()

        var countRepeatWork = 0

        for (i in readInput("Day04")){
            for (j in i.split(",")){
                val v = j.split('-').map { it.toInt() }

                val listValue = mutableListOf<Int>()

                for (k in v[0].rangeTo(v[1]) ){
                    listValue.add(k)
                }
                listRange.add(listValue)
            }
        }

        for (i in 0 until listRange.size - 1 step 2){
            if (listRange[i].intersect(listRange[i+1].toSet()).isNotEmpty()){
                countRepeatWork++
            }
        }

        return countRepeatWork
    }

    println(part1())
    println(part2())
}
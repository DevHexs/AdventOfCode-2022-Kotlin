fun main() {

    val maxCaloriesPerElf = mutableListOf<Int>()

    fun part1(): Int{

        var calories = 0

        val input = readInput("Day01")
        for(i in input){
            if (i != "") {
                calories += i.toInt()
            }
            else{
                maxCaloriesPerElf.add(calories)
                calories = 0
            }
        }
        maxCaloriesPerElf.add(calories)
        return maxCaloriesPerElf.max()
    }

    fun part2(): Int{
        var topCalories = 0

        for (i in 1..3){
            val value = maxCaloriesPerElf.max()
            topCalories += value
            maxCaloriesPerElf.remove(value)
        }

        return topCalories
    }

    println(part1())
    println(part2())
}

import java.lang.Exception

fun main(){

    fun part1(): String {
        val stacks = mutableListOf<Stack>()

        val rows = mutableListOf<List<String>>()

        for (line in readInput("Day05")) {

            if(line.isEmpty()) break

            val value = mutableListOf<String>()

            for (i in 1..line.length step 4){
                value.add(line[i].toString())
            }
            rows.add(value)
        }

        for (i in rows.size - 1 downTo 0 ){

            val tempStack = Stack()

            for (j in rows.size - 1 downTo 0){
                try {
                    rows[j][i].let {
                        if (it.isNotBlank()) tempStack.push(it)
                    }
                }catch (e: Exception){
                    continue
                }
            }
            stacks.add(tempStack)
        }

        stacks.reverse()

        for (line in readInput("Day05")){
            if(line.startsWith("move")){
                val r = line.split(' ').also {
                    it.chunked(6)
                }

                val index = listOf(
                    r[1].toInt(),
                    r[3].toInt() - 1,
                    r[5].toInt() - 1)

                for(i in 0 until index[0]){
                    stacks[index[1]].pop()?.let { stacks[index[2]].push(it) }
                }
            }
        }

        var answer = ""
        for (i in stacks){
            answer += (i.peek().last())
        }

        return answer
    }

    fun part2(): String {

        val stacks = mutableListOf<Stack>()

        val rows = mutableListOf<List<String>>()

        for (line in readInput("Day05")) {

            if(line.isEmpty()) break

            val value = mutableListOf<String>()

            for (i in 1..line.length step 4){
                value.add(line[i].toString())
            }
            rows.add(value)
        }

        for (i in rows.size - 1 downTo 0 ){

            val tempStack = Stack()

            for (j in rows.size - 1 downTo 0){
                try {
                    rows[j][i].let {
                        if (it.isNotBlank()) tempStack.push(it)
                    }
                }catch (e: Exception){
                    continue
                }
            }
            stacks.add(tempStack)
        }

        stacks.reverse()

        for (line in readInput("Day05")){
            if(line.startsWith("move")){
                val r = line.split(' ').also {
                    it.chunked(6)
                }

                val index = listOf(
                    r[1].toInt() ,
                    r[3].toInt() - 1,
                    r[5].toInt() - 1)

                val listAux = mutableListOf<String>()

                for(i in 0 until index[0]){
                    stacks[index[1]].pop()?.let { listAux.add(it) }
                }

                for (i in listAux.reversed()){
                    stacks[index[2]].push(i)
                }
            }
        }

        var answer = ""
        for (i in stacks){
            answer += (i.peek().last())
        }

        return answer
    }
    println(part1())
    println(part2())
}

class Stack {
    private var value = mutableListOf<String>()

    fun pop(): String? {
        return if (value.isNotEmpty()) {
            value.removeAt(value.size - 1)
        } else {
            null
        }
    }

    fun push(i: String){
        value.add(i)
    }

    fun peek() = value

}
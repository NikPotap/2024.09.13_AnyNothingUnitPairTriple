fun main() {
// 1.
    println("1. Проверяем парные скобки.\n")
    val staples = "{[()]}"
    println("Имеется последовательность парных скобок: $staples.")
    val square = Pair('[', ']')
    val round = Pair('(', ')')
    val curly = Pair('{', '}')
    var equally = true
    for (i in 0..2) {
        val temp = Pair(staples.get(i), staples.get(5 - i))
        if (temp.equals(square) || temp.equals(round) || temp.equals(curly)) continue
        else {
            equally = false
            break
        }
    }
    println("Последовательность ${if (equally == false) "не" else ""}симметична относительно середины.")
// 2.
    println("\n2. Выполняем перестановку.\n")
    val array = intArrayOf(1, 2, 3, 4)
    println("Имеется последовательность: ${array.joinToString()}.")
    println(
        make(array.toMutableList(), mutableListOf(), mutableListOf())
            .joinToString("\n", "Варианты перестановок элементов списка:\n")
    )
}

fun make(
    arr: MutableList<Int>,
    memo: MutableList<Int>,
    results: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        var cur: MutableList<Int>
        repeat(arr.size) {
            cur = arr.slice(0..0).toMutableList()
            arr.removeFirst()
            if (arr.size == 0) {
                results.add((memo + cur).toMutableList())
            }
            make(arr, (memo + cur).toMutableList(), results)
            arr.add(cur[0])
        }
    return results
}
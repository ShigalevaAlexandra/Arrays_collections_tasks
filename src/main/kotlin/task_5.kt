// Создать приложение, в котором пользователь вводит массив из различных слов.
// На выходе приложение должно показать слова сгруппированные по признаку "состоят из одинаковых букв".
// Например, на входе ["eat", "tea", "tan", "ate", "nat", "bat"]. Получаем группы:
// "ate", "eat", "tea"
// "nat", "tan"
// "bat"

fun main() {
    println("Введите слова через пробел:")
    val stroka = readLine()
    val word = stroka?.split(" ")// разбиваем строку на отдельные слова, разделенные пробелами

    println("Сортировка слов по группам....")

    if (word != null) {
        val word_group = groupp(word)

        for ((_, group) in word_group) { //_ - пустое значение, т.к. используем только значение
            println(group.joinToString(", "))
        }
    }
}

fun groupp(words: List<String>): Map<String, List<String>> { //функция для сортировки слов по группам
    val word_group = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val key = word.toCharArray().sorted().joinToString("")

        if (!word_group.containsKey(key)) {
            word_group[key] = mutableListOf()
        }

        word_group[key]?.add(word)
    }
    return word_group
}
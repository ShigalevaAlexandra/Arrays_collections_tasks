val alphabets = ('а'..'я').toMutableList() //объявление глобальной переменной

fun main() {
    val variant = variant_work() //вызов функции выбора пользователем действия
    if(variant == 1){
        print("Введите ключевое слово:")
        val key = readln().lowercase() //привод букв к нижнему регистру

        print("Введите исходное слово:")
        val massege = readln().lowercase()
        val shifr_massege = shifr(key, massege)
        print("Зашифрованное сообщение: $shifr_massege")
    }
    else{
        print("Введите ключевое слово:")
        val key = readln().lowercase()

        print("Введите зашифрованное слово, которое хотите расшифровать:")
        val massege = readln().lowercase()
        val deshifr_massege = deshifr(key, massege)
        print("Зашифрованное сообщение: $deshifr_massege")
    }
}

fun variant_work(): Int {
    while(true){
        print("Для зашифровки сообщения введите 1, для дешифровки - 2" + "\n")
        val number = readln()
        if (number.toString() == "1" || number.toString() == "2")
            return number.toInt()
        else println("ERROR: такого варианта нет")
    }
}

fun shifr(key:String, text:String):String{
    val msg=text
    var result = ""
    var i = 0
    var j = 0
    alphabets += 'ё'
    while (j < msg.length) {
        result += alphabets[(alphabets.indexOf(msg[j]) + alphabets.indexOf(key[i])) % (alphabets.size)]
        j++
        i = (i + 1) % key.length
    }
    return result
}

fun deshifr(key:String, text:String):String{
    val msg=text
    var result = ""
    var i = 0
    var j = 0
    alphabets += 'ё'
    while (j < msg.length) {
        result += alphabets[(alphabets.indexOf(msg[j]) - alphabets.indexOf(key[i])+alphabets.size) % alphabets.size]
        j++
        i = (i + 1) % key.length
    }
    return result
}
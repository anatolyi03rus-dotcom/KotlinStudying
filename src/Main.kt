import kotlin.math.*
/**
 * Тривиальная (3 балла).
 *
 * Задача имеет повышенную стоимость как первая в списке.
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int {
    val x1 = hours * 60 * 60
    val x2 = minutes * 60
    val result = x1 + x2 + seconds
    return result
}
/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 * 1 аршин =
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double{

    val x1 = sagenes * 48 * 4.445
    val x2 = arshins * 16 * 4.445
    val x3 = vershoks * 4.445
    val result = (x1 + x2 + x3) / 100
    return result
}
/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает угол минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0в градусах, .63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double {
    val x1 = sec / 3600.0
    val x2 = min / 60.0
    val result = ((deg + x2 + x1) * 0.0174533)
    return result
}
/**
 * Тривиальная (1 балл)
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    val d = (x2 - x1).pow(2) + (y2 - y1).pow(2)
    return sqrt(d)
}
/**
 * Простая (2 балла)
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int {
    val x1 = (number / 100) % 10
    return x1
}

/**
 * Простая (2 балла)
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int {
    val x1 = hoursDepart * 60
    val x2 = minutesDepart + x1

    val x3 = hoursArrive * 60
    val x4 = minutesArrive + x3
    return(x4 - x2)

}
/**
 * Простая (2 балла)
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double {
    val x1 = (1 + percent / 100.0)
    val x2 = (((initial * x1) * x1) * x1)
    return x2
}
/**
 * Простая (2 балла)
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    val x1 = number % 10
    val x2 = (number / 10) % 10
    val x3 = (number / 100)
    return (x1 * 100 + x2 * 10 + x3)

}
fun discriminant (a : Int, b : Int, c : Int) = (b * b) - 4 * a * c

fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, $name!")
    println(seconds(8, 20, 35))
    println(lengthInMeters(8, 2, 11))
    println(angleInRadian(36,14,35))
    println(trackLength(3.0,0.0,0.0,4.0))
    println(thirdDigit(3801))
    println(travelMinutes(9,25,13,1))
    println(accountInThreeYears(100, 10))
    println(numberRevert(478))







}
import kotlin.math.*
import kotlin.rem


/**
 * Простая (2 балла)
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    if (age in 1..<200) {
        return when {
            age % 100 in 11..14 -> "$age лет"
            age % 10 == 1 -> "$age год"
            age % 10 in 2..4 -> "$age года"
            else -> "$age лет"
        }

    }
    else return "возраст вне диапазона"

}
/**
 * Простая (2 балла)
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double): Double  {
    val rasstoyanie1 = t1 * v1
    val rasstoyanie2 = t2 * v2
    val rasstoyanie3 = t3 * v3
    val vsevremya = t1 + t2 + t3
    val vserasstoyanie = t1 * v1 + t2 * v2 + t3 * v3
    val halfrasstoyanie = vserasstoyanie / 2

    if ( (halfrasstoyanie > rasstoyanie1) && (halfrasstoyanie <= rasstoyanie1 + rasstoyanie2) ) {

        val x1 = halfrasstoyanie - rasstoyanie1
        val halftime1 = x1 / v2 + t1
        return halftime1

    }
    else if ( (halfrasstoyanie <= rasstoyanie1) ) {
        val halftime2 = halfrasstoyanie / v1
        return halftime2
    }
    else if (halfrasstoyanie > rasstoyanie1 + rasstoyanie2) {
        val x2 = halfrasstoyanie - rasstoyanie1 - rasstoyanie2
        val halftime3 = x2 / v3 + t1 + t2
        return halftime3
    }
    else {return 0.0}

}

/**
 * Простая (2 балла)
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int {
    if ( (kingX != rookX1) && (kingX != rookX2) && (kingY != rookY1) && (kingY != rookY2))
    {
        return 0
    }
    else if ((kingX == rookX1 || kingY == rookY1) && (kingX != rookX2 && kingY != rookY2))
    {
        return 1
    }
    else if ((kingX == rookX2 || kingY == rookY2) && (kingX != rookX1 && kingY != rookY1))
    {
        return 2
    }
    else if ((kingX == rookX1 || kingY == rookY1) && (kingX == rookX2 || kingY == rookY2))
    {
        return 3
    }
    else {return 999}

}
/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int {

    if ( (kingX != rookX) && (kingY != rookY) && abs(kingX - bishopX) != abs(kingY - bishopY)   )
    {
        return 0
    }
    else if ((kingX == rookX || kingY == rookY) && abs(kingX - bishopX) != abs(kingY - bishopY) )
    {
        return 1
    }
    else if ((kingX != rookX && kingY != rookY) && abs(kingX - bishopX) == abs(kingY - bishopY) )
    {
        return 2
    }
    else if ((kingX == rookX || kingY == rookY) && (abs(kingX - bishopX) == abs(kingY - bishopY)) )
    {
        return 3
    }
    else {return 999}
}

fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, $name!")
    println(ageDescription(22))
    println(timeForHalfWay(1.0, 10.0, 2.0, 15.0,3.0,20.0))
    println(whichRookThreatens(4, 4, 1, 1, 8, 8))
    println(rookOrBishopThreatens(4, 4, 1, 4, 1, 1))




}
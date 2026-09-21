import kotlin.math.*


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
/**
 * Простая (2 балла)
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if ((a + b <= c) || (a + c <= b) || (b + c <= a))
    {
        return -1
    }
    val a1 = acos((b.pow(2) + c.pow(2) - a.pow(2)) / (2 * b * c))
    val b1 = acos((a.pow(2) + c.pow(2) - b.pow(2)) / (2 * a * c))
    val c1 = acos((a.pow(2) + b.pow(2) - c.pow(2)) / (2 * a * b))

    val a2 = a1 * 180 / Math.PI
    val b2 = b1 * 180 / Math.PI
    val c2 = c1 * 180 / Math.PI

    if (a2 < 90 && b2 < 90 && c2 < 90)
    {
        return 0
    }
    if (a2 == 90.0 || b2 == 90.0 || c2 == 90.0)
    {
        return 1
    }
    if ( (a2 > 90 && a2 < 180) || (b2 > 90 && b2 < 180) ||  (c2 > 90 && c2 < 180) )
    {
        return 2
    }
    return 999

}
/**
 * Средняя (3 балла)
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
        if (c <= b && d >= b) {
            if (b - c == 0)
            {
                return 0
            }
            else if (a >= c)
            {
                return b - a
            }
            else {
                return b - c
            }
        }
        else if (a <= d && b >= d)
        {
            if (d - a == 0)
            {
                return 0
            }
            else if (c >= a)
            {
                return d - c
            }

            else {
                return d - a
            }
        }
        else return - 1
}
/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val x1 = (number / 1000) % 10
    val x2 = (number / 100) % 10
    val x3 = (number / 10) % 10
    val x4 = number % 10

    if ((x1 + x2) == (x3 + x4))
    {
        return true
    }
    else return false

}
/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if (x1 == x2 || y1 == y2 || abs(x1 - x2) == abs(y1 - y2) )
    {
        return true
    }
    else return false

}
/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    when (month){
        1,3,5,7,8,10,12 -> return 31
        4,6,9,11 -> return 30
        2 -> if ((year % 4 == 0) && (year % 100 !=0) || (year % 400 == 0))
        {
            return 29
        }
            else return 28
    }
    return 0
}
/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun sqr(x: Double) = x * x
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    if (pointInsideCircle(x1,y1, x2, y2, r2)){
        val x1 = (sqr(x2-x1) + sqr(y2-y1)).pow(1/2)
        if (x1 < r2 - r1)
        {
            return true
        }
        else return false

    }
    return false

}
/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {

    if (a <= r && b <= s || a <= s && b <= r)
    { return true}
    if (a <= r && c <= s || a <= s && c <= r)
    { return true}
    if (b <= r && c <= s || b <= s && c <= r)
    { return true}
    return false
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
    println(triangleKind(3.0, 4.0, 5.0))
    println(segmentLength(0, 100, 25, 75))
    println(isNumberHappy(2846))
    println(queenThreatens(4,4,5,5))
    println(daysInMonth(9,2026))
    println(circleInside(x1 = 2.0, y1 = 2.0, r1 = 1.0, x2 = 2.0, y2 = 2.0, r2 = 4.0))
    println(brickPasses(1, 2, 3, 4, 5))
}


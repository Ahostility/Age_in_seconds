import java.time.LocalDate
//mport java.time.LocalDateTime
import java.time.LocalTime
//import java.time.Period


fun _date(): LocalDate{//Функция принимает данные о дате рождения //Ункция возвращает тип времени
    val year = readLine()!!.toInt()//Вводим год рождеия
    val month = readLine()!!.toInt()//Вводим месяц рождения
    val day = readLine()!!.toInt()//Вводим день рождения
    //val hour = readLine()!!.toInt()//Вводим час рождения
   // val minutes = readLine()!!.toInt()//Вводим минуты рождения
   // val seconds = readLine()!!.toInt()//Вводим секунды рождения
    val date = LocalDate.of(year,month, day)
    return date
}

fun standDate(born:LocalDate/*,time:LocalDateTime*/):Int{
    val newday = LocalDate.now()
    var lastyear = newday
    var i = 0
    var last: Int
    var dayinyear = newday.dayOfYear
    var sumday = dayinyear
    while(born.year != lastyear.year){
        i++
        last = lastyear.year - 1
        lastyear = LocalDate.of(last,12,31)
        dayinyear = lastyear.dayOfYear
        sumday = sumday + dayinyear
        println(i)
        println(lastyear.year)
    }
    sumday = sumday - born.dayOfYear
    return sumday
}

fun main() {
    val age = _date()//В переменную возраст записываетм дату рождения//
    val youdate = LocalDate.of(age.year, age.month, age.dayOfMonth)//Передаем функции год, месяц и дней в месяце
    println(age.dayOfYear)//дни с начала этого года
    val nowday = LocalTime.now()
    println("${nowday.hour},${nowday.minute},${nowday.second}")
    println(nowday)
    println(" it is sum days ${standDate(youdate)}, it is ${24*60*60*standDate(youdate)+nowday.hour*3600+nowday.minute*60+nowday.second} seconds")
    // val day2000 = LocalDate.of(2000, 12, 31)// Это пример обращения к объекту день, который хрнит дату
    //println("${day2000.year},${day2000.month},${day2000.dayOfMonth}")
//    var youborn = LocalDateTime.of(0,0,0,age.hour,age.minute,age.second)//эта штука выводит 0 год 0 месяц(если такой существует),0день
//    println(youdate)//время в минутах, секундах, и часах
}
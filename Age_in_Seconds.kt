import java.text.SimpleDateFormat
import java.time.LocalDate
//import toString
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

fun _date(): LocalDate{

    val year = readLine()!!.toInt()
    val month = readLine()!!.toInt()
    val day = readLine()!!.toInt()
   // val hour = readLine()!!.toInt()
   // val minutes = readLine()!!.toInt()
   // val seconds = readLine()!!.toInt()
    val date = LocalDate.of(year, month, day)
    return date
}


/*fun Date.toString(newformat: String, locale: Locale = Locale.getDefault()):String{
    val formatter = SimpleDateFormat(newformat,locale)
    return formatter.format(this)
}



fun getCurrentDateTime():Date{
    return Calendar.getInstance().time
}*/

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


    //var sumday = (newday.year - born.year)*born
   // val newdays = LocalDateTime.now()
    //val age = Period.between(born, newday)
    //return dayinyear
    return sumday
   // return age
}


fun main(){
    val age = _date()
    val youdate = LocalDate.of(age.year,age.month,age.dayOfMonth)
    val nowday = LocalTime.now()
    //println("${nowday.hour},${nowday.minute},${nowday.second}")
    //println(nowday)
    //var youborn = LocalDateTime.of(0,0,0,age.hour,age.minute,age.second)
    println(age.dayOfYear)
   // println(youdate)
   // val example = LocalDate.of(2000,12,31)
  //  println(example.year)
   println(" it is sum days ${standDate(youdate)}, it is ${24*60*60*standDate(youdate)+nowday.hour*3600+nowday.minute*60+nowday.second} seconds")
    //println(example.dayOfYear)
    //println("Us age is ${Age()}")
        /*var date1 = LocalDateTime.parse("2018-12-01")
    var date2 = LocalDate.parse("2017-11-02")
    println(date1)*/
    //val data = getCurrentDateTime()
    //val dataInString = data.toString("dd/MM/yyyy HH:mm:ss")
    //println(data)
    //println(dataInString)
}

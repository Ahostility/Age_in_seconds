import kotlin.math.abs
fun shifr_Vigenera(our_text:String,abc:Array<CharArray>,key:String):String{
    var shifrotext:String = ""
   // var arrlist = Array(26, {CharArray(26)})
    var newkey:String = ""
    var k = 0
    var n = 0
    for(i in 0..our_text.length){
        newkey+=key[i%key.length]
    }
    print("Us abc: ")
    println(abc[0])
    for(i in 0..abc.size-1){
        println(abc[i])
    }
    while(n != our_text.length) {
        for (ind in 0..abc[0].size - 1) {
            if (abc[ind][0] == our_text[k % newkey.length]) {
                for (str in 0..abc.size - 1) {
                    if (abc[0][str] == newkey[k % newkey.length]) {
                        shifrotext += abc[ind][str]
                    }
                }
            }
        }
        k++
        n++
    }
    return shifrotext
}

fun main(){
    val ABC = arrayListOf<Char>()//Create abc on ASCII
    val abclist = Array(26,{CharArray(26)})//Tabula Vigenera
    for(i in 65..90){
        ABC.add("$i".toByte().toChar())
    }
    println(ABC)
    for(i in 0..abclist.size - 1){
        for (j in 0..abclist.size - 1) {
            abclist[i][j] = ABC[(i + j) % ABC.size]
        }
    }
//    val our_text = readLine()!!.toString()
    val origin:String = "HELLOMYFRIEND"
    val our_key:String = "KEY"
    //RIJVSKIJPSILN
    println(shifr_Vigenera(origin,abclist,our_key))









//    for(i in 0..abclist.size-1){
//        for(j in 0..origin.length-1) {
//            if (abclist[1][i] == origin[j]) {
//                println("it's fact${abclist[1][i]}, ${origin[j]}, $j")
//            }
////            println("${abclist[1][i]}, ${origin[i]}")
//        }
//    }

//    println("${'a'.toByte().toInt()},${'z'.toByte().toInt()}")
//    println("122".toByte().toChar())
//    var middle = arrayListOf<Char>()
//    for(i in 0..abc.size-1){
//        for(j in 0..abc.size-1){
//            middle.add(abc[abs(i+j)%abc.size])
//        }
//           println(middle)
//        middle.clear()
//    }
//    for(i in 0..abclist.size-1){
//        for(j in 0..origin.length-1) {
//            if (abclist[1][i] == origin[j]) {
//                println("it's fact${abclist[1][i]}, ${origin[j]}, $j")
//            }
////            println("${abclist[1][i]}, ${origin[i]}")
//        }
//    }
}

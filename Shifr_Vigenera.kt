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
//    print("Us abc: ")
//    println(abc[0])
    for(i in 0..abc.size-1){
//        println(abc[i])
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
fun decoding_Vigener(shifr:String,abc:Array<CharArray>,key:String):String{
    var our_text:String = ""
    var newkey:String = ""
    var k = 0
    var n = 0
    for(i in 0..shifr.length){
        newkey+=key[i%key.length]
    }
//    print("Us abc: ")
//    println(abc[0])
    for(i in 0..abc.size-1) {
//        println(abc[i])
    }
    while(n != shifr.length) {
        for (ind in 0..abc[0].size - 1) {
            if (abc[0][ind] == newkey[k % newkey.length]) {
                for (str in 0..abc.size - 1) {
                    if (abc[str][ind] == shifr [k % shifr.length]) {
                        our_text += abc[str][0]
                    }
                }
            }
        }
        k++
        n++
    }
    return our_text
}
fun shifr_Boufora(our_text:String,abc:Array<CharArray>,key:String):String{
    var shifrotext:String = ""
    // var arrlist = Array(26, {CharArray(26)})
    var newkey:String = ""
    var k = 0
    var n = 0
    for(i in 0..our_text.length){
        newkey+=key[i%key.length]
    }
//    print("Us abc: ")
//    println(abc[0])
    for(i in 0..abc.size-1){
//        println(abc[i])
    }
    while(n != our_text.length) {
        for (ind in 0..abc[0].size - 1) {
            if (abc[0][ind] == our_text[k % our_text.length]) {
                for (str in 0..abc.size - 1) {
                    if (abc[str][ind] == newkey[k % newkey.length]) {
                        shifrotext += abc[str][0]}
                }
            }
        }
        k++
        n++
    }
    return shifrotext
}
fun decooding_Boufora(shifr:String,abc:Array<CharArray>,key:String):String{
    var our_text:String = ""
    var newkey:String = ""
    var k = 0
    var n = 0
    for(i in 0..shifr.length){
        newkey+=key[i%key.length]
    }
//    print("Us abc: ")
//    println(abc[0])
    for(i in 0..abc.size-1) {
//        println(abc[i])
    }
    while(n != shifr.length) {
        for (str in 0..abc[0].size - 1) {
            if (abc[str][0] == shifr[k % shifr.length]) {
                for (ind in 0..abc.size - 1) {
                    if (abc[str][ind] == newkey [k % newkey.length]) {
                        our_text += abc[0][ind]
                    }
                }
            }
        }
        k++
        n++
    }
    return our_text
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
    println("Shifr_Vigenera")
    println(shifr_Vigenera(origin,abclist,our_key))
    println(decoding_Vigener(shifr_Vigenera(origin,abclist,our_key),abclist,our_key))
    println("-----------------------------------------------------------------------")
    println("The Boufort cipher")
    println(shifr_Boufora(origin,abclist,our_key))
    println(decooding_Boufora(shifr_Boufora(origin,abclist,our_key),abclist,our_key))




    //Breacking Veginer
    val shifrotext = shifr_Vigenera(origin,abclist,our_key)
    val lenstring = shifrotext.length
    val lenkey = readLine()!!.toInt()
    val ic = 0.055
    println("${shifrotext}, $lenstring, $lenkey")
        //f[i]*(f[i]-1)










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

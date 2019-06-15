

fun index(abc:ArrayList<Char>, our_text:String){
    var count:Double = 0.0
    var countlist = arrayListOf<Double>()
    var indc:Double = 0.0
    for(i in 0..abc.size-1) {
        for(j in 0..our_text.length-1) {
            if(abc[i] == our_text[j]){
                count+=1.0
            }
        }
        countlist.add(count)
        count = 0.0
        println("${countlist[i]}, ${abc[i]}")
        indc+=countlist[i]*(countlist[i]-1)/(our_text.length*(our_text.length-1))//True 0.062 ~ 0.067
        //println(indc)
    }
    println(indc)
    println(5.0/2)
}
fun main(){
    val ind = 0.067
    val ABC = arrayListOf<Char>()
    for(i in 65..90){
        ABC.add("$i".toByte().toChar())
    }
    println(ABC)
    //[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
    val text = "BEINGYOURSLAVEWHATSHOULDIDOBUTTENDUPONTHEHOURSANDTIMESOFYOURDESIRE" +
            "IHAVENOPRECIOUSTIMEATALLTOSPENDNORSERVICESTODOTILLYOUR" +
            "EQUIRENORDAREICHIDETHEWORLDWITHOUTENDHOURWHILSTIMYSOVERE" +
            "IGNWATCHTHECLOCKFORYOUNORTHINKTHEBITTERNESSOFABSENCESOURWH" +
            "ENYOUHAVEBIDYOURSERVANTONCEADIEUNORDAREIQUESTIONWITHMYJEALOUS" +
            "THOUGHTWHEREYOUMAYBEORYOURAFFAIRSSUPPOSEBUTLIKEASADSLAVESTAYA" +
            "NDTHINKOFNOUGHTSAVEWHEREYOUAREHOWHAPPYYOUMAKETHOSESOT" +
            "RUEAFOOLISLOVETHATINYOURWILLTHOUGHYOUDOANYTHINGHETHINKSNOILL"

    println(text.length)
    index(ABC,text)
}
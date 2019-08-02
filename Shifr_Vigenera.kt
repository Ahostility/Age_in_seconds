import com.sun.source.tree.WhileLoopTree
import kotlin.math.abs

fun shifr_Vigenera(our_text:String,abc:Array<CharArray>,key:String):String {
    var shifrotext = ""
    var newkey = ""
    var k = 0
    var n = 0
    for(i in 0..our_text.length){
        newkey+=key[i%key.length]
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
    var our_text = ""
    var newkey = ""
    var k = 0
    var n = 0
    for(i in 0..shifr.length){
        newkey+=key[i%key.length]
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
    var shifrotext = ""
    // var arrlist = Array(26, {CharArray(26)})
    var newkey = ""
    var k = 0
    var n = 0
    for(i in 0..our_text.length){
        newkey+=key[i%key.length]
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
    var our_text = ""
    var newkey = ""
    var k = 0
    var n = 0
    for(i in 0..shifr.length){
        newkey+=key[i%key.length]
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

fun indE(abc:ArrayList<Char>,shifr:String):Double{//This is bent function for find index of E
    println("--------------------------")
    val listIndex = arrayListOf<Double>()
    var count = 0.0
    var indc = 0.0
    for (j in 0..shifr.length-1) {
        if ('E' == shifr[j]) {
            count += 1.0
        }
    }
    indc += count * (count - 1) / (shifr.length * (shifr.length - 1))//True 0.062 ~ 0.067
    println("E equaly: ")
    return indc
}

fun listik4(shifr:String,keylen:Int):Array<String>{
    val textPart = Array(keylen, {""})
    for (i in 0..keylen-1){
        for(j in i..shifr.length-1 step keylen) {
            textPart[i] = textPart[i].plus(shifr[j])
        }
//        println(textPart[i])//*
//        println(textPart[i].length)//*
//        println(textPart.size)//*
    }
    return textPart
}

fun index(abc:ArrayList<Char>,listpart:Array<String>):ArrayList<Double>{
    println("--------------------------")
    val listIndex = arrayListOf<Double>()
    var count = 0.0
    var indc = 0.0
    for(k in 0..listpart.size-1){
        for(i in 0..abc.size-1) {
//            print("${abc[i]} ")//Entering word and his equality
            for (j in 0..listpart[k].length - 1) {
                if (abc[i] == listpart[k][j]) {
                    count += 1.0
//                    println(listpart[k][j])
                }
            }
            indc += count * (count - 1) / (listpart[k].length * (listpart[k].length - 1))//True 0.062 ~ 0.067
            count = 0.0
        }
        listIndex.add(k,indc)
//        println(listIndex[k])
        indc = 0.0
    }
    println(listIndex)
    return listIndex
}

fun checkId(listind:ArrayList<Double>):String {//This is awry(bent) function is working
    var answer = "We may have found length our key ${listind.size}"
    var i = 0
    while(i < listind.size){
        if (listind[i] < 0.058 || listind[i] > 0.068){
            answer = "Error"
            i = listind.size-1
        }
        i++
    }
    println(i)
    return answer
}

fun findPartText(textpart:Array<String>,keyl:Int,abc:ArrayList<Char>):ArrayList<Char>{
    println("FindPartText")
    val maxequsym = arrayListOf<Char>()
    var entermax = 0
    var count = 0//number enter symbol
    var ind = 0//index max symbol in abc
    for(i in 0..textpart.size-1) {
        println(textpart[i])
        for (j in 0..abc.size-1){
            for(k in 0..textpart[i].length-1){
                if(abc[j] == textpart[i][k]){
                    count++
                }
            }
            if (count > entermax){
                entermax = count
                ind = j
            }
            count = 0
        }
        entermax = 0
        maxequsym.add(i,abc[ind])
    }
    println(maxequsym)
    return maxequsym
}

fun findKey(listsym:ArrayList<Char>,abc: ArrayList<Char>):String{
    println("FindKey")
    var ind:Int
    var foundKey = ""
    for(i in 0..listsym.size-1){
        for (j in 0..abc.size-1){
            if (listsym[i] == abc[j]){
                ind = (j-4)%26
                if(ind < 0){
                    ind = (ind+26)%26
                }
                print(abc[ind])
                foundKey+=abc[ind]
            }
        }
    }
    println()
    return foundKey
}

//[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
fun main(){
    val ABC = arrayListOf<Char>()//Create abc on ASCII
    val abclist = Array(26,{CharArray(26)})//Tabula Vigenera
    for(i in 65..90){
        ABC.add("$i".toByte().toChar())
    }
    print("Our abc is: ")
    println(ABC)
    for(i in 0..abclist.size - 1) {
        for (j in 0..abclist.size - 1) {
            abclist[i][j] = ABC[(i + j) % ABC.size]
        }
        println(abclist[i])
    }

//    val origin:String = "BEINGYOURSLAVEWHATSHOULDIDOBUTTENDUPONTHEHOURSANDTIMESOFYOURDESIRE" +
//            "IHAVENOPRECIOUSTIMEATALLTOSPENDNORSERVICESTODOTILLYOUR" +
//            "EQUIRENORDAREICHIDETHEWORLDWITHOUTENDHOURWHILSTIMYSOVERE" +
//            "IGNWATCHTHECLOCKFORYOUNORTHINKTHEBITTERNESSOFABSENCESOURWH" +
//            "ENYOUHAVEBIDYOURSERVANTONCEADIEUNORDAREIQUESTIONWITHMYJEALOUS" +
//            "THOUGHTWHEREYOUMAYBEORYOURAFFAIRSSUPPOSEBUTLIKEASADSLAVESTAYA" +
//            "NDTHINKOFNOUGHTSAVEWHEREYOUAREHOWHAPPYYOUMAKETHOSESOT" +
//            "RUEAFOOLISLOVETHATINYOURWILLTHOUGHYOUDOANYTHINGHETHINKSNOILL"+
//            "CANSTTHOUOCRUELSAYILOVETHEENOTWHENIAGAINSTMYSELFWITHTHEEPARTAKE" +
//            "DOINOTTHINKONTHEEWHENIFORGOTAMOFMYSELFALLTYRANTFORTHYSAKE" +
//            "WHOHATETHTHEETHATIDOCALLMYFRIENDONWHOMFROWNSTTHOUTHATIDOFAWNUPON" +
//            "NAYIFTHOULOURSTONMEDOINOTSPENREVENGEUPONMYSELFWITHPRESENTMOAN" +
//            "WHATMERITDOIINMYSELFRESPECTTHATISSOPROUDTHYSERVICETODESPISE" +
//            "WHENALLMYBESTDOTHWORSHIPTHYDEFECTCOMMANDEDBYTHEMOTIONOFTHINEEYES" +
//            "BUTLOVEHATEONFORNOWIKNOWTHYMINDTHOSETHATCANSEETHOULOVSTANDIAMBLIND"+
//            "MRHUNGERTONHERFATHERREALLYWASTHEMOSTTACTLESSPERSONUPONEARTHAFLUFFYFEATHERY" +
//            "UNTIDYCOCKATOOOFAMANPERFECTLYGOODNATUREDBUTABSOLUTELYCENTEREDUPONHISOWNSILLYSELF" +
//            "IFANYTHINGCOULDHAVEDRIVENMEFROMGLADYSITWOULDHAVEBEENTHETHOUGHTOFSUCHAFATHERINLAW" +
//            "IAMCONVINCEDTHATHEREALLYBELIEVEDINHISHEARTTHATICAMEROUNDTOTHECHESTNUTSTHREEDAYSAWEEK" +
//            "FORTHEPLEASUREOFHISCOMPANYANDVERYESPECIALLYTOHEARHISVIEWSUPONBIMETALLISMASUBJECTUPON" +
//            "WHICHHEWASBYWAYOFBEINGANAUTHORITY" +
//            "FORANHOURORMORETHATEVENINGILISTENEDTOHISMONOTONOUSCHIRRUPABOUTBADMONEYDRIVINGOUTGOOD" +
//            "THETOKENVALUEOFSILVERTHEDEPRECIATIONOFTHERUPEEANDTHETRUESTANDARDSOFEXCHANGE" +
//            "SUPPOSEHECRIEDWITHFEEBLEVIOLENCETHATALLTHEDEBTSINTHEWORLDWERECALLEDUP" +
//            "SIMULTANEOUSLYANDIMMEDIATEPAYMENTINSISTEDUPONWHATUNDEROURPRESENTCONDITIONSWOULDHAPPENTHEN" +
//            "IGAVETHESELFEVIDENTANSWERTHATISHOULDBEARUINEDMANUPONWHICHHEJUMPEDFROMHISCHAIR" +
//            "REPROVEDMEFORMYHABITUALLEVITYWHICHMADEITIMPOSSIBLEFORHIMTODISCUSSANYREASONABLESUBJECT" +
//            "INMYPRESENCEANDBOUNCEDOFFOUTOFTHEROOMTODRESSFORAMASONICMEETING" +
//            "ATLASTIWASALONEWITHGLADYSANDTHEMOMENTOFFATEHADCOMEALLTHATEVENINGIHADFELTLIKE" +
//            "THESOLDIERWHOAWAITSTHESIGNALWHICHWILLSENDHIMONAFORLORNHOPEHOPEOFVICTORYANDFEAR" +
//            "OFREPULSEALTERNATINGINHISMIND" +
//            "SHESATWITHTHATPROUDDELICATEPROFILEOFHERSOUTLINEDAGAINSTTHEREDCURTAINHOWBEAUTIFUL" +
//            "SHEWASANDYETHOWALOOFWEHADBEENFRIENDSQUITEGOODFRIENDSBUTNEVERCOULDIGET" +
//            "BEYONDTHESAMECOMRADESHIPWHICHIMIGHTHAVEESTABLISHEDWITHONEOFMYFELLOWREPORTERS" +
//            "UPONTHEGAZETTEPERFECTLYFRANKPERFECTLYKINDLYANDPERFECTLYUNSEXUALMYINSTINCTS" +
//            "AREALLAGAINSTAWOMANBEINGTOOFRANKANDATHEREASEWITHMEITISNOCOMPLIMENTTOA" +
//            "MANWHERETHEREALSEXFEELINGBEGINSTIMIDITYANDDISTRUSTAREITSCOMPANIONSHERITAGE" +
//            "FROMOLDWICKEDAYSWHENLOVEANDVIOLENCEWENTOFTENHANDINHANDTHEBENTHEADTHEAVERTED" +
//            "EYETHEFALTERINGVOICETHEWINCINGFIGURTHESEANDNOTTHEUNSHRINKINGGAZEANDFRANK" +
//            "REPLYARETHETRUESIGNALSOFPASSIONEVENINMYSHORTLIFEIHADLEARNEDASMUCHASTHATOR" +
//            "HADINHERITEDITINTHATRACEMEMORYWHICHWECALLINSTINCTGLADYSWASFULLOFEVERYWOMANLYQUALITYSOMEJUDGEDHERT" +
//            "OBECOLDANDHARDBUTSUCHATHOUGHTWASTREASONTHATDELICATELYBRONZEDSKINALMOSTORIENTALINITSCOLORING" +
//            "THATRAVENHAIRTHELARGELIQUIDEYESTHEFULLBUTEXQUISITELIPSALLTHESTIGMATAOFPASSIONWERETHEREBUT" +
//            "IWASSADLYCONSCIOUSTHATUPTONOWIHADNEVERFOUNDTHESECRETOFDRAWINGITFORTHHOWEVERCOMEWHATMIGHT" +
//            "ISHOULDHAVEDONEWITHSUSPENSEANDBRINGMATTERSTOAHEADTONIGHTSHECOULDBUTREFUSEMEANDBETTERBEA" +
//            "REPULSEDLOVERTHANANACCEPTEDBROTHER" +
//            "SOFARMYTHOUGHTSHADCARRIEDMEANDIWASABOUTTOBREAKTHELONGANDUNEASYSILENCEWHENTWOCRITICAL" +
//            "DARKEYESLOOKEDROUNDATMEANDTHEPROUDHEADWASSHAKENINSMILINGREPROOFIHAVEAPRESENTIMENTTHATYOU" +
//            "AREGOINGTOPROPOSENEDIDOWISHYOUWOULDNTFORTHINGSARESOMUCHNICERASTHEYARE" +
//            "IDREWMYCHAIRALITTLENEARERNOWHOWDIDYOUKNOWTHATIWASGOINGTOPROPOSEIASKEDINGENUINEWONDER" +
//            "DONTWOMENALWAYSKNOWDOYOUSUPPOSEANYWOMANINTHEWORLDWASEVERTAKENUNAWARESBUTOHNEDOUR" +
//            "FRIENDSHIPHASBEENSOGOODANDSOPLEASANTWHATAPITYTOSPOILITDONTYOUFEELHOWSPLENDIDITISTHATA" +
//            "YOUNGMANANDAYOUNGWOMANSHOULDBEABLETOTALKFACETOFACEASWEHAVETALKED" +
//            "IDONTKNOWGLADYSYOUSEEICANTALKFACETOFACEWITHWITHTHESTATIOMASTERICANTIMAGINEHOW" +
//            "THATOFFICIALCAMEINTOTHEMATTERBUTINHETROTTEDANDSETUSBOTHLAUGHINGTHATDOESNOTSATISFYMEIN" +
//            "THELEASTIWANTMYARMSROUNDYOUANDYOURHEADONMYBREASTANDOHGLADYSIWANT" +
//            "SHEHADSPRUNGFROMHERCHAIRASSHESAWSIGNSTHATIPROPOSEDTODEMONSTRATESOMEOFMYWANTSYOUVESPOILEDEVERYT" +
//            "HINGNEDSHESAIDITSALLSOBEAUTIFULANDNATURALUNTILTHISKINDOFTHINGCOMESINITISSUCHAPITYWHYCANTYOUCONTROLYOURSELF" +
//            "IDIDNTINVENTITIPLEADEDITSNATUREITSLOVE"+
//            "WELLPERHAPSIFBOTHLOVEITMAYBEDIFFERENTIHAVENEVERFELTIT" +
//            "BUTYOUMUSTYOUWITHYOURBEAUTYWITHYOURSOULOHGLADYSYOUWEREMADEFORLOVEYOUMUSTLOVE"
//    val origin:String ="SFDFGJHDGURHUGHURRHSMPOSMOVMDGBNDNFVLDHGIOJAPOFJVSONUIJSMPOFFMAJSVFASP"+
//            "VGEURHWUCGIRXIONUWHQOXHVCXMIFEGUERHTUWERNQXFWDKTBGEIJGEPRVCKADNLSNASVNDOFHASPFOH"+
//            "FGUVNHSEOUHQXWENRUOINEABSXHVVZXMCZBVASJFARWTNUWETHVMURTNBERJKDJCJSBDHVXAVZKBDWQZGQUGISCGDCFTWVTFCER"+
//            "ERCQWECRBIVWBRORYRNXOWUERWPEZNWYRURFWPEHEROTVTGLTGKNVDNFVSHDBCHSADDCBFBSUNCRFUIUHQAZUBDVSDGVGABSHBWCEVWT"+
//            "SCFUGYRGFYGZNQGWYGXYBSSSHADGWCEVCFYWVYEYFWCHRFEJVEJFVJFGBNUNRTUBTBRIHJTOYBMJYHPBTJTMNTOINMTLUBDLFVDFVVDFGL"+
//            "IEGFECRGIWHBEROGBVOWEIRGNOWEHRFUWEURFNSHVBCEBUHDFSVFLKSAHFWAHEOUFAUFHACSFURFUBFJTGKBKGUYFTWFDTQWFERQCFRWEEFWCIEH"+
//            "SRFBIWUGOQWUQGMSUBAHDFDFHGYFERYUFUWRIOGEOGJDKFVNZNVDFMBKNDJSHCDSAUFJCWEJRFEUVDKJFGHDURGOEHKJFVCVSBVIUSAIFGCADIGOA"+
//            "SFUIQWEYWEUYWGEFJFBHSVDFSCHCFBWYEUYWUFHUWRNWUFEIJGRTLHFNGBLCNBBKHFBSYFCYWGYFHRGNVFNJVSBDHVSYBSVDFUBUFWEODNFIVNENVWEO"+
//            "SHBHBWNUGBVAEFIWVFHIDNVJFBNKDBDDFKLVDFGHIJISJFINVJBJBDIGIJSJGRJDGIGSDLFGVSNPACWPXSDASJDAIHDASDHAUHWCBUHAUB"+
//            "URQUYQYWUERTVHBEHFFLAKLXCKSNJVBSHSCAWCEQYHUQEHQCWITUOQRVTUIHRUQXWUHFUGFUQWHVBHRUIQWHUFHBUIRGUFHWFHFGHFQW"+
//            "SHURTVRUOQWHUVHSJDHFVGFUQWHFOIHWUOFHERVHUEHRUIQHRUQWUOCQOWEICWIENRUQWBERUQWEYCQIWERWQYRQPFLJDFBNDKBVSGEFTWUEFYIUNJS"+
//            "GRFUHUGNJDWYRDJSKWERGJVUCIXOSLWEMRHGUVICOSPWELRTJGIVCOLSWNEGRTYUEQJWFCNXMSKEUVCHSNERJGIIFKRJTJGUVDENDUXSWKWDBS"+
//            "FWTYRUTIGKCJSBGWEYRFRFUHENRHGVUCIXKSWKAISUJEHRHFHUVFHJRNEJKWUSISKEWKFVISUJHUFVUDJWUGHAERFHBCXCMSDHERUFDCJHFU"
//    val our_key = "SHIFROTEXT"//If your want to use of key whose len is more 10 word, we are get error
    val origin = "HELLOMYFRIENDS"
    val our_key = "KEY"
//    val our_key = "HELLOMYWORLD" //More then 10 symbols 12
//    val origin:String = readLine()!!.toString()
//    val our_key: String = readLine()!!.toString()

    println("Shifr_Vigenera")
    println(shifr_Vigenera(origin,abclist,our_key))
    println(decoding_Vigener(shifr_Vigenera(origin,abclist,our_key),abclist,our_key))
    println("-----------------------------------------------------------------------")
    println("The Boufort cipher")
    println(shifr_Boufora(origin,abclist,our_key))
    println(decooding_Boufora(shifr_Boufora(origin,abclist,our_key),abclist,our_key))
    println("-----------------------------------------------------------------------")

    println("Breaking Vigener cipher")
    val shifrotext = shifr_Vigenera(origin,abclist,our_key)
    val lenkey:Int = readLine()!!.toInt()
//    val indEx = 0.014632810828280014
    println(indE(ABC,origin))//Search MaxIndex in origin text
    println("len our text ${origin.length}")
    print("Index C: ")
    listik4(shifrotext, lenkey)
    println(index(ABC,listik4(shifrotext,lenkey)))
    println("--------------------------------------------------------")

//    var i= 2
//    while(i<=lenkey){
//        println(checkId(index(ABC,listik4(shifrotext,i))))
//        i++
//    }
//    println("--------------------------------------------------------")

    println(checkId(index(ABC,listik4(shifrotext,lenkey))))
//    println(findPartText(listik4(shifrotext,lenkey),lenkey,ABC))
    println(findKey(findPartText(listik4(shifrotext,lenkey),lenkey,ABC),ABC))
}
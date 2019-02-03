package com.example.muammer.scientificcalculator

//import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.fathzer.soft.javaluator.DoubleEvaluator
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.math.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var shiftEnable=false

    class IslemDugum{
        var sayi1 : Double=0.0
        var islem : String=""
    }

    class Islemler {
        var islemler = arrayListOf<IslemDugum>()
    }
    private var parantezler = arrayListOf<Islemler>()
    private var parantezSayac=0


    private lateinit var optext: EditText /*lateinit ile nullable tanımlamaktan kurtulduk.*/
    private lateinit var histext: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* var baslangic = islemDugum()
         islemler.add(baslangic)*/
        //var optext : TextView = findViewById(R.id.operationText)
        optext= this.findViewById(R.id.operationText)
        histext=findViewById(R.id.historyText)

        val baslangic= Islemler()
        parantezler.add(baslangic)

        buttonShift.setOnClickListener(this)
        buttonFac.setOnClickListener(this)
        buttonTan.setOnClickListener(this)
        buttonCot.setOnClickListener(this)
        buttonNeg.setOnClickListener(this)
        buttonLog.setOnClickListener(this)
        buttonLn.setOnClickListener(this)
        buttonSin.setOnClickListener(this)
        buttonCos.setOnClickListener(this)
        buttonSec.setOnClickListener(this)
        button23Pow.setOnClickListener(this)
        button23Root.setOnClickListener(this)
        buttonPow.setOnClickListener(this)
        buttonDel.setOnClickListener(this)
        buttonClear.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonLeftBrack.setOnClickListener(this)
        buttonRightBrack.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        buttonDiv.setOnClickListener(this)
        buttonMul.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonPlus.setOnClickListener(this)
        button0.setOnClickListener(this)
        button00.setOnClickListener(this)
        buttonDot.setOnClickListener(this)
        buttonEquals.setOnClickListener(this)
    }




    override fun onClick(v: View) {
        val optext : TextView = findViewById(R.id.operationText)



        when(v.id){
            buttonEquals.id->{
                try {
                    if(optext.text.toString()!="0") {
                        val rslt=DoubleEvaluator().evaluate(optext.text.toString())
                        val newtext="${histext.text}\n${optext.text}=$rslt"
                        histext.text=newtext
                        optext.text=rslt.toString()
                    }

                }catch (e: Exception){
                    val newtext="Syntax Error\n"
                    histext.text=newtext
                    optext.text="0"
                }

            }
            button0.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){ // değer 0 ise ve son eleman notda değilse
                    optext.text=""
                    optext.text="0"
                }else {
                    val newtext = "${optext.text}0"
                    optext.text = newtext
                }
            }
            button1.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    optext.text="1"
                }else {
                    val newtext = "${optext.text}1"
                    optext.text = newtext
                }
            }
            button2.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    optext.text="2"
                }else {
                    val newtext = "${optext.text}2"
                    optext.text = newtext
                }
            }
            button3.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    optext.text="3"
                }else {
                    val newtext = "${optext.text}3"
                    optext.text = newtext
                }
            }
            button4.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    optext.text="4"
                }else {
                    val newtext = "${optext.text}4"
                    optext.text = newtext
                }
            }
            button5.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    optext.text="5"
                }else {
                    val newtext = "${optext.text}5"
                    optext.text = newtext
                }
            }
            button6.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    optext.text="6"
                }else {
                    val newtext = "${optext.text}6"
                    optext.text = newtext
                }
            }
            button7.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    optext.text="7"
                }else {
                    val newtext = "${optext.text}7"
                    optext.text = newtext
                }
            }
            button8.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    optext.text="8"
                }else {
                    val newtext = "${optext.text}8"
                    optext.text = newtext
                }
            }
            button9.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    optext.text="9"
                }else {
                    val newtext = "${optext.text}9"
                    optext.text = newtext
                }
            }
            button00.id->{
                if (optext.text.toString()=="0" && !optext.text.toString().contains('.')){
                    optext.text=""
                    val newtext = "00"
                    optext.text = newtext
                }else {
                    val newtext = "${optext.text}00"
                    optext.text = newtext
                }
            }
            buttonDot.id->{

                    val newtext = "${optext.text}."
                    optext.text = newtext

            }
            buttonShift.id->{
                if(shiftText.text=="off"){
                    shiftEnable=true
                    buttonShift.setBackgroundResource(R.drawable.red_button_clicked_bg)
                    val newtext="on"
                    shiftText.text=newtext
                }else if(shiftText.text=="on"){
                    shiftEnable=false
                    buttonShift.setBackgroundResource(R.drawable.red_button_bg)
                    val newtext="off"
                    shiftText.text=newtext
                }
            }
            buttonClear.id->{
                if(shiftText.text=="off"){
                    if(histext.text=="NaN\n"){  // nan yazıyorsa history texti de temizler
                        historyText.text="\n"
                    }
                    optext.text="0"
                }else{
                    optext.text="0"
                    historyText.text="\n"
                    parantezler.removeAll(parantezler)
                    parantezSayac=0
                    val baslangic= Islemler()
                    parantezler.add(baslangic)
                }
            }
            buttonDel.id->{
                if(optext.text.length>1 && optext.text.toString()!="0") {
                    optext.text = optext.text.substring(0, optext.text.length - 1)
                }else if(optext.text.length==1) {       //son sayı ise 0 yapılıyor
                    optext.text="0"
                }
            }
            buttonMinus.id->{

                if (optext.text.toString()=="0" || optext.text.toString()==""){
                    optext.text=""
                    optext.text="0-"
                }else {
                    val newtext = "${optext.text}-"
                    optext.text = newtext
                }
            }
            buttonPlus.id->{

                if (optext.text.toString()=="0" || optext.text.toString()==""){
                    optext.text=""
                    optext.text="0+"
                }else {
                    val newtext = "${optext.text}+"
                    optext.text = newtext
                }
            }
            buttonMul.id->{
                if (optext.text.toString()=="0" || optext.text.toString()==""){
                    optext.text=""
                    optext.text="0*"
                }else {
                    val newtext = "${optext.text}*"
                    optext.text = newtext
                }
            }
            buttonDiv.id->{

                if (optext.text.toString()=="0" || optext.text.toString()==""){
                    optext.text=""
                    optext.text="0/"
                }else {
                    val newtext = "${optext.text}/"
                    optext.text = newtext
                }
            }
            buttonLeftBrack.id->{
                if (optext.text.toString()=="0" || optext.text.toString()==""){
                    optext.text=""
                    optext.text="("
                }else {
                    val newtext = "${optext.text}("
                    optext.text = newtext
                }
            }
            buttonRightBrack.id->{
                if (optext.text.toString()=="0" || optext.text.toString()==""){
                    optext.text=""
                    optext.text=")"
                }else {
                    val newtext = "${optext.text})"
                    optext.text = newtext
                }
            }
            buttonFac.id->{
                try {
                    if(shiftText.text=="off"){
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            optext.text="0^(-1)"
                        }else {
                            val newtext = "${optext.text}^(-1)"
                            optext.text = newtext
                        }
                    }else{
                        when {
                            optext.text.toString().toInt()==0 -> // 0!
                                optext.text="1"
                            optext.text.toString().toInt()>0 -> {     // >0
                                var sonuc = 1.0
                                for (i in 1..optext.text.toString().toInt()){
                                    sonuc *= i
                                }
                                optext.text=sonuc.toString()
                            }
                            else -> optext.text="0"
                        }

                    }


                }catch (e: Exception){
                    val newtext="Syntax Error\n"
                    histext.text=newtext
                    optext.text="0"
                }


            }
            buttonTan.id->{
                try {
                    if(shiftText.text=="off"){
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="tan("
                            optext.text=newtext
                        }else {
                            val newtext = "${optext.text}tan("
                            optext.text = newtext
                        }
                    }else{
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="atan("
                            optext.text=newtext
                        }else {
                            val newtext = "${optext.text}atan("
                            optext.text = newtext
                        }
                    }
                    infNonCheck()
                } catch (e:Exception){
                    parantezler.removeAll(parantezler)
                    parantezSayac=0

                    val baslangic= Islemler()
                    parantezler.add(baslangic)
                    val newtext ="NaN\n"
                    historyText.text=newtext
                }
            }
            buttonCot.id->{
                try {
                    if(shiftText.text=="off"){
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="cot("
                            optext.text=newtext
                        }else {
                            val newtext = "${optext.text}cot("
                            optext.text = newtext
                        }
                    }else{
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="acot("
                            optext.text=newtext
                        }else {
                            val newtext = "${optext.text}acot("
                            optext.text = newtext
                        }
                        //historyText.text="${historyText.text}arccot${optext.text}"
                    }
                    infNonCheck()
                } catch (e:Exception){
                    parantezler.removeAll(parantezler)
                    parantezSayac=0

                    val baslangic= Islemler()
                    parantezler.add(baslangic)
                    val newtext ="NaN\n"
                    historyText.text=newtext
                }
            }
            buttonNeg.id->{
                optext.text="${optext.text.toString().toDouble()*-1}"
            }
            buttonLog.id->{
                if(shiftText.text=="off"){
                    if (optext.text.toString()=="0" || optext.text.toString()==""){
                        optext.text=""
                        val newtext ="log("
                        optext.text= newtext
                    }else {
                        val newtext = "${optext.text}log("
                        optext.text = newtext
                    }
                }else{
                    if (optext.text.toString()=="0" || optext.text.toString()==""){
                        optext.text=""
                        val newtext ="10^("
                        optext.text=newtext
                    }else {
                        val newtext = "${optext.text}10^("
                        optext.text = newtext
                    }
                }
                infNonCheck()
            }
            buttonLn.id->{
                if(shiftText.text=="off"){
                    if (optext.text.toString()=="0" || optext.text.toString()==""){
                        optext.text=""
                        val newtext ="ln("
                        optext.text=newtext
                    }else {
                        val newtext = "${optext.text}ln("
                        optext.text = newtext
                    }
                }else{
                    if (optext.text.toString()=="0" || optext.text.toString()==""){
                        optext.text=""
                        optext.text="e"
                    }else {
                        val newtext = "${optext.text}e"
                        optext.text = newtext
                    }
                }
                infNonCheck()
            }
            buttonSin.id->{

                try {
                    if(shiftText.text=="off"){

                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="sin("
                            optext.text=newtext
                        }else {
                            val newtext = "${optext.text}sin("
                            optext.text = newtext
                        }

                    }else{
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="asin("
                            optext.text=newtext

                        }else {
                            val newtext = "${optext.text}asin("
                            optext.text = newtext
                        }
                    }
                    infNonCheck()
                } catch (e:Exception){
                    parantezler.removeAll(parantezler)
                    parantezSayac=0

                    val baslangic= Islemler()
                    parantezler.add(baslangic)
                    val newtext ="NaN\n"
                    historyText.text=newtext
                }

            }
            buttonCos.id->{
                try {
                    if(shiftText.text=="off"){
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="cos("
                            optext.text=newtext
                        }else {
                            val newtext = "${optext.text}cos("
                            optext.text = newtext
                        }
                    }else{
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="acos("
                            optext.text=newtext
                        }else {
                            val newtext = "${optext.text}acos("
                            optext.text = newtext
                        }
                    }
                    infNonCheck()
                } catch (e:Exception){
                    parantezler.removeAll(parantezler)
                    parantezSayac=0

                    val baslangic= Islemler()
                    parantezler.add(baslangic)
                    val newtext ="NaN\n"
                    historyText.text=newtext
                }


            }
            buttonSec.id->{

                try {
                    if(shiftText.text=="off"){
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="sinh("
                            optext.text=newtext
                        }else {
                            val newtext = "${optext.text}sinh("
                            optext.text = newtext
                        }
                    }else{
                        if (optext.text.toString()=="0" || optext.text.toString()==""){
                            optext.text=""
                            val newtext ="cosh("
                            optext.text=newtext
                        }else {
                            val newtext = "${optext.text}cosh("
                            optext.text = newtext
                        }
                    }
                    infNonCheck()
                } catch (e:Exception){
                    parantezler.removeAll(parantezler)
                    parantezSayac=0

                    val baslangic= Islemler()
                    parantezler.add(baslangic)
                    val newtext ="NaN\n"
                    historyText.text=newtext
                }
            }
            button23Pow.id->{
                if(shiftText.text=="off"){
                    if (optext.text.toString()=="0" || optext.text.toString()==""){
                        optext.text=""
                        optext.text="^2"
                    }else {
                        val newtext = "${optext.text}^2"
                        optext.text = newtext
                    }
                }else{
                    if (optext.text.toString()=="0" || optext.text.toString()==""){
                        optext.text=""
                        optext.text="^3"
                    }else {
                        val newtext = "${optext.text}^3"
                        optext.text = newtext
                    }
                }
                infNonCheck()
            }
            button23Root.id->{
                try{
                    if(shiftText.text=="off"){
                        optext.text=nthRoot(optext.text.toString().toDouble(),2).toString()

                        //historyText.text="${historyText.text}(√${optext.text})"    //edittext'i textview'e taşıyoruz

                    }else{
                        optext.text=nthRoot(optext.text.toString().toDouble(),3).toString()

                        //historyText.text="${historyText.text}(3√${optext.text})"    //edittext'i textview'e taşıyoruz
                    }
                    infNonCheck()
                }catch (e:Exception){
                    val newtext="Syntax Error\n"
                    histext.text=newtext
                    optext.text="0"
                }

            }
            buttonPow.id->{
                if (optext.text.toString()=="0" || optext.text.toString()==""){
                    optext.text=""
                    optext.text="0^"
                }else {
                    val newtext = "${optext.text}^"
                    optext.text = newtext
                }
            }
        }
    }


    /*private fun islemEkle(yeniSayi:Double, yeniIslem:String) : Double{


        if(parantezler[parantezSayac].islemler.size!=0){ // en az bir ekleme yapılmışsa

            when(parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].islem){ // mevcut parantez içinin son ekli işlemi

                "mul"->{
                    parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].sayi1=parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].sayi1*yeniSayi
                    parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].islem=yeniIslem
                }
                "div"->{
                    parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].sayi1=parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].sayi1/yeniSayi
                    parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].islem=yeniIslem
                }
                "plus"->{
                    val yeniDugum=IslemDugum()
                    yeniDugum.sayi1=yeniSayi
                    yeniDugum.islem=yeniIslem
                    parantezler[parantezSayac].islemler.add(yeniDugum)
                }
                "minus"->{
                    val yeniDugum=IslemDugum()
                    yeniDugum.sayi1=yeniSayi
                    yeniDugum.islem=yeniIslem
                    parantezler[parantezSayac].islemler.add(yeniDugum)
                }
                ""->{               // parantezcoz tarafından kullanılır, son sayı kontrolü için
                    val yeniDugum=IslemDugum()
                    yeniDugum.sayi1=yeniSayi
                    yeniDugum.islem=yeniIslem
                    parantezler[parantezSayac].islemler.add(yeniDugum)
                }

                "^"->{
                    parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].sayi1=parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].sayi1.pow(yeniSayi)
                    parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].islem=yeniIslem
                }
                "√"->{
                    parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].sayi1=nthRoot(yeniSayi,parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].sayi1.toInt())

                    try {       // Hatalı kök işleminden sonra olmayan indekslere eriştiğinde hata verebiliyor
                        parantezler[parantezSayac].islemler[parantezler[parantezSayac].islemler.lastIndex].islem=yeniIslem
                    } catch (e:Exception){
                        parantezler.removeAll(parantezler)
                        parantezSayac=0

                        val baslangic= Islemler()
                        parantezler.add(baslangic)

                        val newtext="NaN \n"
                        historyText.text = newtext
                    }


                }

            }

        }else{          // ilk eklemeyse
            val yeniDugum=IslemDugum()
            yeniDugum.sayi1=yeniSayi
            yeniDugum.islem=yeniIslem
            parantezler[parantezSayac].islemler.add(yeniDugum)
        }

        return 0.0
    }
*/
    /*private fun parantezCoz(yapilacak : String):Double{
        if (yapilacak==")"){    // parantez içi çözülecekse
            val sonSayi=operationText.text.toString().toDouble()
            islemEkle(sonSayi,"")
            val sayi = parantezler[parantezSayac].islemler.size-1
            for (i in 0..sayi){
                when(parantezler[parantezSayac].islemler[i].islem){
                    "plus"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1 + parantezler[parantezSayac].islemler[i+1].sayi1

                    }
                    "minus"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1 - parantezler[parantezSayac].islemler[i+1].sayi1

                    }
                    "mul"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1 * parantezler[parantezSayac].islemler[i+1].sayi1
                    }
                    "div"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1 / parantezler[parantezSayac].islemler[i+1].sayi1
                    }
                    "^"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1.pow(parantezler[parantezSayac].islemler[i+1].sayi1)
                    }
                    "√"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 =nthRoot(parantezler[parantezSayac].islemler[i+1].sayi1,parantezler[parantezSayac].islemler[i].sayi1.toInt())
                    }
                    ""->{
                        return parantezler[parantezSayac].islemler[i].sayi1
                    }
                }
            }
        }else{      // sonuç bulunacaksa(eşittire basılınca)


            islemEkle(yapilacak.toDouble(),"")

            val sayi = parantezler[parantezSayac].islemler.size-1
            for (i in 0..sayi){
                when(parantezler[parantezSayac].islemler[i].islem){
                    "plus"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1 + parantezler[parantezSayac].islemler[i+1].sayi1

                    }
                    "minus"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1 - parantezler[parantezSayac].islemler[i+1].sayi1

                    }
                    "mul"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1 * parantezler[parantezSayac].islemler[i+1].sayi1
                    }
                    "div"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1 / parantezler[parantezSayac].islemler[i+1].sayi1
                    }
                    "^"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 = parantezler[parantezSayac].islemler[i].sayi1.pow(parantezler[parantezSayac].islemler[i+1].sayi1)
                    }
                    "√"->{
                        parantezler[parantezSayac].islemler[i+1].sayi1 =nthRoot(parantezler[parantezSayac].islemler[i+1].sayi1,parantezler[parantezSayac].islemler[i].sayi1.toInt())
                    }
                    ""->{
                        return parantezler[parantezSayac].islemler[i].sayi1
                    }
                }
            }

        }
        return 0.0
    }*/

    private fun nthRoot(x: Double, n: Int): Double {
        if( x>=0 && n>=2){      // hata vememesi için kontrol yapılıyor
            if(x==0.0){
                return 0.0
            }
            val np = n - 1
            fun iter(g: Double) = (np * g + x / Math.pow(g, np.toDouble())) / n
            var g1 = x
            var g2 = iter(g1)
            while (g1 != g2) {
                g1 = iter(g1)
                g2 = iter(iter(g2))
            }
            return g1
        }else {     // hatalı girdide gereken işlemler
            parantezler.removeAll(parantezler)
            parantezSayac=0

            val baslangic= Islemler()
            parantezler.add(baslangic)
            val newtext="NaN \n"
            historyText.text =newtext
            return 0.0
        }

    }
    //@SuppressLint("SetTextI18n")
    private fun infNonCheck(){ // optextte nan veya infinity yazarsa, histtexte taşır
        val optext : TextView = findViewById(R.id.operationText)
        when(operationText.text.toString()){
            "Infinity"->{
                val newtext="${optext.text}\n"
                historyText.text = newtext
                optext.text ="0"
            }
            "NaN"->{
                val newtext="${optext.text}\n"
                historyText.text = newtext
                optext.text ="0"
            }
            "-Infinity"->{
                val newtext="${optext.text}\n"
                historyText.text = newtext
                optext.text ="0"
            }
        }
    }

   /* private fun takeSin(angle : Double) : Double{
        return if (angle.rem(180)==0.0 && (angle/90).rem(2.0)==0.0){   // doksana bölümü çift sayı olan 180in katlarındaki hatalı çözüm için(180 360 vs)
            0.0
        }else{
            sin(angle*Math.PI/180)
        }
    }

    private fun takeCos(angle : Double) : Double{
        return if (angle.rem(180)!=0.0 && angle.rem(90)==0.0){   // 180e tam bölünmeyen 90a tam bölünen sayılar(90 270)
            0.0
        }else{
            cos(angle*Math.PI/180)
        }
    }

    private fun rollAngle(angle:Double):String{     // açılarda virgülden sonraki sayıları 10 adet olarak yuvarlar
        val angstr=angle.toString()
        val angdotcut=angstr.split('.')
        return if (angdotcut[1].length>=10){        // noktadan sonraki 10 karakter ele alınacak
            val dotright10=angdotcut[1].substring(0,10)
            angdotcut[1].substring(10,angdotcut[1].lastIndex) // 10. sayıdan sonrası
            if(dotright10[9].toString().toInt()>=5){  // noktadan sonraki 10. sayı >=5 ise
                var res = (angdotcut[0]+"."+dotright10.substring(0,9)).toDouble()
                res += 0.000000001
                res.toString()
            } else{
                "${angdotcut[0]}.${dotright10.substring(0,9)}"
            }
        }else{
            angle.toString()
        }

    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menuScientific->{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            R.id.menuUnit->{
                val intent = Intent(this,UnitActivity::class.java)
                startActivity(intent)
            }



        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        val histext = historyText.text

        outState?.putCharSequence("savedText", histext)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val userText = savedInstanceState?.getString("savedText")
        val newtext="$userText\n"
        histext.text = newtext

    }
}

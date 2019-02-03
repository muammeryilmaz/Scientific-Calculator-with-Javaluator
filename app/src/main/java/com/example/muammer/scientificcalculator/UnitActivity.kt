package com.example.muammer.scientificcalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_unit.*
import java.lang.Exception

class UnitActivity : AppCompatActivity() , View.OnClickListener{


    lateinit var spinner : Spinner
    lateinit var countText : EditText
    var currentUnit="length"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit)

        val actionBar = supportActionBar
        actionBar!!.title="Unit Converter"              // action bar set edildi

        spinner= this.findViewById(R.id.spinner)
        countText = this.findViewById(R.id.count)

        lengthButton.setOnClickListener (this)
        areaButton.setOnClickListener(this)
        massButton.setOnClickListener(this)
        temparatureButton.setOnClickListener(this)
        speedButton.setOnClickListener(this)
        volumeButton.setOnClickListener(this)
        solveButton.setOnClickListener(this)

        /////   Başlangıç
        loadSpinnerItems(currentUnit)          // başlangıçta spinnere length veriliyor
        textView21.text = getString(R.string.millimeter) //
        textView22.text=getString(R.string.centimeter)
        textView23.text=getString(R.string.decimeter)
        textView24.text=getString(R.string.meter)
        textView25.text=getString(R.string.kilometer)   // sağ textviewler de length e göre yazılıyor
        textView26.text=getString(R.string.inch)
        textView27.text=getString(R.string.foot)
        textView28.text=getString(R.string.yard)
        textView29.text=getString(R.string.mile)    //
        /////////////////////////////////////////////////////////
        spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{  // spinnerdeki textlere tıklanınca yapılacaklar eklenebilir
            override fun onNothingSelected(parent: AdapterView<*>?) {
                loadSpinnerItems(currentUnit)
                writeResults(countText.text.toString().toDouble(),spinner.selectedItem.toString())

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (countText.text.toString()==""){
                    writeResults(1.0,parent?.getItemAtPosition(position).toString())
                }else{
                writeResults(countText.text.toString().toDouble(),parent?.getItemAtPosition(position).toString())
                }
            }
        }
    }

    override fun onClick(v: View) {
        if(countText.text.toString()==""){
            countText.setText("1.0")
        }
        when(v.id){


            solveButton.id->{
                writeResults(countText.text.toString().toDouble(),spinner.selectedItem.toString())
            }

            lengthButton.id->{
                currentUnit="length"
                loadSpinnerItems("length")              // spinner nesneleri atanıyor
                writeResults(countText.text.toString().toDouble(),spinner.selectedItem.toString())

                textView21.text = getString(R.string.millimeter) //
                textView22.text=getString(R.string.centimeter)
                textView23.text=getString(R.string.decimeter)
                textView24.text=getString(R.string.meter)
                textView25.text=getString(R.string.kilometer)   // sağ textviewler
                textView26.text=getString(R.string.inch)
                textView27.text=getString(R.string.foot)
                textView28.text=getString(R.string.yard)
                textView29.text=getString(R.string.mile)    //

            }
            areaButton.id->{
                currentUnit="area"
                loadSpinnerItems("area")
                writeResults(countText.text.toString().toDouble(),spinner.selectedItem.toString())

                textView21.text = getString(R.string.millimeter2) //
                textView22.text=getString(R.string.centimeter2)
                textView23.text=getString(R.string.meter2)
                textView24.text=getString(R.string.hectare)
                textView25.text=getString(R.string.kilometer2)   // sağ textviewler
                textView26.text=getString(R.string.foot2)
                textView27.text=getString(R.string.yard2)
                textView28.text=getString(R.string.acre)
                textView29.text=""    //
            }
            massButton.id->{
                currentUnit="mass"
                loadSpinnerItems("mass")
                writeResults(countText.text.toString().toDouble(),spinner.selectedItem.toString())

                textView21.text = getString(R.string.milligram) //
                textView22.text=getString(R.string.gram)
                textView23.text=getString(R.string.kilogram)
                textView24.text=getString(R.string.tonne)
                textView25.text=getString(R.string.ons)   // sağ textviewler
                textView26.text=getString(R.string.libre)
                textView27.text=""
                textView28.text=""
                textView29.text=""      //
            }
            temparatureButton.id->{
                currentUnit="temperature"
                loadSpinnerItems("temperature")
                writeResults(countText.text.toString().toDouble(),spinner.selectedItem.toString())

                textView21.text = getString(R.string.kelvin) //
                textView22.text=getString(R.string.celsius)
                textView23.text=getString(R.string.fahrenheit)
                textView24.text=""
                textView25.text=""                          // sağ textviewler
                textView26.text=""
                textView27.text=""
                textView28.text=""
                textView29.text=""                          //
            }
            speedButton.id->{
                currentUnit="speed"
                loadSpinnerItems("speed")
                writeResults(countText.text.toString().toDouble(),spinner.selectedItem.toString())

                textView21.text = getString(R.string.msn) //
                textView22.text=getString(R.string.kmh)
                textView23.text=getString(R.string.ftsn)
                textView24.text=getString(R.string.mih)
                textView25.text=""                       // sağ textviewler
                textView26.text=""
                textView27.text=""
                textView28.text=""
                textView29.text=""                        //


            }
            volumeButton.id->{
                currentUnit="volume"
                loadSpinnerItems("volume")
                writeResults(countText.text.toString().toDouble(),spinner.selectedItem.toString())

                textView21.text = getString(R.string.milliliter) //
                textView22.text=getString(R.string.liter)
                textView23.text=getString(R.string.meter3)
                textView24.text=getString(R.string.inch3)   // sağ textviewler
                textView25.text=getString(R.string.foot3)
                textView26.text=getString(R.string.yard3)
                textView27.text=getString(R.string.galliq)
                textView28.text=getString(R.string.galdry)    //
                textView29.text=""
            }
        }
    }

    private fun loadSpinnerItems(type:String){
        when(type){
            "length"->{
                spinner.adapter = ArrayAdapter<String>(this,R.layout.big_font_spinner,resources.getStringArray(R.array.lengthspin))

            }
            "area"->{
                spinner.adapter = ArrayAdapter<String>(this,R.layout.big_font_spinner,resources.getStringArray(R.array.areaspin))

            }
            "mass"->{
                spinner.adapter = ArrayAdapter<String>(this,R.layout.big_font_spinner,resources.getStringArray(R.array.massspin))

            }
            "volume"->{
                spinner.adapter = ArrayAdapter<String>(this,R.layout.big_font_spinner,resources.getStringArray(R.array.volumespin))

            }
            "temperature"->{
                spinner.adapter = ArrayAdapter<String>(this,R.layout.big_font_spinner,resources.getStringArray(R.array.temperaturespin))

            }
            "speed"->{
                spinner.adapter = ArrayAdapter<String>(this,R.layout.big_font_spinner,resources.getStringArray(R.array.speedspin))

            }

        }
    }

    fun writeResults(count:Double,typ:String){
        try {
            when(currentUnit){
                "length"->{

                    var mm=0.0
                    when(typ){                  // gelen sayı milimetre cinsinsen bulunur
                        "mm"->{
                            mm=(1/1.0)*count
                        }
                        "cm"->{
                            mm=(1/0.1)*count
                        }
                        "dm"->{
                            mm=(1/0.01)*count
                        }
                        "m"->{
                            mm=(1/0.001)*count
                        }
                        "km"->{
                            mm=(1/0.000001)*count
                        }
                        "in"->{
                            mm=(1/0.03937007874016)*count
                        }
                        "ft"->{
                            mm=(1/0.00328083989501)*count
                        }
                        "yd"->{
                            mm=(1/0.00109361329834)*count
                        }
                        "mi"->{
                            mm=(1/((6.213711922373)*(0.0000001)))*count
                        }
                    }
                    textView11.text=roll(mm/1.0)         // textler milimetre katsayılarına göre çarpılıp görüntülenir
                    textView12.text=roll(mm/10.0)
                    textView13.text=roll(mm/100.0)
                    textView14.text=roll(mm/1000.0)
                    textView15.text=roll((mm/1000000.0))
                    textView16.text=roll(mm/25.4)
                    textView17.text=roll(mm/304.8)
                    textView18.text=roll(mm/914.4)
                    textView19.text=roll(mm/1609344)

                }
                "area"->{
                    var m2  = 0.0
                    when(typ) {
                        "mm^2" -> {
                            m2 = (1 / 1000000.0) * count
                        }
                        "cm^2" -> {
                            m2 = (1 / 10000.0) * count
                        }
                        "m^2" -> {
                            m2 = (1 / 1.0) * count
                        }
                        "ha" -> {
                            m2 = (1 / 0.0001) * count
                        }
                        "km^2" -> {
                            m2 = (1 / 0.000001) * count
                        }
                        "ft^2" -> {
                            m2 = (1 / 10.7639104167097) * count
                        }
                        "yd^2" -> {
                            m2 = (1 / 1.19599004630108) * count
                        }
                        "acre" -> {
                            m2 = (1 / 0.00024710538147) * count
                        }

                    }
                    textView11.text=roll(m2/0.000001)        // textler m2 katsayılarına göre çarpılıp görüntülenir
                    textView12.text=roll(m2/0.0001)
                    textView13.text=roll(m2/1.0)
                    textView14.text=roll(m2/10000.0)
                    textView15.text=roll(m2/1000000.0)
                    textView16.text=roll(m2/0.09290304)
                    textView17.text=roll(m2/0.83612736)
                    textView18.text=roll(m2/4046.8564224)
                    textView19.text=""
                }
                "mass"->{
                    var kg = 0.0

                    when(typ) {
                        "mg" -> {
                            kg = (1 / 1000000.0) * count
                        }
                        "g" -> {
                            kg = (1 / 1000.0) * count
                        }
                        "kg" -> {
                            kg = (1 / 1.0) * count
                        }
                        "t" -> {
                            kg = (1 / 0.001) * count
                        }
                        "oz" -> {
                            kg = (1 / 35.2739619495804) * count
                        }
                        "lb" -> {
                            kg = (1 / 2.20462262184878) * count
                        }
                    }
                    textView11.text=roll(kg/0.000001)        // textler kg katsayılarına göre çarpılıp görüntülenir
                    textView12.text=roll(kg/0.0001)
                    textView13.text=roll(kg/1.0)
                    textView14.text=roll(kg/1000.0)
                    textView15.text=roll(kg/0.028349523125)
                    textView16.text=roll(kg/0.45359237)
                    textView17.text=""
                    textView18.text=""
                    textView19.text=""

                }
                "volume"->{
                    var lt = 0.0
                    when(typ) {
                        "ml" -> {
                            lt = (1 / 1000.0) * count
                        }
                        "L" -> {
                            lt = (1 / 1.0) * count
                        }
                        "m^3" -> {
                            lt = (1 / 0.001) * count
                        }
                        "in^3" -> {
                            lt = (1 / 61.0237440947323) * count
                        }
                        "ft^3" -> {
                            lt = (1 / 0.03531466672149) * count
                        }
                        "yd^3" -> {
                            lt = (1 / 0.00130795061931) * count
                        }
                        "gal liq" -> {
                            lt = (1 / 0.26417205235815) * count
                        }
                        "gal dry" -> {
                            lt = (1 / 0.22702074606721) * count
                        }
                    }
                    textView11.text=roll(lt/0.001)        // textler lt katsayılarına göre çarpılıp görüntülenir
                    textView12.text=roll(lt/1.0)
                    textView13.text=roll(lt/1000)
                    textView14.text=roll(lt/0.016387064)
                    textView15.text=roll(lt/28.316846592)
                    textView16.text=roll(lt/764.554857984)
                    textView17.text=roll(lt/3.785411784)
                    textView18.text=roll(lt/4.40488377086)
                    textView19.text=""

                }
                "temperature"->{
                    var celc=0.0

                    when(typ) {
                        "K" -> {
                            celc = count - 272.15
                        }
                        "°C" -> {
                            celc = count
                        }
                        "°F" -> {
                            celc = (count-32)/1.8
                        }
                    }
                    textView11.text=(celc+272.15).toString()         // textler celcius katsayılarına göre çarpılıp görüntülenir
                    textView12.text=(celc*1.0).toString()
                    textView13.text=(celc*1.8+32).toString()
                    textView14.text=""
                    textView15.text=""
                    textView16.text=""
                    textView17.text=""
                    textView18.text=""
                    textView19.text=""

                }
                "speed"->{
                    var kmh=0.0
                    when(typ) {
                        "m/sn" -> {
                            kmh = (1 / 0.27777777777777) * count
                        }
                        "km/h" -> {
                            kmh = (1 / 1.0) * count
                        }
                        "ft/sn" -> {
                            kmh = (1 / 0.91134441528142) * count
                        }
                        "mi/h" -> {
                            kmh = (1 / 0.62137119223733) * count
                        }
                    }
                    textView11.text=roll(kmh/3.6)         // textler kmh katsayılarına göre çarpılıp görüntülenir
                    textView12.text=roll(kmh/1.0)
                    textView13.text=roll(kmh/1.09728)
                    textView14.text=roll(kmh/1.609344)
                    textView15.text=""
                    textView16.text=""
                    textView17.text=""
                    textView18.text=""
                    textView19.text=""

                }

            }
        }catch (e:Exception){
            countText.setText("0.0")
            textView11.text="0.0"
            textView12.text="0.0"
            textView13.text="0.0"
            textView14.text="0.0"
            textView15.text="0.0"
            textView16.text="0.0"
            textView17.text="0.0"
            textView18.text="0.0"
            textView19.text="0.0"
        }

    }

    private fun roll(angle:Double):String{     // açılarda virgülden sonraki sayıları 10 adet olarak yuvarlar

        val angstr=angle.toString()

        val angdotcut=angstr.split('.')
        if(angstr.contains('E')){
            return angle.toString().format("%.3f")
        }
        return if (angdotcut[1].length>=10){        // noktadan sonraki 10 karakter ele alınacak
            val dotright10=angdotcut[1].substring(0,10)
            angdotcut[1].substring(9,angdotcut[1].lastIndex) // 10. sayıdan sonrası
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

    }


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

        val t11 = textView11.text           ////////
        val t12 = textView12.text
        val t13 = textView13.text
        val t14 = textView14.text
        val t15 = textView15.text
        val t16 = textView16.text
        val t17 = textView17.text
        val t18 = textView18.text
        val t19 = textView19.text            //  Textviewlerdeki veriler   ///
        val t21 = textView21.text
        val t22 = textView22.text
        val t23 = textView23.text
        val t24 = textView24.text
        val t25 = textView25.text
        val t26 = textView26.text
        val t27 = textView27.text
        val t28 = textView28.text
        val t29 = textView29.text           ////////
                                                                //
                                                         //

        val currSpin = spinner.selectedItemPosition        // mevcut seçili item

        val currCount=countText.text.toString()                    // miktar


        outState?.putCharSequence("t11", t11)  /////
        outState?.putCharSequence("t12", t12)
        outState?.putCharSequence("t13", t13)
        outState?.putCharSequence("t14", t14)
        outState?.putCharSequence("t15", t15)
        outState?.putCharSequence("t16", t16)
        outState?.putCharSequence("t17", t17)
        outState?.putCharSequence("t18", t18)
        outState?.putCharSequence("t19", t19)   ///////textviewler kaydedildi
        outState?.putCharSequence("t21", t21)
        outState?.putCharSequence("t22", t22)
        outState?.putCharSequence("t23", t23)
        outState?.putCharSequence("t24", t24)
        outState?.putCharSequence("t25", t25)
        outState?.putCharSequence("t26", t26)
        outState?.putCharSequence("t27", t27)
        outState?.putCharSequence("t28", t28)
        outState?.putCharSequence("t29", t29)   /////

        outState?.putCharSequence("currunit",currentUnit)       // currentunit de atılıyor

        outState?.putInt("currspin",currSpin)                   /// mevcut seçili spin indeks

        outState?.putCharSequence("currcount", currCount)       /// miktar
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        textView11.text=savedInstanceState?.getString("t11")
        textView12.text=savedInstanceState?.getString("t12")
        textView13.text=savedInstanceState?.getString("t13")
        textView14.text=savedInstanceState?.getString("t14")
        textView15.text=savedInstanceState?.getString("t15")
        textView16.text=savedInstanceState?.getString("t16")
        textView17.text=savedInstanceState?.getString("t17")
        textView18.text=savedInstanceState?.getString("t18")
        textView19.text=savedInstanceState?.getString("t19")
        textView21.text=savedInstanceState?.getString("t21")
        textView22.text=savedInstanceState?.getString("t22")
        textView23.text=savedInstanceState?.getString("t23")
        textView24.text=savedInstanceState?.getString("t24")
        textView25.text=savedInstanceState?.getString("t25")
        textView26.text=savedInstanceState?.getString("t26")
        textView27.text=savedInstanceState?.getString("t27")
        textView28.text=savedInstanceState?.getString("t28")
        textView29.text=savedInstanceState?.getString("t29")

        currentUnit=savedInstanceState?.getString("currunit").toString()    // mevcut birim atandı
        loadSpinnerItems(currentUnit)           // spinner verileri atandı

        val currSpin= savedInstanceState!!.getInt("currspin")////
        spinner.setSelection(currSpin)                  /// spinner selected atandı

        val currCount= savedInstanceState.getString("currcount")
        countText.setText(currCount)                            // miktar eklendi
    }


}

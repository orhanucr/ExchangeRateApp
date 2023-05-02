package com.example.orhan_ucar_odev5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var bankaAlis: TextView
    private lateinit var bankaSatis: TextView
    private lateinit var spAlis: TextView
    private lateinit var spSatis: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val choseBtn = findViewById<LinearLayout>(R.id.chose_btn)
        bankaAlis = findViewById(R.id.banka_alis)
        bankaSatis = findViewById(R.id.banka_satis)
        spAlis = findViewById(R.id.sp_alis)
        spSatis = findViewById(R.id.sp_satis)

        // XML sonuçlarını almak için XmlResult sınıfını kullanın
        val xml = XmlResult()

        // İzinleri ayarlayın
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        // XmlResult sınıfındaki xmlCurrency fonksiyonunu kullanarak XML sonuçlarını alın
        val arr = xml.xmlCurrency()

        // Popup menüyü oluşturun
        val popupMenu = PopupMenu(this, choseBtn)
        for (item in arr) {
            popupMenu.menu.add(item.Isim)
        }

        // Popup menü öğeleri seçildiğinde ne yapılacağını tanımlayın
        popupMenu.setOnMenuItemClickListener { item ->
            val selectedCurrency = arr.find { it.Isim == item.title.toString() }
            selectedCurrency?.let { currency ->
                setCurrencyValues(currency)
            }
            true
        }


        // Popup menüyü göstermek için bir düğmeye tıklanırsa ne yapılacağını belirtin
        choseBtn.setOnClickListener {
            popupMenu.show()
        }
    }

    private fun setCurrencyValues(item: Currency) {
        bankaAlis.text = item.ForexBuying
        bankaSatis.text = item.ForexSelling
        spAlis.text = item.BanknoteBuying
        spSatis.text = item.BanknoteSelling
    }



}


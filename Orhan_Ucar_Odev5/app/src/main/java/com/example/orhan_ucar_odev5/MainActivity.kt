package com.example.orhan_ucar_odev5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var bankaAlis: TextView
    private lateinit var bankaSatis: TextView
    private lateinit var spAlis: TextView
    private lateinit var spSatis: TextView
    private lateinit var secilenAdi: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val choseBtn = findViewById<LinearLayout>(R.id.chose_btn)
        bankaAlis = findViewById(R.id.banka_alis)
        bankaSatis = findViewById(R.id.banka_satis)
        spAlis = findViewById(R.id.sp_alis)
        spSatis = findViewById(R.id.sp_satis)
        secilenAdi = findViewById(R.id.secilen_adi)

        val xml = XmlResult()

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val arr = xml.xmlCurrency()

        val popupMenu = PopupMenu(this, choseBtn)
        for (item in arr) {
            popupMenu.menu.add(item.Isim)
        }

        popupMenu.setOnMenuItemClickListener { item ->
            val selectedCurrency = arr.find { it.Isim == item.title.toString() }
            selectedCurrency?.let { currency ->
                setCurrencyValues(currency)
                secilenAdi.text = currency.Isim
            }
            true
        }

        choseBtn.setOnClickListener {
            popupMenu.show()
        }

        val tarihElemani = findViewById<TextView>(R.id.date)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val tarih = Date()
        tarihElemani.text = dateFormat.format(tarih)

    }

    private fun setCurrencyValues(item: Currency) {
        bankaAlis.text = item.ForexBuying
        bankaSatis.text = item.ForexSelling
        spAlis.text = item.BanknoteBuying
        spSatis.text = item.BanknoteSelling
    }



}


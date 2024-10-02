package com.example.ejerciciostema5

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.CreationExtras

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val textDate = findViewById<TextView>(R.id.textDate)
        val c = Calendar.getInstance()

        var day = c.get(Calendar.DAY_OF_MONTH)
        var month = c.get(Calendar.MONTH)+1
        var year = c.get(Calendar.YEAR)
        var dateShow = DatePickerDialog(this,
            {datePicker, i, i1, i2 -> textDate.text = "Naciste el $i2/${i1+1}/$i" }, year, month, day)


        val today = findViewById<TextView>(R.id.textView)
        today.text = "Hoy es $day/$month/$year"

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(){
            dateShow.show()
        }

        val text = getString(R.string.calcular, 20,210)

        val t = findViewById<TextView>(R.id.textView2)

        t.text = text


    }







}
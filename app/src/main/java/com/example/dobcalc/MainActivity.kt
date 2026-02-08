package com.example.dobcalc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import android.app.DatePickerDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        val mainLayout = findViewById<View>(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        val btnDataPicker : Button = findViewById(R.id.btnDatePicker)

        btnDataPicker.setOnClickListener{
            clickDatePicker()
        }
    }

    fun clickDatePicker(){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog( this,
            DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                Toast.makeText(this,
                    "btnDatePicker pressed", Toast.LENGTH_LONG).show()

            },
            year,
            month,
            day
        ).show()
    }
}

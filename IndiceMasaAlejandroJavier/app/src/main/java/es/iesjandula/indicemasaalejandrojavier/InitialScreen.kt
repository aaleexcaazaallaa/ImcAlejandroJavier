package es.iesjandula.indicemasaalejandrojavier

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class InitialScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial_screen)
        val male = findViewById<CardView>(R.id.Hombre)
        val female = findViewById<CardView>(R.id.Mujer)
        val hightText = findViewById<TextView>(R.id.txtAltura)
        val barraProgreso = findViewById<RangeSlider>(R.id.ProgressBar)
        val txtPeso = findViewById<TextView>(R.id.txtPeso)
        val txtEdad = findViewById<TextView>(R.id.txtEdad)
        val botonMenosPeso = findViewById<FloatingActionButton>(R.id.fabMinusPeso)
        val botonMenosEdad = findViewById<FloatingActionButton>(R.id.fabMinusEdad)
        val botonMasPeso = findViewById<FloatingActionButton>(R.id.fabPlusPeso)
        val botonMasEdad = findViewById<FloatingActionButton>(R.id.fabPlusEdad)
        val botonCalcular = findViewById<Button>(R.id.btnCalcular)

        var selectedSex = ""
        male.setOnClickListener{
            male.setCardBackgroundColor(Color.DKGRAY)
            female.setCardBackgroundColor(Color.parseColor("#1D1E33"))
            selectedSex = "Hombre"
        }

        female.setOnClickListener {
            female.setCardBackgroundColor(Color.DKGRAY)
            male.setCardBackgroundColor(Color.parseColor("#1D1E33"))
            selectedSex = "Mujer"
        }

        barraProgreso.addOnChangeListener { slider, value, fromUser ->
            val valores = barraProgreso.values[0].toInt()
            val formattedText = valores.toString()
            hightText.text = formattedText
        }

        var peso = 0
        botonMenosPeso.setOnClickListener{
            if (peso > 0){
                peso--
                txtPeso.text = (peso).toString()
            }
        }

        botonMasPeso.setOnClickListener{
            if (peso < 600) {
                peso++
                txtPeso.text = (peso).toString()
            }
        }

        var edad = 0
        botonMenosEdad.setOnClickListener{
            if (edad > 0){
                edad--
                txtEdad.text = (edad).toString()
            }
        }

        botonMasEdad.setOnClickListener{
            if (edad < 130){
                edad++
                txtEdad.text = (edad).toString()
            }
        }

        botonCalcular.setOnClickListener {
            val altura = barraProgreso.values[0]
            val peso = peso
            val edad = edad
            val sexo = selectedSex

            val intent = Intent(this, InfoScreen::class.java)
            intent.putExtra("altura", altura)
            intent.putExtra("peso", peso)
            intent.putExtra("edad", edad)
            intent.putExtra("sexo", sexo)
            startActivity(intent)
        }
    }
}

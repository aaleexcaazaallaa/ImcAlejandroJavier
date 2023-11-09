package es.iesjandula.indicemasaalejandrojavier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class InfoScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_screen)

        val altura = intent.getFloatExtra("altura", 0.0f)
        val peso = intent.getIntExtra("peso", 0)
        val edad = intent.getIntExtra("edad", 0)
        val sexo = intent.getStringExtra("sexo") ?: ""

        val imc = calcularIMC(altura, peso)

        val resultadoTextView = findViewById<TextView>(R.id.tvCalculo)
        resultadoTextView.text = "INDICE DE MASA CORPORAL DEL USUARIO: $imc"

        val datosUsuarioTextView = findViewById<TextView>(R.id.tvDatosUsuario)
        datosUsuarioTextView.text = "DATOS -> \n Sexo: $sexo \n Edad: $edad años, \n Peso: $peso kg, \n Altura: $altura m"

        val btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            val intent = Intent(this, InitialScreen::class.java)
            startActivity(intent)
        }
    }

    private fun calcularIMC(altura: Float, peso: Int): Double {
        val alturaMetros = altura / 100.0 // Convertir la altura de cm a metros
        return peso / (alturaMetros * alturaMetros) // Calcular el IMC
    }
}
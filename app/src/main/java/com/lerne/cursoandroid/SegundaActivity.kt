package com.lerne.cursoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {

    // Con el signo de pregunta se avisa que puede recibir un valor null
    private var nombre:String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val boton = findViewById<Button>(R.id.btn_accion)
        val texto = findViewById<TextView>(R.id.txt_output)
        /**
         * Con el signo de pregunta indicamos
         * que el valor puede ser null y con el let
         * aseguramos que si el valor es null
         * no se rompa la aplicación y no ejecuta lo que esta entre
         * las llaves
         */
        intent.extras?.let { bundle ->
            nombre = bundle.getString("nombre")
        }

        texto.text = nombre

        boton.setOnClickListener{
            val intent = Intent()
            intent.putExtra("nombre2", "Hola desde segunda activity")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

}
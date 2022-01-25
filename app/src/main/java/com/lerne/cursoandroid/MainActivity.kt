package com.lerne.cursoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val TAG = "Lifecycle"
    // Se promete que antes de ser usada la variable va a hacer inicializada
    private lateinit var texto:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById<TextView>(R.id.txt_output)
        val boton = findViewById<Button>(R.id.btn_accion)

        boton.setOnClickListener {
            navegarSegundaActivity()
        }

    }

    private fun navegarSegundaActivity(){
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("nombre", "Curso Android")
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                val nombre = data?.getStringExtra("nombre2")
                texto.text = nombre
            }
        }
    }

}
package com.lerne.cursoandroid

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private var nombre: String? = ""
    private var edad: Int? = 0
    private val args: SegundoFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nombre = args.nombre
        edad = args.edad

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val texto = view.findViewById<TextView>(R.id.txt_nombre)
        val boton = view.findViewById<Button>(R.id.btn_enviar_datos)
        boton.setOnClickListener {
            val result = "Resultado"
            /**
             * Se coloca el id para identificar el valor que se va a enviar al otro fragment
             * el bundleOf funciona en pares como si fuera un JSON, así se evita crear
             * el bundle darle el id y el valor
             */
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(Uri.parse("cursoandroid://card"))
        }
        texto.text = "$nombre $edad"

    }

}
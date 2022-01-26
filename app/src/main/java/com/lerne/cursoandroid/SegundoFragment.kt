package com.lerne.cursoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult


class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private var nombre: String? = ""
    private var edad: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * En el momento en que se crea la actividad los datos ya estan listos
         * para mostrarse
         */
        nombre = requireArguments().getString(MI_NOMBRE)
        edad = requireArguments().getInt(MI_EDAD)
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
        }
        texto.text = "$nombre $edad"

    }


    /**
     * El companion object nos ayuda para crear
     * variables y metodos estaticos,
     * gracias a ello podemos acceder a las variables y
     * metodos desde cualquier otro lado
     */
    companion object {
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"

        fun newInstance(nombre: String, edad: Int) = SegundoFragment().apply {
            arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
        }
    }

}
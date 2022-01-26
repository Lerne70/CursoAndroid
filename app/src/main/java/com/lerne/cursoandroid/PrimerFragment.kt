package com.lerne.cursoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener

// De esta forma se pasa la vista que estaba en el onCreatedView
// Se construye de manera implicita el onCreateView
class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val boton = view.findViewById<Button>(R.id.btn_navegacion)
        val resultado = view.findViewById<TextView>(R.id.text_output)

        /**
         * Para recibir datos que vengan de otro fragment
         * Se para el requestKey que es un id para saber que datos se van a recibir
         * y el key del bundle es para identificar el bundle que se espera
         */
        setFragmentResultListener("requestKey") { key, bundle ->
            val result = bundle.getString("bundleKey")
            resultado.text = result
        }

        boton.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragment_container_view, SegundoFragment.newInstance("Luis", 22))
                addToBackStack("primerFragment")
            }
            /*
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, SegundoFragment())
                addToBackStack("primerFragment")
            }
            */
        }
    }

}
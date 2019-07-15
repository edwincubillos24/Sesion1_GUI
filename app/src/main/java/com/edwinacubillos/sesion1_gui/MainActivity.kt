package com.edwinacubillos.sesion1_gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*   //libreria que incluye los widgets directamente en el activity
                                                        //sin necesidad de bindear (findViewById)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnGuardar.setOnClickListener {                  //Listener del Boton, al presionarlo se ejecuta esta función
            var nombre = etNombre.text.toString()       //variable que almacena el nombre digitado en el EditText
            var correo = etCorreo.text.toString()       //se debe convertir a string por eso .toString()
            var cedula =  etCedula.text.toString()
            var respuesta = nombre + "\n" + correo + "\n" + cedula  //Concatenación de los datos ingresados
            txResultado.text = respuesta                //Se settean el resultado en el textview final
        }
    }//prueba commit2 prueba commit version3
}

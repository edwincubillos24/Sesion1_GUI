package com.edwinacubillos.sesion1_gui



import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

//sin necesidad de bindear (findViewById)

class MainActivity : AppCompatActivity() {

    // private lateinit var sexo: String  //se inicializa despues
    private var sexo = "Masculino"
    private var hobbies = ""
    private lateinit var date: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnGuardar.setOnClickListener {
            //Listener del Boton, al presionarlo se ejecuta esta función
            var nombre = etNombre.text.toString()       //variable que almacena el nombre digitado en el EditText
            var correo = etCorreo.text.toString()       //se debe convertir a string por eso .toString()
            var cedula = etCedula.text.toString()
            var respuesta = nombre + "\n" + correo + "\n" + cedula + "\n" + sexo + "\n" + hobbies  //Concatenación de los datos ingresados
            txResultado.text = respuesta                //Se settean el resultado en el textview final
        }
    }

    class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // Create a new instance of DatePickerDialog and return it
            return DatePickerDialog(activity, this, year, month, day)
        }

        override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
            // Do something with the date chosen by the user
          //  date = year.toString() + "/" + month.toString() + "/" + day.toString()
        }

    }

    fun showDatePickerDialog(v: View) {
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }



    fun onCheckboxClicked(view: View){
        if (view is CheckBox){
            when (view.id){
                R.id.cbNadar ->
                    if (view.isChecked){
                        hobbies = hobbies + " nadar "
                    }
                R.id.cbSeries->
                    if (view.isChecked){
                        hobbies = hobbies + " series "
                    }
                R.id.cbLeer ->
                    if (view.isChecked){
                        hobbies = hobbies + " leer "
                    }
                R.id.cbCine ->
                    if (view.isChecked){
                        hobbies = hobbies + " cine "
                    }
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            when (view.id) {
                R.id.rbMasculino ->
                    if (view.isChecked) {
                        sexo = "Masculino"
                    }
                R.id.rbFemenino ->
                    if (view.isChecked) {
                        sexo = "Femenino"
                    }
            }
        }
    }
}

package mx.edu.itsp.curso.crudrealm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_dogs_update.*
import mx.edu.itsp.curso.crudrealm.clases.Dog

class dogsUpdate : AppCompatActivity() {
    var perro:Dog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs_update)

        bUpdatePerro.setOnClickListener {
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            perro!!.edad=updateDedad.text.toString().toInt()
            perro!!.raza=updateDRaza.text.toString()
            realm.copyToRealmOrUpdate(perro)
            realm.commitTransaction()
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        //obtener la instancia
        val realm = Realm.getDefaultInstance()
        val intent=intent
        val dName=intent.getStringExtra("DName",)
        //hacemos la query para poder trabajar
        perro = realm.where<Dog>().equalTo("nombre",dName).findFirst()
        //Log.d("realm uppdate",perro.toString())
        updateName.setText(perro!!.nombre)
        updateDedad.setText(perro!!.edad.toString())
        updateDRaza.setText(perro!!.raza)
    }
}
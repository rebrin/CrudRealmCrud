package mx.edu.itsp.curso.crudrealm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import io.realm.Realm
import mx.edu.itsp.curso.crudrealm.clases.Dog

class PerrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perros)


        val bGuardaPerro=findViewById<Button>(R.id.bGuardaPerro)
        //realm
        val realm=Realm.getDefaultInstance()

        bGuardaPerro.setOnClickListener {
            val tvDName=findViewById<TextInputEditText>(R.id.tvDName)
            val tvDedad=findViewById<TextInputEditText>(R.id.tvDedad)
            val tvRaza=findViewById<TextInputEditText>(R.id.tvRaza)
            //transaccion
            realm.beginTransaction()
            val d= Dog(tvDName.text.toString(),
                    tvDedad.text.toString().toInt(),
                    tvRaza.text.toString())
            realm.copyToRealm(d)
            realm.commitTransaction()

            //limpiar
            tvDName.setText("")
            tvDedad.setText("")
            tvRaza.setText("")

        }
    }
}
package mx.edu.itsp.curso.crudrealm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import io.realm.Realm

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        Realm.init(this)
        val b=findViewById<Button>(R.id.BactivityDog)
        b.setOnClickListener {
            val i:Intent=Intent(this,MainDogs::class.java)
            startActivity(i)
        }
    }
}
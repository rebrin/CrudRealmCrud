package mx.edu.itsp.curso.crudrealm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.realm.Realm
import io.realm.kotlin.where
import mx.edu.itsp.curso.crudrealm.clases.Dog
import mx.edu.itsp.curso.crudrealm.clases.DogAdapter

class MainDogs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dogs)

     /*  val realm = Realm.getDefaultInstance()

        val perros = realm.where<Dog>().findAll()

        var perrosAdapter = DogAdapter(perros.toMutableList());
        Log.d("MyRealm", perros.toMutableList().toString())
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDogs)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = perrosAdapter
*/
        cargarAdapter()
        val FabAddDog = findViewById<FloatingActionButton>(R.id.fabAddDog)
        FabAddDog.setOnClickListener {
            val i: Intent = Intent(this, PerrosActivity::class.java)
            startActivity(i)
        }
    }

    override fun onResume() {
        super.onResume()
        cargarAdapter()
    }

    fun cargarAdapter() {
        //obtener la instancia
        Realm.init(this)
        val realm = Realm.getDefaultInstance()
        //hacemos la query para poder trabajar
        val perros = realm.where<Dog>().findAll()
        //volvemos a asignar el adapter a su elemento.
        //todo aqui debera de recibir un adapter
        var perrosAdapter = DogAdapter(perros.toMutableList(),object :DogAdapter.onDogItemListener{
            override fun onClickDog(item: View, position: Int) {
                //Log.d("realm",perros.get(position).toString())
                val i:Intent=Intent(applicationContext,dogsUpdate::class.java)
                i.putExtra("DName",perros.get(position)!!.nombre)
                startActivity(i)
            }
        })
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDogs)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = perrosAdapter
    }
}
package mx.edu.itsp.curso.crudrealm.clases

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Persona(
    @PrimaryKey
    var nombre:String="",
    var edad:Int=0,
    var perros:RealmList<Dog> =RealmList()
):RealmObject()
package mx.edu.itsp.curso.crudrealm.clases

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Dog(
        @PrimaryKey
        var nombre:String="",
               var edad:Int=0,
               var raza:String="s/n"
               ):RealmObject()
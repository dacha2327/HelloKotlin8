package com.dacha.hellokotlin8

import java.io.Serializable

data class Car(
    val name:String,
    val description:String,
    var image:Int
):Serializable

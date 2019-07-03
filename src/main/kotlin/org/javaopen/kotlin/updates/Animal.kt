package org.javaopen.kotlin.updates

open class Animal (val name: String)

class Cat(name: String) : Animal(name) {
    fun scratch() {
        println("Scratch it!")
    }
}

class Dog(name: String) : Animal(name) {
    fun bark() {
        println("Bow wow!")
    }
}

fun action(animal: Animal) {
    when (animal) {
        is Cat -> animal.scratch() // Catであることは自明なのでCatのメソッドが呼べる
        is Dog -> animal.bark() // Dogであることは自明なのでDogのメソッドが呼べる
    }
}

@file:Suppress("AddVarianceModifier")

package _0Variance

import java.util.*

/*
Task 3.
Fix only the declaration of AnimalEnumerator<T, R> class to make the code below compile
*/

// out supports subtyping -> Cat -> Animal    [In Java when you use the type: ? extends T]
// in supports Class<Animal> -> Class<Cat>    [In Java when you use the type: ? super T]

//    interface AnimalEnumerator<A : Animal, E> {
interface AnimalEnumerator<in A : Animal, out E> {
    fun invoke(animal: A): E
}

fun <A : Animal, R> AnimalEnumerator(f: (A) -> R) = object : AnimalEnumerator<A, R> {
    override fun invoke(animal: A) = f(animal)
}

open class Animal(val id: String)
class Cat(id: String, val color: Color = getRandomColor()) : Animal(id) {
    override fun toString(): String = id
}

enum class Color { WHITE, BLACK, RED, MULTI_COLORED }

fun getRandomColor(): Color = with(Color.values()) { get(Random().nextInt(size)) }

fun groupCats(cats: List<Cat>, enumerator: AnimalEnumerator<Cat, Any>) = cats.groupBy { enumerator.invoke(it) }

fun main(args: Array<String>) {
    val cats = (0..10).map { Cat("cat$it") }

    val animalEnumerator = AnimalEnumerator<Animal, Any>(Animal::id)
    val catEnumerator = AnimalEnumerator<Cat, Color>(Cat::color)

// Uncomment the following lines and make them compile
    println(groupCats(cats, animalEnumerator))
    println(groupCats(cats, catEnumerator))
}
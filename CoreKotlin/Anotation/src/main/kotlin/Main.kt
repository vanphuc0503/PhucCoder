import java.util.*

fun main() {
    val cat = Cat("Stella")
    val dog = Dog("Jerry")

//    if (dog.javaClass.isAnnotationPresent(VeryImportant::class.java)) {
    if (cat.javaClass.isAnnotationPresent(VeryImportant::class.java)) {
        println("This thing is very important")
    } else {
        println("This thing is not very important :(")
    }

    cat.javaClass.declaredMethods.forEach {
        if (it.isAnnotationPresent(RunImmediately::class.java)) {
            val annotation = it.getAnnotation(RunImmediately::class.java)
            for (i in 1..annotation.times) {
                it.invoke(cat)
            }
        }
    }

    cat.javaClass.declaredFields.forEach {
        if (it.isAnnotationPresent(ImportantString::class.java)) {
            it.isAccessible = true
            val objectValue = it.get(cat)
            if (objectValue is String) {
                println(objectValue.uppercase(Locale.getDefault()))
            }
        }
    }
}
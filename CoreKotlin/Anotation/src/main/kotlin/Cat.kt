@VeryImportant
class Cat(@ImportantString val name: String) {

    @RunImmediately(times = 3)
    fun meow() {
        println("Meow")
    }

    fun eat() {
        println("Munch")
    }
}

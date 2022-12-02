import java.io.File

open class Day {
    fun readIn(fileName: String): List<String> {
        return File(fileName).readLines();
    }

    open fun problem1() {
        println("This is problem 1");
    }

    open fun problem2() {
        println("This is problem 2");
    }
}
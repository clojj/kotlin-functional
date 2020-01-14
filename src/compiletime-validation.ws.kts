import java.lang.IllegalArgumentException

class Task(val _name: String, _priority: Int = DEFAULT) {

    companion object Priorities { // values are compile-time by 'const' modifier !
        const val MIN = 1
        const val MAX = 5
        const val DEFAULT = 3
    }

    var name: String = validName(_name)
        set(value) {
            field = validName(value)
        }

    private fun validName(name: String): String =
        if (name.isEmpty()) throw IllegalArgumentException("name can't be empty")
        else name

    var priority: Int = validPriority(_priority)
        set(value) {
            field = validPriority(value)
        }

    private fun validPriority(priority: Int): Int {
        val coercedInt = priority.coerceIn(MIN, MAX)
        when (coercedInt != priority) {
            true -> print("coerced $priority to $coercedInt")
        }
        return coercedInt
    }

}

val task = Task("a")
print(task.priority)
task.priority = 42
print(task.priority)
task.name=""
print("name ${task.name}")




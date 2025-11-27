import com.microsoft12.com534_topic_8_exercise.code.base.Student

// TuiApplication
// An application class, to handle console input/output.
// A TuiApplication object is created in main(), and its run() method called to enter the main loop of the application.
class TuiApplication {
    val university = University()

    fun addStudent() {
        println("Enter name:")
        val name = readln()
        println("Enter course:")
        val course = readln()
        println("Enter id:")
        val id = readln()
        university.addStudent(Student(id, name, course))
    }

    fun searchForStudentById() {
        println("Enter ID:")
        val id = readln()
        val student = university.findStudentById(id)
        if (student == null) {
            println("No student found")
        } else {
            println(student)
        }
    }

    fun searchForStudentsByCourse() {
        println("Enter course:")
        val course = readln()
        val students = university.findStudentsByCourse(course)
        if (students.isEmpty()) {
            println("No matching students")
        } else {
            for (s in students) {
                println(s)
            }
        }
    }

    fun run() {
        var running = true

        val optionOneHandler = MenuItemHandler {
            addStudent()
        }

        val optionTwoHandler = MenuItemHandler {
            searchForStudentById()
        }

        val optionThreeHandler = MenuItemHandler {
            searchForStudentsByCourse()
        }

        val optionFourQuitHandler = MenuItemHandler {
            running = false
        }

        val menuHandlers = arrayOf(optionOneHandler, optionTwoHandler, optionThreeHandler, optionFourQuitHandler)


        while (running) {
            val messages = listOf<String>(
                "0: Add Student",
                "1: Search for Student By ID",
                "2: Search for Students by Course",
                "3: Quit"
            )

            messages.forEach { println(it) }

            println("Enter an option:")
            val input = readln().toInt()

            messages.forEachIndexed { index, message ->
                if (index == input) {
                    menuHandlers[input].onMenuItemSelected()
                }
            }

        }
    }
}
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
        // Array of handlers for each menu item.
//        val menuHandlers = arrayOf (this, this, this)
        var running = true
//        Anonymous classes
        val optionOneHandler = object : MenuItemHandler {
            override fun onMenuItemSelected() {
                addStudent()
            }
        }

        val optionTwoHandler = object : MenuItemHandler {
            override fun onMenuItemSelected() {
                searchForStudentById()
            }
        }

        val optionThreeHandler = object : MenuItemHandler {
            override fun onMenuItemSelected() {
                searchForStudentsByCourse()
            }
        }

        val optionFourQuitHandler = object: MenuItemHandler {
            override fun onMenuItemSelected() {
                running = false
            }
        }

        val menuHandlers = arrayOf(optionOneHandler, optionTwoHandler, optionThreeHandler, optionFourQuitHandler)


        while (running) {
            // Display the menu items. forEachIndexed() is similar to forEach but provides an index as the first
            // parameter of the lambda.
            val messages = arrayOf<String>("0: Add Student", "1: Search for Student By ID", "2: Search for Students by Course", "3: Quit")
//            println("0: Add Student")
//            println("1: Search for Student By ID")
            // Searching for Students by named not inputted
            // Changing to search for students by course
            // println("2: Search for Students By name")
//            println("2: Search for Students by Course")
//            println("3: Quit")

            messages.forEach { println(it) }

            // Read the user input
            val input = readln().toInt()
//            messages.forEachIndexed { index, message -> {
//                println("$index: $message")
//                if (index == input) {
//                    println("Found Message and Index: $index")
//                    menuHandlers[input].onMenuItemSelected()
//                }
//            }}

            if (input in messages.indices) {
                menuHandlers[input].onMenuItemSelected()
                if (input == 3) running = false
            }else{
                println("Invalid Choice")
            }








            // If the input is 0-2, call the onMenuItemSelected() of the appropriate handler.
//            when (input) {
//                in 0..2 -> menuHandlers[input].onMenuItemSelected()
//                3 -> running = false
//                else -> println("Error: invalid option")
//            }
        }
    }

//    // TODO complete.
//    override fun onMenuItemSelected() {
//        when (choice) {
//            0 -> this.addStudent()
//            1 -> this.searchForStudentById()
//            2 -> this.searchForStudentsByCourse()
//        }
//
//    }
}
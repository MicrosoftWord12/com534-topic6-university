// TuiApplication
// An application class, to handle console input/output.
// A TuiApplication object is created in main(), and its run() method called to enter the main loop of the application.
// TODO make TuiApplication implement the interface.
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
        /*
        // Create an array of MenuItems. Each MenuItem has a title and a MenuItemHandler.
        // The MenuItemHandler should be the object which handles the event, i.e. the object containing the
        // onMenuItemSelected().

        // will handle the menu item selection event.  TODO add the MenuItemHandler in each case.
        val menuItems = arrayOf(
            MenuItem("Add student", /*TODO*/),
            MenuItem("Search for student by ID", /*TODO*/),
            MenuItem("Search for students by name", /*TODO*/)
        )


        var running = true
        while (running) {
            // Display the menu items. forEachIndexed() is similar to forEach but provides an index as the first
            // parameter of the lambda.
            menuItems.forEachIndexed { index, item ->
                println("${index+1} ${item.title}")
            }
            // Add a Quit option. This will have a number one greater than the last menu item.
            println("${menuItems.size}: Quit")

            // Read the user input
            val input = readln().toInt()
            when (input) {
                in menuItems.indices ->  menuItems[input].onMenuItemSelected() // if in the range of indices of menuItems, run the appropriate handler.
                menuItems.size -> running = false
                else -> println("Error: invalid option")
            }
        }

         */
    }

    /* TODO:
       Provide the onMenuItemSelected() method needed to implement the interface in TUIApplication.
       Then, rewrite your code to create separate menu item handler objects for each menu item and modify your menuItems array to use them.
       Finally, modify your menu item handlers for each menu item to use lambdas (SAM conversions) instead.
     */
}
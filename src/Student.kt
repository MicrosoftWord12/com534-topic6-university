class Student(val id: String, var name: String, var course: String) {

    override fun toString(): String {
        return "$name, ID $id, is on $course"
    }
}
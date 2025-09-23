package edu.iesam.studentplayground.features.students.data.local

import edu.iesam.studentplayground.features.students.data.StudentDataRepository
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.StudentRepository


class StudentMemLocalDataSource{

    private val dataSource : MutableMap<String, Student> = mutableMapOf()

     fun save(student: Student) {
        dataSource.put(student.exp, student)
    }

    fun delete(student: Student) {
        dataSource.remove(student.exp)
    }






}
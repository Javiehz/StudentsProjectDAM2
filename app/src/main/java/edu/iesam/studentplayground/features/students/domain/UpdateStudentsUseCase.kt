package edu.iesam.studentplayground.features.students.domain

class UpdateStudentsUseCase(private val studentRepository: StudentRepository) {
    operator fun invoke(student: Student){
        studentRepository.update(student)
    }
}
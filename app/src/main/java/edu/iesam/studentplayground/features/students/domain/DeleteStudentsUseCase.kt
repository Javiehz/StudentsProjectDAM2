package edu.iesam.studentplayground.features.students.domain

class DeleteStudentsUseCase(val studentRepository: StudentRepository) {
    operator fun invoke(student: Student){
        studentRepository.delete(student)
    }
}
package edu.iesam.studentplayground.features.students.domain

class DeleteStudentsUseCase(val studentRepository: StudentRepository) {
    operator fun invoke(student: String){
        studentRepository.delete(student)
    }
}
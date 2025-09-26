package edu.iesam.studentplayground.features.students.domain


import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test
class SaveStudentUseCaseTest {


    /*
    NOMENCLATURA: When ...... THEN .....
     */
    @Test
    fun `when invoke then save student` () {
      //Given (DADAS ESTAS VARIABLES)
        val studentRepositoryMock = mockk<StudentRepository>(relaxed = true)
        val saveStudentUseCase = SaveStudentUseCase(studentRepositoryMock)
        val student = Student("001", "Name1")

      //When (CUANDO EJECUTO)
        saveStudentUseCase.invoke(student) //CON EL OPERADOR .INVOKE NO HACE FALTA ESCRIBIR INVOKE (SAVESTUDENTUSECASE(STUDENT))

      //Then
        verify(exactly=1) { studentRepositoryMock.save(student) } //(STUDENT) NOMBRE DE LA VARIABLE EN SAVESTUDENTUSECASE
        //VERIFY LO QUE HACE ES VERIFICAR QUE LO QUE HAYAS METIDO AHI SE HAYA EJECUTADO.
        //EL EXACTLY NOS DICE CUANTAS VECES SE HABRA EJECUTADO, POR EJEMPLO SI TENEMOS DUPLICADO EL CODIGO SE EJECUTARA 2 VECES Y DARA ERROR.
    }



}
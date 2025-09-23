package edu.iesam.studentplayground.features.students.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.studentplayground.R
import edu.iesam.studentplayground.features.students.data.StudentDataRepository
import edu.iesam.studentplayground.features.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.data.local.StudentMemLocalDataSource
import edu.iesam.studentplayground.features.students.data.local.StudentXmlLocalDataSource
import edu.iesam.studentplayground.features.students.domain.DeleteStudentsUseCase
import edu.iesam.studentplayground.features.students.domain.Student

class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initStudents()
    }

    fun initStudents(){
        val xml = StudentXmlLocalDataSource()
        val mem = StudentMemLocalDataSource()
        val api = StudentApiRemoteDataSource()
        val dataRepository = StudentDataRepository(xml, mem, api)
        val saveCase = SaveStudentUseCase(dataRepository)
        val delCase = DeleteStudentsUseCase(dataRepository)

        val viewModel = StudentViewModel(saveCase, delCase)

        viewModel.saveClicked("0001", "Javier")
        viewModel.saveClicked("0002", "Karla")
        viewModel.deleteClicked("0001")




        Log.d("@dev", "Stop")
    }
}
package com.wall.student_crm.delegates.validation

import com.wall.student_crm.persistence.student.StudentRepository
import org.camunda.bpm.engine.delegate.BpmnError
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class CheckStudentExistsDelegate(
    private val studentRepository: StudentRepository
) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val studentEmail = execution.getVariable("studentEmail").toString()
        studentRepository.findByEmail(studentEmail)
            ?: throw BpmnError("STUDENT_NOT_FOUND")
        execution.setVariable("studentExists", true)
    }
}
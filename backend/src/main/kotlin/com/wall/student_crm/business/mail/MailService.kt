package com.wall.student_crm.business.mail

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Service
import com.wall.student_crm.enums.MailMessageTemplate.EXAM_CONFIRMATION_MESSAGE
import com.wall.student_crm.enums.MailMessageTemplate.EXAM_REJECTION_MESSAGE
import com.wall.student_crm.enums.MailMessageTemplate.ALREADY_ENROLLED_MESSAGE
import com.wall.student_crm.enums.MailMessageTemplate.FAILED_CHECK_MESSAGE

@Service
class MailService(
    private val client: MailClient
) {

    fun sendConfirmation(execution: DelegateExecution) {
        client.sendEmail(email(execution), EXAM_CONFIRMATION_MESSAGE)
    }

    fun sendRejection(execution: DelegateExecution) {
        client.sendEmail(email(execution), EXAM_REJECTION_MESSAGE)
    }

    fun sendAlreadyEnrolled(execution: DelegateExecution) {
        client.sendEmail(email(execution), ALREADY_ENROLLED_MESSAGE)
    }

    fun sendFailedCheck(execution: DelegateExecution) {
        client.sendEmail(email(execution), FAILED_CHECK_MESSAGE)
    }

    private fun email(execution: DelegateExecution): String {
        return execution.getVariable("studentEmail").toString()
    }
}
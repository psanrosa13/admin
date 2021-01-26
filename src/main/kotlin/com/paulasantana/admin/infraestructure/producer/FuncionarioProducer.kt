package com.paulasantana.admin.infraestructure.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.paulasantana.admin.domain.model.Funcionario
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class FuncionarioProducer(val kafkaTemplate: KafkaTemplate<String, String>, val objectMapper: ObjectMapper) {

    fun sendEvent(funcionario: Funcionario) {
        val valueMessage: String = objectMapper.writeValueAsString(funcionario)
        kafkaTemplate.send("novo_funcionario", valueMessage)
    }
}
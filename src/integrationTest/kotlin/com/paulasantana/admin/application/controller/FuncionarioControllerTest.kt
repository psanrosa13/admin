package com.paulasantana.admin.application.controller

import com.paulasantana.admin.AdminApplication
import com.paulasantana.admin.application.common.DataBaseConfiguration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest(classes = [AdminApplication::class])
@AutoConfigureMockMvc
class FuncionarioControllerTest : DataBaseConfiguration() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `Criando um novo funcionario para teste da forma antiga`() {

        val json = "{\n" +
                "\t\"nome\":\"Fabricio Souza\",\n" +
                "\t\"documento\":\"1235258987\",\n" +
                "\t\"tipoDocumento\":\"CPF\"\n" +
                "}"

        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/funcionarios")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty)
            .andReturn()
    }

}
package com.paulasantana.admin.application.common

import org.junit.ClassRule
import org.testcontainers.containers.PostgreSQLContainer

open class DataBaseConfiguration {
    @ClassRule
    var postgreSQLContainer: PostgreSQLContainer<*> =
        PostgreSQLContainer<Nothing>("postgres:alpine")
            .withDatabaseName("admin")

    init {
        val postgrePort = 5432
        postgreSQLContainer
            .withUsername("admin")
            .withPassword("admin")
            .withExposedPorts(postgrePort)
        postgreSQLContainer.start()

        val postgreURL = """
            jdbc:postgresql://${postgreSQLContainer.getContainerIpAddress()}:
            ${postgreSQLContainer.getMappedPort(postgrePort)}/
            admin?user=${postgreSQLContainer.getUsername()}
            &password=${postgreSQLContainer.getPassword()}
            """.trimIndent().replace("\n", "")

        System.setProperty("spring.datasource.url", postgreURL)
    }

}
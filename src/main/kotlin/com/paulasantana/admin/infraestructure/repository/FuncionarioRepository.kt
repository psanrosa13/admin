package com.paulasantana.admin.infraestructure.repository

import com.paulasantana.admin.domain.model.Funcionario
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface FuncionarioRepository : JpaRepository<Funcionario, Long> {

    fun findByDocumento(documento: Funcionario): Funcionario


    @Query("FROM Funcionario f WHERE f.nome LIKE %:nome% OR f.documento LIKE %:documento%")
    fun findListFuncionarios(
        @Param("nome") nome: String,
        @Param("documento") documento: String,
        pageable: Pageable
    ): Page<Funcionario>
}
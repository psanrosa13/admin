package com.paulasantana.admin.infraestructure.repository

import com.paulasantana.admin.domain.model.Funcionario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FuncionarioRepository : JpaRepository<Funcionario, Long>{

    fun findByDocumento(documento: Funcionario): Funcionario
}
package com.paulasantana.admin.domain.service

import com.paulasantana.admin.domain.exception.FuncionarioExistenteException
import com.paulasantana.admin.domain.model.Funcionario
import com.paulasantana.admin.infraestructure.repository.FuncionarioRepository
import org.springframework.stereotype.Service

@Service
class FuncionarioService(val funcionarioRepository: FuncionarioRepository) {

    fun criarNovoFuncionario(funcionario: Funcionario): Funcionario {
        if (existeFuncionario(funcionario))
            throw FuncionarioExistenteException()

        return funcionarioRepository.save(funcionario)
    }

    private fun existeFuncionario(funcionario: Funcionario): Boolean {
        if(funcionarioRepository.findByDocumento(funcionario) == null){
            return false
        }

        return true
    }
}
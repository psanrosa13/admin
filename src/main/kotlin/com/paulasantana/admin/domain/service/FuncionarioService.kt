package com.paulasantana.admin.domain.service

import com.paulasantana.admin.application.view.FuncionarioView
import com.paulasantana.admin.domain.exception.FuncionarioExistenteException
import com.paulasantana.admin.domain.exception.FuncionarioNaoExisteException
import com.paulasantana.admin.domain.model.Funcionario
import com.paulasantana.admin.infraestructure.producer.FuncionarioProducer
import com.paulasantana.admin.infraestructure.repository.FuncionarioRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class FuncionarioService(val funcionarioRepository: FuncionarioRepository,
                         val funcionarioProducer: FuncionarioProducer) {

    fun criarNovoFuncionario(funcionario: Funcionario): Funcionario {
        if (existeFuncionario(funcionario))
            throw FuncionarioExistenteException()

        funcionario.id = UUID.randomUUID()

        val funcionario = funcionarioRepository.save(funcionario)

        funcionarioProducer.sendEvent(funcionario)

        return funcionario
    }

    fun consultar(id: UUID): Funcionario {
        val funcionario: Optional<Funcionario> = funcionarioRepository.findById(id)

        if (funcionario.isPresent) return funcionario.get()

        throw FuncionarioNaoExisteException()

    }

    private fun existeFuncionario(funcionario: Funcionario): Boolean {
        if (funcionarioRepository.findByDocumento(funcionario.documento) == null) {
            return false
        }
        return true
    }

    fun excluir(id: UUID) {
        if (funcionarioRepository.existsById(id)) funcionarioRepository.deleteById(id)

        throw FuncionarioNaoExisteException()
    }

    @Transactional(readOnly = true)
    fun lista(page: Int, size: Int, nome: String, documento: String): Page<Funcionario> {
        val pageRequest: PageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name")

        return funcionarioRepository.findListFuncionarios(nome, documento, pageRequest)
    }

}
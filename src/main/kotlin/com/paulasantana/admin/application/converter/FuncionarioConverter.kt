package com.paulasantana.admin.application.converter

import com.paulasantana.admin.application.view.FuncionarioView
import com.paulasantana.admin.domain.model.Funcionario
import org.springframework.stereotype.Component

@Component
class FuncionarioConverter {

    public fun toFuncionario(view: FuncionarioView) : Funcionario {
        val funcionario =  Funcionario()
        funcionario.tipoDocumento = view.tipoDocumento
        funcionario.documento = view.documento
        funcionario.nome = view.nome

        return funcionario
    }

    public fun toFuncionarioView(funcionario: Funcionario) : FuncionarioView {
        return FuncionarioView(
            funcionario.id,
            funcionario.nome,
            funcionario.documento,
            funcionario.tipoDocumento)

    }
}
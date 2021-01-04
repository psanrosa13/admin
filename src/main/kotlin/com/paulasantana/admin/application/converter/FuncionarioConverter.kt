package com.paulasantana.admin.application.converter

import com.paulasantana.admin.application.view.FuncionarioView
import com.paulasantana.admin.domain.model.Funcionario
import org.springframework.stereotype.Component

@Component
class FuncionarioConverter {

    public fun toFuncionario(view: FuncionarioView) : Funcionario {
        var funcionario = Funcionario()

        funcionario.id = view.id
        funcionario.nome = view.nome
        funcionario.documento = view.documento
        funcionario.tipoDocumento = view.tipoDocumento

        return funcionario

    }

    public fun toFuncionarioView(funcionario: Funcionario) : FuncionarioView {
        return FuncionarioView(funcionario.id, funcionario.nome, funcionario.documento, funcionario.tipoDocumento)

    }
}
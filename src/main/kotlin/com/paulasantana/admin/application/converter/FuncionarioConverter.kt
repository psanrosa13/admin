package com.paulasantana.admin.application.converter

import com.paulasantana.admin.application.view.FuncionarioView
import com.paulasantana.admin.domain.model.Funcionario
import org.springframework.stereotype.Component

@Component
class FuncionarioConverter {

    public fun toFuncionario(view: FuncionarioView) : Funcionario {
        return Funcionario.createFuncionario(view.nome, view.documento, view.tipoDocumento)
    }

    public fun toFuncionarioView(funcionario: Funcionario) : FuncionarioView {
        return FuncionarioView(
            funcionario.getId(),
            funcionario.getNome(),
            funcionario.getDocumento(),
            funcionario.getTipoDocumento())

    }
}
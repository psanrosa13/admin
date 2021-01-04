package com.paulasantana.admin.application.controller

import com.paulasantana.admin.application.converter.FuncionarioConverter
import com.paulasantana.admin.application.view.FuncionarioView
import com.paulasantana.admin.domain.model.Funcionario
import com.paulasantana.admin.domain.service.FuncionarioService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("funcionarios")
class FuncionarioController(val service : FuncionarioService , val converter : FuncionarioConverter) {

    @PostMapping
    fun novoFuncionario(@RequestBody view : FuncionarioView): FuncionarioView {
        val funcionario = converter.toFuncionario(view)

        return converter.toFuncionarioView(service.criarNovoFuncionario(funcionario))

    }
}
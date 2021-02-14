package com.paulasantana.admin.application.controller

import com.paulasantana.admin.application.converter.FuncionarioConverter
import com.paulasantana.admin.application.view.FuncionarioView
import com.paulasantana.admin.domain.model.Funcionario
import com.paulasantana.admin.domain.service.FuncionarioService
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/funcionarios")
class FuncionarioController(val service: FuncionarioService, val converter: FuncionarioConverter) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun incluir(@RequestBody view: FuncionarioView): FuncionarioView {
        val funcionario = converter.toFuncionario(view)

        return converter.toFuncionarioView(service.criarNovoFuncionario(funcionario))
    }

    @GetMapping("/{id}")
    fun consultar(@PathVariable("id") id: UUID): FuncionarioView {
        return converter.toFuncionarioView(service.consultar(id))
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: UUID) = service.excluir(id)

    @GetMapping
    fun lista(@RequestParam(value="page", required = false, defaultValue = "0") page: Int,
              @RequestParam(value="size", required = false, defaultValue = "10") size: Int,
              @RequestParam(value="nome", required = false, defaultValue = "") nome:String,
              @RequestParam(value="documento", required = false, defaultValue = "") documento: String
    ): Page<Funcionario> {
        return service.lista(page, size, nome, documento)

    }
}
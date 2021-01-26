package com.paulasantana.admin.application.view

import com.paulasantana.admin.domain.enum.TipoDocumento
import java.util.*

data class FuncionarioView(
    val id: UUID? = null,
    val nome: String = "",
    val documento: String = "",
    val tipoDocumento: TipoDocumento = TipoDocumento.CPF
)

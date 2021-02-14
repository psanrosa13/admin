package com.paulasantana.admin.application.view

import com.paulasantana.admin.domain.enum.TipoDocumento
import java.util.*

data class FuncionarioView(
    var id : UUID? = null,
    var nome: String = "",
    var documento: String = "",
    var tipoDocumento: TipoDocumento? = TipoDocumento.CPF
)

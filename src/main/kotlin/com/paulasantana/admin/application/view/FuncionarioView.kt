package com.paulasantana.admin.application.view

import com.paulasantana.admin.domain.enum.TipoDocumento

data class FuncionarioView(val id: Long?, val nome: String?, val documento: String?, val tipoDocumento: TipoDocumento?) {

}

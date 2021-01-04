package com.paulasantana.admin.domain.model

import com.paulasantana.admin.domain.enum.TipoDocumento
import javax.persistence.*

@Entity
class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var nome: String? = null

    @Column(nullable = false)
    var documento: String? = null

    @Column(nullable = false)
    var tipoDocumento: TipoDocumento? = null
}
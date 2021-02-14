package com.paulasantana.admin.domain.model

import com.paulasantana.admin.domain.enum.TipoDocumento
import java.util.*
import javax.persistence.*

@Entity
@Table(name="funcionario")
class Funcionario {

    @Id
    public lateinit var id: UUID

    @Column(nullable = false)
    public var nome: String = ""

    @Column(nullable = false)
    public var documento: String = ""

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_documento")
    public var tipoDocumento: TipoDocumento? =TipoDocumento.CPF

}
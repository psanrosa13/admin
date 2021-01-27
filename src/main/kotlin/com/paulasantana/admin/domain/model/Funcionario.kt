package com.paulasantana.admin.domain.model

import com.paulasantana.admin.domain.enum.TipoDocumento
import java.util.*
import javax.persistence.*

@Entity
class Funcionario {

    @Id
    private var id: UUID

    @Column(nullable = false)
    private var nome: String

    @Column(nullable = false)
    private var documento: String

    @Column(nullable = false)
    private var tipoDocumento: TipoDocumento

    private constructor(nome: String, documento: String, tipoDocumento: TipoDocumento) {
        this.id = UUID.randomUUID()
        this.nome = nome
        this.documento = documento
        this.tipoDocumento = tipoDocumento
    }

    companion object {
        fun createFuncionario(nome:String, documento: String, tipo: TipoDocumento) : Funcionario{
            return Funcionario(nome, documento, tipo)
        }
    }

    fun getId(): UUID {
        return this.id
    }

    fun getNome(): String {
        return this.nome
    }

    fun getDocumento(): String{
      return this.documento
    }

    fun getTipoDocumento(): TipoDocumento{
        return this.tipoDocumento
    }

}
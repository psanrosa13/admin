package com.paulasantana.admin.domain.model

import javax.persistence.*

@Entity
class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Column(nullable = false)
    private var nome: String? = null

    @Column(nullable = false)
    private var documento: String? = null

    @Column(nullable = false)
    private var tipoDocumento: String? = null

    private constructor(id: Long?, nome: String?, documento: String?, tipoDocumento: String?) {
        this.id = id
        this.nome = nome
        this.documento = documento
        this.tipoDocumento = tipoDocumento
    }

    companion object {
        fun createFuncionario(id:Long?, nome:String?, documento: String?, tipo: String?) : Funcionario{
            return Funcionario(id, nome, documento, tipo.toString())
        }
    }

    fun getId(): Long? {
        return this.id
    }

    fun getNome(): String? {
        return this.nome
    }

    fun getDocumento(): String? {
      return this.documento
    }

    fun getTipoDocumento(): String? {
        return this.getTipoDocumento()
    }

}
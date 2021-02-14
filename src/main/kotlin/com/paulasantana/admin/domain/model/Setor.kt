package com.paulasantana.admin.domain.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "setor")
class Setor {

    @Id
    private lateinit var id: UUID

    @Column
    private var descricao: String = ""
}
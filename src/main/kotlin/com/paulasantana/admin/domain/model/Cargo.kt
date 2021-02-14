package com.paulasantana.admin.domain.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "cargo")
class Cargo {

    @Id
    private lateinit var id: UUID

    @Column
    private var descricao: String = ""

}
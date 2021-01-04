package com.paulasantana.admin.domain.exception

import java.lang.RuntimeException

open class BusinessException(message: String) : RuntimeException(message) {

}

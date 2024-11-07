package com.example.modules

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.staticModule() {
    routing {
        staticResources("/", "static")
    }
}
package com.example

import com.example.modules.staticModule
import com.example.modules.userModule
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.plugins.contentnegotiation.*

// This for Engine main & application.conf file, build.gradle.kts application section is also commented

//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
//
//fun Application.module() {
//    routing {
//        get("/") {
//            call.respondText ("Hello, World!")
//        }
//    }
//}


fun main() {
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            json()
        }
        install(CallLogging)
        userModule()
        staticModule()
    }.start(wait = true)
}






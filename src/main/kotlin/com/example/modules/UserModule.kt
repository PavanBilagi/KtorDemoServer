package com.example.modules

import com.example.Person
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userModule() {

    routing {
        get("/") {
            call.respondText("Hello, World!")
        }

        get("/users/{userName}") {
            val userName = call.parameters["userName"]
            call.respondText("Greetings, $userName ")
        }

        get("/users") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]

            call.respondText(" Hi, my name is $name, I am $age years old")
        }

        get("/person") {
            try {
                val person = Person(name = "Pavan", age = 31)
                call.respond(message = person, status = HttpStatusCode.OK)
            } catch (e: Exception) {
                call.respond(message = "${e.message}", status = HttpStatusCode.BadRequest)
            }
        }
    }
}
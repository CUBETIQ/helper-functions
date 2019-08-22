package com.cubetiqs.entize.clinical.helper

import com.cubetiqs.entize.clinical.domain.dto.TaskDao
import com.cubetiqs.entize.clinical.domain.dto.UserDto
import com.cubetiqs.entize.clinical.domain.models.User
import com.cubetiqs.entize.clinical.facade.TaskFacade
import com.cubetiqs.entize.clinical.service.UserService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class TaskCommands (@Autowired private val userService: UserService) {
    @ShellMethod("List all tasks")
    fun test1(): List<User>  = userService.browse()

    @ShellMethod("Get Test")
    fun test(): String {
        return "Hello, Papa!"
    }

    @ShellMethod("Get Test 2")
    fun test2(): String {
        val user = User()
        user.id = 1
        user.username = "sombochea"
        user.password = "123"

        val json = GsonBuilder().setPrettyPrinting().serializeNulls().create()
        val res = toJson(user)
        val u = json.fromJson(res, User::class.java)

        val a = fromJson<User>(res)

        val acc = Account()
        acc.name = "Sambo"
        acc.amount = 2000.0

        return toJson(acc)

        val s = json.fromJson("1", Int::class.java)
        return res

    }
}

data class Account (

        var name: String? = null,
        @Transient
        var amount: Double? = 0.0
)
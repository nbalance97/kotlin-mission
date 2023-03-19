package com.ladder.domain

enum class Command(
    val command: String,
) {
    ALL("ALL"),
    FINISH("FINISH");

    companion object {
        operator fun contains(command: String): Boolean = values().any { it.command == command }
    }
}

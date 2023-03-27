package com.ladder.domain

enum class Command(
    val value: String,
) {
    ALL("ALL"),
    FINISH("FINISH");
    companion object {
        operator fun contains(command: String): Boolean = values().any { it.value == command }
    }
}

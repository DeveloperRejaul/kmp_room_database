package com.example.kmp_room_database.core.navigation

import com.example.kmp_room_database.core.database.todo.TodoEntity
import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object Home : Routes

    @Serializable
    data class Create(
        val id: Long? = null,
        val title: String? = null,
        val content: String? = null
    ) : Routes {
        fun isEmpty(): Boolean {
            return content == null && id == null && title == null
        }
        fun isNotEmpty(): Boolean = !isEmpty()

        companion object {
            fun from(todo: TodoEntity?): Create {
                return Create(
                    id = todo?.id,
                    title = todo?.title,
                    content = todo?.content
                )
            }
        }

    }
}
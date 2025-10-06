package com.example.kmp_room_database.core.database.todo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert
    suspend fun insert(item: TodoEntity)

    @Query("SELECT count(*) FROM TodoEntity")
    suspend fun count(): Int

    @Delete
    suspend fun remove(item: TodoEntity)


    @Query("DELETE FROM TodoEntity WHERE id = :id")
    suspend fun removeById(id: Long)

    @Update
    suspend fun update(item: TodoEntity)

    @Query("""UPDATE TodoEntity SET title = COALESCE(:title, title), content = COALESCE(:content, content)WHERE id = :id""")
    suspend fun updateById(id: Long, title: String? = null, content: Boolean? = null)


    @Query("SELECT * FROM TodoEntity")
    fun getAllAsFlow(): Flow<List<TodoEntity>>
}
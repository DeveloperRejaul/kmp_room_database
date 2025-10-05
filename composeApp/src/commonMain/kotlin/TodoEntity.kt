import androidx.room.Entity
import androidx.room.PrimaryKey

// shared/src/commonMain/kotlin/TodoEntity.kt

@Entity
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String
)
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kmp_room_database.core.database.AppDatabase


fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
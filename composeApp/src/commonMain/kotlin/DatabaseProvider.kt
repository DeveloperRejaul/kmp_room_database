import androidx.room.RoomDatabase

// shared/src/commonMain/kotlin/DatabaseProvider.kt
object DatabaseProvider {
    private var instance: AppDatabase? = null

    fun provideDatabase(builder: RoomDatabase.Builder<AppDatabase>): AppDatabase {
        if (instance == null) {
            instance = getRoomDatabase(builder)
        }
        return instance!!
    }
}

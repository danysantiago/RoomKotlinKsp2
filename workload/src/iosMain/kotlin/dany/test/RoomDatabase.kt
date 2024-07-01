package dany.test

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

@Database(entities = [Cat::class], version = 1, exportSchema = false)
abstract class CatDatabase : RoomDatabase()

@Entity
data class Cat(@PrimaryKey val id: Long, val name: String)

fun createDatabase(): CatDatabase {
    val dbFilePath = NSHomeDirectory() + "/cat.db"
    return Room.databaseBuilder<CatDatabase>(
        name = dbFilePath,
        factory = { dany.test.CatDatabase_Impl() }
    ).setDriver(BundledSQLiteDriver())
        .build()
}
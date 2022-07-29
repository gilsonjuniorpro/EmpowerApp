package empower.ca.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import empower.ca.model.Container
import empower.ca.model.Content
import empower.ca.model.FullJson
import empower.ca.model.Operator
/*
Container::class,
Content::class,
Operator::class,
*/
@Database(entities = [
    FullJson::class
], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getOperatorDao(): OperatorDao
    abstract fun getContainerDao(): ContainerDao
    abstract fun getContentDao(): ContentDao

    companion object {
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase{
            if(instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "empower_db"
                ).build()
            }
            return instance!!
        }
    }
}
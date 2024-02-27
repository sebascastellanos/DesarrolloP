package com.example.parcial.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        // Singleton previene la inicialización múltiple de la base de datos
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // Si la instancia no es nula, entonces retorna. Si es, crea la base de datos
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "contact_database"
                ).build()
                INSTANCE = instance
                // Retorna la instancia
                instance
            }
        }
    }

}
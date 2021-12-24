package com.caspar.xl.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.caspar.xl.bean.db.TeacherBean
import com.caspar.xl.bean.db.TeacherDao
import com.caspar.xl.bean.db.UserBean
import com.caspar.xl.bean.db.UserDao
import com.example.htkotlinmvvmdemo1.app.BaseApplication

/**
 *  @Create 2021/12/24.
 *  @Use
 */
@Database(entities = [TeacherBean::class, UserBean::class], version = 1)
abstract class RoomManager : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getTeacherDao(): TeacherDao

    companion object {
        @Volatile
        private var INSTANCE: RoomManager? = null
        fun getInstance(): RoomManager {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    BaseApplication.context,
                    RoomManager::class.java,
                    "test_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }


}
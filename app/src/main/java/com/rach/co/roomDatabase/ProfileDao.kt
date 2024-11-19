package com.rach.co.roomDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertData(profileEntity: ProfileEntity)

    @Query("SELECT * from profile LIMIT 1")
    abstract fun getData():ProfileEntity?

}
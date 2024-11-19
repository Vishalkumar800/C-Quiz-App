package com.rach.co.roomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey
    val id:Int,

    @ColumnInfo("name")
    val name:String?,
    @ColumnInfo(name = "Email")
    val email:String?,
    @ColumnInfo(name = "Hobby")
    val hobby:String?,
    @ColumnInfo(name = "codingLanguage")
    val favouriteCodingLanguage:String?


)
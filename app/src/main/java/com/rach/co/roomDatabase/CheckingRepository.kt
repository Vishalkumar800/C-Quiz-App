package com.rach.co.roomDatabase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CheckingRepository(private val profileDao: ProfileDao) {
    suspend fun insertDao(profileEntity: ProfileEntity) {
        withContext(Dispatchers.IO) {
            profileDao.insertData(profileEntity)
        }
    }

    suspend fun getAlLData():ProfileEntity?{
        return withContext(Dispatchers.IO){
            profileDao.getData()
        }
    }
}
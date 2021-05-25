package com.example.roomdb

import androidx.room.*

@Dao
interface UserDao{

  //  @Insert(onConflict =OnConflictStrategy.IGNORE) //----->for same values in Database
    @Insert
  suspend  fun insert(user: User)
    @Insert
    fun insertAll(list:List<User>)
    @Delete
    fun delete(user:User)

    @Query("SELECT* FROM User WHERE age>=:age ")
  suspend   fun getAllUserWithAge(age:Int):List<User>

  @Query("SELECT* FROM User")
  fun getAllUser():List<User>

}
package com.miraz.tvmaze.model.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.miraz.tvmaze.model.entitites.UserInfo;

@Dao
public interface UserDao {

    @Insert
    void insertUserInfo(UserInfo userInfo);

    @Query("SELECT * FROM UserDB WHERE email = (:email) and password = (:password)")
    UserInfo loginInfo(String email, String password);
}

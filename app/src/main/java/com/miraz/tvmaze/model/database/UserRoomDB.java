package com.miraz.tvmaze.model.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.miraz.tvmaze.model.entitites.UserInfo;

@Database(entities = UserInfo.class, version = 1)
public abstract class UserRoomDB extends RoomDatabase {

    public abstract UserDao userDao();
    public static volatile UserRoomDB userRoomDBInstance;
    public static UserRoomDB getDatabase(final Context context){
        if(userRoomDBInstance==null){
            synchronized (UserRoomDB.class){
                if(userRoomDBInstance==null){
                    userRoomDBInstance = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoomDB.class, "UserDB").build();
                }
            }
        }
        return userRoomDBInstance;
    }

}

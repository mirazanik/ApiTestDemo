package com.miraz.tvmaze.model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.miraz.tvmaze.model.entitites.Favorite;

@Database(entities = {Favorite.class}, version = 1)
public abstract class FavoriteDatabase extends RoomDatabase {
    public abstract FavoriteDao getFavoriteDao();
}

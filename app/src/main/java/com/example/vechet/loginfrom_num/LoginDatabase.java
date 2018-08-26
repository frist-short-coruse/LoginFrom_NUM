package com.example.vechet.loginfrom_num;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(version = 4, entities = {User.class},exportSchema = false)
public abstract class LoginDatabase extends RoomDatabase {

    public static final String DB_NAME = "login_form";

    public abstract UserDao getUserDao();

    public static LoginDatabase getDatabase(Context context){
        return Room.databaseBuilder(context, LoginDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}

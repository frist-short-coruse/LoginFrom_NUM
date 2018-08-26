package com.example.vechet.loginfrom_num;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void addUser(User user);
    @Update
    void updateUser(User user);
    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM users")
    List<User> getAllUser();

    @Query("DELETE FROM users WHERE name = :name")
    void removeByName(String name);

    @Query("SELECT * FROM users WHERE name = :name")
    List<User> searchName(String name);
}

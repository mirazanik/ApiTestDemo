package com.miraz.tvmaze.model.entitites;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserDB")
public class UserInfo {

    @ColumnInfo(name = "Name")
    private String Name;

    @ColumnInfo(name = "Address")
    private String address;

    @PrimaryKey
    @NonNull
    private String email;

    @ColumnInfo(name = "Password")
    private String password;

    public UserInfo(String Name, String address, @NonNull String email, String password) {
        this.Name = Name;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return address;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

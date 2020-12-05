package com.miraz.tvmaze.model.interactors;


import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.miraz.tvmaze.model.database.UserDao;
import com.miraz.tvmaze.model.database.UserRoomDB;
import com.miraz.tvmaze.model.entitites.UserInfo;

public class UserViewModel extends AndroidViewModel {

    private UserDao userDao;
    private UserRoomDB userRoomDB;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRoomDB = UserRoomDB.getDatabase(application);
        userDao = userRoomDB.userDao();
    }

    public void insertUserInfo(UserInfo userInfo) {
        new InsertAsyncTask(userDao).execute(userInfo);
    }

    private class InsertAsyncTask extends AsyncTask<UserInfo, Void, Void> {
        UserDao mUserDAO;

        public InsertAsyncTask(UserDao mUserDAO) {
            this.mUserDAO = mUserDAO;
        }

        @Override
        protected Void doInBackground(UserInfo... userInfos) {
            mUserDAO.insertUserInfo(userInfos[0]);
            return null;
        }
    }
}

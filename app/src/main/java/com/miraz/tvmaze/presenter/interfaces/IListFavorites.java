package com.miraz.tvmaze.presenter.interfaces;

import com.miraz.tvmaze.model.entitites.Show;

import java.util.ArrayList;

public interface IListFavorites {

    interface View{
        void showFavorites(ArrayList<Show> shows);
    }

    interface Presenter{
        void searchFavorites();
        void showFavorites(ArrayList<Show> shows);
    }
}

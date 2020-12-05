package com.miraz.tvmaze.presenter.interfaces;

import com.miraz.tvmaze.model.entitites.Show;

import java.util.ArrayList;

public interface ISearchShow {

    interface View {
        void showSearch(ArrayList<Show> shows);
    }

    interface Presenter {
        void makeQuery(String query);
        void showSearch(ArrayList<Show> shows);
    }
}

package com.miraz.tvmaze.presenter.interfaces;

import com.miraz.tvmaze.model.entitites.Show;

import java.util.ArrayList;

public interface IListShows {

    interface View {
        void showList(ArrayList<Show> shows);
    }

    interface Presenter {
        void makeQuery(int page);
        void showList(ArrayList<Show> shows);
    }

}

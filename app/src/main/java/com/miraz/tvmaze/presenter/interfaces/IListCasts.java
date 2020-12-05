package com.miraz.tvmaze.presenter.interfaces;

import com.miraz.tvmaze.model.entitites.Show;

import java.util.ArrayList;

public interface IListCasts {
    interface View {
        void showCasts(ArrayList<Show> show);
    }

    interface Presenter {
        void makeQuery(int idPerson);
        void showList(ArrayList<Show> shows);
    }
}

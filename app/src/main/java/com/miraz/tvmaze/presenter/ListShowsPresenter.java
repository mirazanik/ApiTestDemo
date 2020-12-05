package com.miraz.tvmaze.presenter;

import com.miraz.tvmaze.model.entitites.Show;
import com.miraz.tvmaze.model.interactors.ListShowsInteractor;
import com.miraz.tvmaze.presenter.interfaces.IListShows;

import java.util.ArrayList;

public class ListShowsPresenter implements IListShows.Presenter {

    private IListShows.View view;

    public ListShowsPresenter(IListShows.View view){
        this.view = view;
    }

    @Override
    public void makeQuery(int page) {
        ListShowsInteractor in = new ListShowsInteractor(this);
        in.makeQuery(page);
    }

    @Override
    public void showList(ArrayList<Show> shows) {
        view.showList(shows);
    }


}

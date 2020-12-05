package com.miraz.tvmaze.presenter;

import com.miraz.tvmaze.model.entitites.Show;
import com.miraz.tvmaze.model.interactors.ListCastsInteractor;
import com.miraz.tvmaze.presenter.interfaces.IListCasts;

import java.util.ArrayList;

public class ListCastsPresenter implements IListCasts.Presenter {

    private IListCasts.View view;

    public ListCastsPresenter(IListCasts.View view){
        this.view = view;
    }

    @Override
    public void makeQuery(int idPerson) {
        ListCastsInteractor in = new ListCastsInteractor(this);
        in.makeQuery(idPerson);
    }

    @Override
    public void showList(ArrayList<Show> shows) {
        view.showCasts(shows);
    }


}

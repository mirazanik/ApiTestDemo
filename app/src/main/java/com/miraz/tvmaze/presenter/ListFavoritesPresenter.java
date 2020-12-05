package com.miraz.tvmaze.presenter;

import android.content.Context;

import com.miraz.tvmaze.model.entitites.Show;
import com.miraz.tvmaze.model.interactors.ListFavoritesInteractor;
import com.miraz.tvmaze.presenter.interfaces.IListFavorites;

import java.util.ArrayList;

public class ListFavoritesPresenter implements IListFavorites.Presenter {

    private IListFavorites.View view;
    private Context context;

    public ListFavoritesPresenter(IListFavorites.View view, Context context){
        this.view = view;
        this.context = context;
    }

    @Override
    public void searchFavorites() {
        ListFavoritesInteractor in = new ListFavoritesInteractor(this, context);
        in.searchFavorites();
    }

    @Override
    public void showFavorites(ArrayList<Show> shows) {
        view.showFavorites(shows);
    }
}

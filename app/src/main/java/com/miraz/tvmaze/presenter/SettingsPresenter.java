package com.miraz.tvmaze.presenter;

import android.content.Context;

import com.miraz.tvmaze.model.interactors.SettingsInteractor;
import com.miraz.tvmaze.presenter.interfaces.ISettings;

public class SettingsPresenter implements ISettings.Presenter {

    private ISettings.View view;

    public SettingsPresenter(ISettings.View view){
        this.view = view;
    }

    @Override
    public void showResponse(boolean response) {
        view.showResponse(response);
    }

    @Override
    public void changePassword(Context context, String lastP, String newP) {
        SettingsInteractor in = new SettingsInteractor(this);
        in.changePassword(context, lastP, newP);
    }
}

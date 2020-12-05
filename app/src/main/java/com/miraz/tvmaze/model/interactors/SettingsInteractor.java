package com.miraz.tvmaze.model.interactors;

import android.content.Context;

import com.miraz.tvmaze.presenter.interfaces.ISettings;
import com.miraz.tvmaze.utils.Defines;
import com.miraz.tvmaze.utils.Util;

public class SettingsInteractor {

    private ISettings.Presenter presenter;

    public SettingsInteractor(ISettings.Presenter presenter){
        this.presenter = presenter;
    }

    public void changePassword(Context context, String lastP, String newP){
        String val = Util.getValuePreference(context, Defines.TOKEN);
        boolean response = val.equals(lastP);
        if(response){
            Util.saveValuePreference(context, Defines.TOKEN, newP);
        }
        presenter.showResponse(response);
    }
}

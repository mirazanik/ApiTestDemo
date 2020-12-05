package com.miraz.tvmaze.model.interactors;

import android.content.Context;

import com.miraz.tvmaze.presenter.interfaces.ILogin;
import com.miraz.tvmaze.utils.Defines;
import com.miraz.tvmaze.utils.Util;

public class LoginInteractor {

    private ILogin.Presenter presenter;

    public LoginInteractor (ILogin.Presenter presenter){
        this.presenter = presenter;
    }

    public void validateToken(Context context, String token){
        presenter.showResponse(Util.getValuePreference(context, Defines.TOKEN).equals(token));
    }
}

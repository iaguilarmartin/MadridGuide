package com.iaguilarmartin.madridguide;

import android.app.Application;
import android.content.Context;

import com.iaguilarmartin.madridguide.interactors.CacheAllShopsInteractor;
import com.iaguilarmartin.madridguide.interactors.GetAllShopsInteractor;
import com.iaguilarmartin.madridguide.interactors.GetAllShopsInteractorResponse;
import com.iaguilarmartin.madridguide.model.Shops;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

public class MadridGuideApp extends Application {
    private static WeakReference<Context> appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        MadridGuideApp.appContext = new WeakReference<Context>(getApplicationContext());

        new GetAllShopsInteractor().execute(getApplicationContext(),
                new GetAllShopsInteractorResponse() {
                    @Override
                    public void response(Shops shops) {
                        new CacheAllShopsInteractor().execute(getApplicationContext(),
                                shops, new CacheAllShopsInteractor.CacheAllShopsInteractorResponse() {
                                    @Override
                                    public void response(boolean success) {
                                        // success, nothing to do here
                                    }
                                });
                    }
                }
        );

        Picasso.with(getApplicationContext()).setIndicatorsEnabled(true);
        Picasso.with(getApplicationContext()).setLoggingEnabled(true);

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static Context getAppContext() {
        if (appContext != null) {
            return MadridGuideApp.appContext.get();
        }
        return null;
    }
}

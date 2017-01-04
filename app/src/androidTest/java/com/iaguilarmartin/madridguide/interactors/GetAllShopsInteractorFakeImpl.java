package com.iaguilarmartin.madridguide.interactors;

import android.content.Context;
import android.support.annotation.NonNull;

import com.iaguilarmartin.madridguide.interactors.GetAllShopsInteractorResponse;
import com.iaguilarmartin.madridguide.interactors.IGetAllShopsInteractor;
import com.iaguilarmartin.madridguide.model.Shop;
import com.iaguilarmartin.madridguide.model.Shops;
import com.iaguilarmartin.madridguide.util.MainThread;

import java.util.ArrayList;
import java.util.List;


public class GetAllShopsInteractorFakeImpl implements IGetAllShopsInteractor {
    @NonNull
    private List<Shop> getShops() {
        List<Shop> data = new ArrayList<>();
        data.add(new Shop(1, "1").setAddress("AD 1"));
        data.add(new Shop(2, "2").setAddress("AD 2"));
        return data;
    }

    @Override
    public void execute(Context context, final GetAllShopsInteractorResponse response) {
        List<Shop> data = getShops();

        final Shops sut = Shops.build(data);

        // simulate connection
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MainThread.run(new Runnable() {
            @Override
            public void run() {
                response.response(sut);
            }
        });
    }
}

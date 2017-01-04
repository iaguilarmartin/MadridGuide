package com.iaguilarmartin.madridguide.interactors;

import android.content.Context;

import com.iaguilarmartin.madridguide.manager.db.ShopDAO;
import com.iaguilarmartin.madridguide.model.Shop;
import com.iaguilarmartin.madridguide.model.Shops;
import com.iaguilarmartin.madridguide.util.MainThread;

import java.util.List;

public class GetAllShopsFromLocalCacheInteractor {

    public interface  OnGetAllShopsFromLocalCacheInteractorCompletion {
        public void completion(Shops shops);
    }

    public void execute(final Context context, final OnGetAllShopsFromLocalCacheInteractorCompletion completion) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ShopDAO dao = new ShopDAO(context);

                List<Shop> shopList = dao.query();
                final Shops shops = Shops.build(shopList);

                MainThread.run(new Runnable() {
                    @Override
                    public void run() {
                        completion.completion(shops);
                    }
                });


            }
        }).start();
    }
}

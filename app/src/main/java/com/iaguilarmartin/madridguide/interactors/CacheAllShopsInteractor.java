package com.iaguilarmartin.madridguide.interactors;

import android.content.Context;
import android.os.Looper;

import com.iaguilarmartin.madridguide.manager.db.ShopDAO;
import com.iaguilarmartin.madridguide.model.Shop;
import com.iaguilarmartin.madridguide.model.Shops;

public class CacheAllShopsInteractor {
    public interface CacheAllShopsInteractorResponse {
        public void response(boolean success);
    }

    public void execute(final Context context, final Shops shops, final CacheAllShopsInteractorResponse response) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ShopDAO dao = new ShopDAO(context);

                boolean success = true;
                for (Shop shop: shops.allShops()) {
                    success = dao.insert(shop) > 0;
                    if (!success) {
                        break;
                    }
                }

                Looper main = Looper.getMainLooper();
                // TODO: put on Main Thread
                if (response != null) {
                    response.response(success);
                }
            }
        }).start();
    }
}

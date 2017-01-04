package com.iaguilarmartin.madridguide.interactors;

import android.content.Context;

import com.iaguilarmartin.madridguide.manager.net.NetworkManager;
import com.iaguilarmartin.madridguide.manager.net.ShopEntity;
import com.iaguilarmartin.madridguide.model.Shop;
import com.iaguilarmartin.madridguide.model.Shops;
import com.iaguilarmartin.madridguide.model.mappers.ShopEntityShopMapper;

import java.util.List;

public class GetAllShopsInteractor implements IGetAllShopsInteractor {
    public void execute(final Context context, final GetAllShopsInteractorResponse response) {
        NetworkManager networkManager = new NetworkManager(context);
        networkManager.getShopsFromServer(new NetworkManager.GetShopsListener() {
            @Override
            public void getShopEntitiesSuccess(List<ShopEntity> result) {
                List<Shop> shops = new ShopEntityShopMapper().map(result);
                if (response != null) {
                    response.response(Shops.build(shops));
                }
            }

            @Override
            public void getShopEntitiesDidFail() {
                if (response != null) {
                    response.response(null);
                }
            }
        });
    }
}

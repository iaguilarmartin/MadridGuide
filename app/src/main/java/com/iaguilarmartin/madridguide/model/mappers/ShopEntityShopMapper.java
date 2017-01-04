package com.iaguilarmartin.madridguide.model.mappers;

import com.iaguilarmartin.madridguide.manager.net.ShopEntity;
import com.iaguilarmartin.madridguide.model.Shop;

import java.util.LinkedList;
import java.util.List;

public class ShopEntityShopMapper {
    public List<Shop> map(List<ShopEntity> shopEntities) {
        List<Shop> result = new LinkedList<>();

        for (ShopEntity entity: shopEntities) {
            Shop shop = new Shop(entity.getId(), entity.getName());
            // detect current lang
            shop.setDescription(entity.getDescriptionEs());
            shop.setLogoImgUrl(entity.getLogoImg());

            // ...

            result.add(shop);
        }

        return result;
    }
}

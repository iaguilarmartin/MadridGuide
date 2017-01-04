package com.iaguilarmartin.madridguide.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Shops implements IElementsUpdate<Shop>, IElementsIterate<Shop> {

    private List<Shop> shops;

    public static @NonNull Shops build(@NonNull List<Shop> shopList) {
        Shops shops = new Shops();

        if (shopList == null) {
            shops.shops = new ArrayList<>();
        } else {
            shops.shops = shopList;
        }

        return shops;
    }

    private Shops() {
    }

    @Override
    public long size() {
        return shops.size();
    }

    @Override
    public @Nullable Shop get(final long index) {
        if (index > size() || index < 0) {
            return null;
        }
        return shops.get((int)index);
    }

    @Override
    public @NonNull List<Shop> allElements() {
        return this.shops;
    }

    @Override
    public void add(@NonNull final Shop shop) {
        this.shops.add(shop);
    }

    @Override
    public void delete(@NonNull final Shop shop) {
        this.shops.remove(shop);
    }

    @Override
    public void edit(@NonNull final Shop shop, final long index) {
        if (index > size() || index < 0) {
            return;
        }
        this.shops.set((int) index, shop);
    }
}

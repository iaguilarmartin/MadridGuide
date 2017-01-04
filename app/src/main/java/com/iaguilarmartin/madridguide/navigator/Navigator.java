package com.iaguilarmartin.madridguide.navigator;

import android.content.Intent;

import com.iaguilarmartin.madridguide.activities.MainActivity;
import com.iaguilarmartin.madridguide.activities.ShopDetailActivity;
import com.iaguilarmartin.madridguide.activities.ShopsActivity;
import com.iaguilarmartin.madridguide.model.Shop;
import com.iaguilarmartin.madridguide.util.Constants;

public class Navigator {
    public static Intent navigateFromMainActivityToShopsActivity(MainActivity mainActivity) {
        Intent i = new Intent(mainActivity, ShopsActivity.class);
        mainActivity.startActivity(i);
        return i;
    }

    public static Intent navigateFromShopsActivityToShopDetailActivity(final ShopsActivity shopsActivity, Shop detail) {
        final Intent i = new Intent(shopsActivity, ShopDetailActivity.class);

        i.putExtra(Constants.INTENT_KEY_SHOP_DETAIL, detail);

        shopsActivity.startActivity(i);

        return i;
    }

}

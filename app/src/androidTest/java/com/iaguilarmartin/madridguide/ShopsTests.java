package com.iaguilarmartin.madridguide;

import android.support.annotation.NonNull;
import android.test.AndroidTestCase;

import com.iaguilarmartin.madridguide.model.Shop;
import com.iaguilarmartin.madridguide.model.Shops;

import java.util.ArrayList;
import java.util.List;


public class ShopsTests extends AndroidTestCase {
    public void testCreatingAShopsWithNullListReturnsNonNullShops() {
        Shops sut = Shops.build(null);
        assertNotNull(sut);
        assertNotNull(sut.allElements());
    }

    public void testCreatingAShopsWithAListReturnsNonNullShops() {
        List<Shop> data = getShops();

        Shops sut = Shops.build(data);
        assertNotNull(sut);
        assertNotNull(sut.allElements());
        assertEquals(sut.allElements(), data);
        assertEquals(sut.allElements().size(), data.size());
    }

    @NonNull
    private List<Shop> getShops() {
        List<Shop> data = new ArrayList<>();
        data.add(new Shop(1, "1").setAddress("AD 1"));
        data.add(new Shop(2, "2").setAddress("AD 2"));
        return data;
    }

}

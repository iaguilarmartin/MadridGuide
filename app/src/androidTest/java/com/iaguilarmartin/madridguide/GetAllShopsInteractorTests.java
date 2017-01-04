package com.iaguilarmartin.madridguide;

import android.test.AndroidTestCase;

import com.iaguilarmartin.madridguide.interactors.GetAllShopsInteractorResponse;
import com.iaguilarmartin.madridguide.interactors.IGetAllShopsInteractor;
import com.iaguilarmartin.madridguide.model.Shop;
import com.iaguilarmartin.madridguide.model.Shops;

import com.iaguilarmartin.madridguide.interactors.GetAllShopsInteractorFakeImpl;

// deprecated: https://developer.android.com/topic/libraries/testing-support-library/index.html
public class GetAllShopsInteractorTests extends AndroidTestCase {

    public void testCanCreateInteractor() {
        IGetAllShopsInteractor getAllShopsInteractor = new GetAllShopsInteractorFakeImpl();

        getAllShopsInteractor.execute(getContext(), new GetAllShopsInteractorResponse() {
            @Override
            public void response(Shops shops) {
                assertNotNull(shops);
                assertTrue(shops.size() > 0);

                Shop shop = shops.get(1);
                assertEquals(shop.getId(), 2);
            }
        });
    }

}

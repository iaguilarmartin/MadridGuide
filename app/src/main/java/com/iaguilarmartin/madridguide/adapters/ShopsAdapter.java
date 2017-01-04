package com.iaguilarmartin.madridguide.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iaguilarmartin.madridguide.model.Shop;
import com.iaguilarmartin.madridguide.util.OnElementClick;
import com.iaguilarmartin.madridguide.views.ShopRowViewHolder;

import com.iaguilarmartin.madridguide.R;
import com.iaguilarmartin.madridguide.model.Shops;

public class ShopsAdapter extends RecyclerView.Adapter<ShopRowViewHolder> {

    private Shops shops;
    private LayoutInflater layoutInflater;

    private OnElementClick<Shop> listener;

    public ShopsAdapter(Shops shops, Context context) {
        this.shops = shops;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ShopRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_shop, parent, false);

        return new ShopRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopRowViewHolder holder, final int position) {
        final Shop shop = shops.get(position);

        holder.setShop(shop);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.clickedOn(shop, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (int)shops.size();
    }

    public void setOnElementClickListener(@NonNull final OnElementClick<Shop> listener) {
        this.listener = listener;
    }

}

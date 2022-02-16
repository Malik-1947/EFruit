package com.tarun.efruit.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tarun.efruit.Models.ProductModel;
import com.tarun.efruit.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.productViewHolder> {
    Context context;
    ArrayList<ProductModel> plist;

    public ProductAdapter(Context context, ArrayList<ProductModel> plist) {
        this.context = context;
        this.plist = plist;
    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new productViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHolder holder, int position) {
        ProductModel model = plist.get(position);
        holder.name.setText(model.getP_name());
        holder.unit.setText(model.getP_unit());
        holder.qty.setText(model.getP_qty());
        holder.price.setText(model.getP_price());
        Picasso.get().load(model.getImage()).centerCrop().into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    class productViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView name, price, qty, unit;

        public productViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            name = itemView.findViewById(R.id.productNameDisplay);
            price = itemView.findViewById(R.id.productPriceDisplay);
            qty = itemView.findViewById(R.id.productQtyDisplay);
            unit = itemView.findViewById(R.id.productUnitDisplay);
        }
    }
}

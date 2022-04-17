package com.example.arfurniture.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arfurniture.ProductDescriptionActivity;
import com.example.arfurniture.R;
import com.example.arfurniture.models.CatergoryModel;
import com.example.arfurniture.models.WishlistModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.WishlistHolder> {
    Context context;
    String TAG = "WishlistAdapter";
    List<CatergoryModel> wishlistArrayList;

    public WishlistAdapter(List<CatergoryModel> wishlistArrayList) {
        this.wishlistArrayList=wishlistArrayList;
    }

    @NonNull
    @Override
    public WishlistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new WishlistHolder(LayoutInflater.from(context).inflate(R.layout.item_cart_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.wName.setText(wishlistArrayList.get(position).getName());
        holder.wPrice.setText("Price = ₹ "+wishlistArrayList.get(position).getPrice().toString());
        Glide.with(context).asDrawable().load(wishlistArrayList.get(position).getImage()).into(holder.wImage);
        holder.wCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toProdDesc=new Intent(context, ProductDescriptionActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("CAT_LIST", (Serializable) wishlistArrayList);
                toProdDesc.putExtras(bundle);
                toProdDesc.putExtra("position",position);
                //toProdDesc.putExtra("index",1);//index = 1 for wishlist
                context.startActivity(toProdDesc);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wishlistArrayList.size();
    }

    public class WishlistHolder extends RecyclerView.ViewHolder{
        TextView wName;
        TextView wPrice;
        ImageView wImage;
        CardView wCard;
        public WishlistHolder(@NonNull View itemView) {
            super(itemView);
            wName=itemView.findViewById(R.id.idTVCourseName);
            wPrice=itemView.findViewById(R.id.idTVCourseRating1);
            wImage=itemView.findViewById(R.id.idIVCourseImage);
            wCard=itemView.findViewById(R.id.cv_cart_item);
        }
    }
}

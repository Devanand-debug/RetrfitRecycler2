package com.codewithdeva.retrfitrecycler2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    List<modle> modles;
    Context context;
    public Adapter(Context context, List<modle> modles) {
        this.context=context;
        this.modles=modles;
    }

    // Context context;
    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pojo,parent,false);

        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

        holder.name.setText(modles.get(position).getTitle());
        //holder.email.setText(modles.get(position).getTitle());
        Picasso.get().load(modles.get(position).getThumbnailUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modles.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,email;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name);
            //email=itemView.findViewById(R.id.email);

        }
    }
}

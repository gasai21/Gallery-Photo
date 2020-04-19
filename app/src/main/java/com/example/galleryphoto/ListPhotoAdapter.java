package com.example.galleryphoto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListPhotoAdapter extends RecyclerView.Adapter<ListPhotoAdapter.ListPhotoViewHolder> {
    List<PhotoModel> data;
    Context context;
    ClickItemPhoto clickItemPhoto;

    public void setClickItemPhoto(ClickItemPhoto clickItemPhoto) {
        this.clickItemPhoto = clickItemPhoto;
    }

    public ListPhotoAdapter(List<PhotoModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ListPhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_photo, parent, false);
        return new ListPhotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPhotoViewHolder holder, final int position) {
        Glide.with(context)
                .load(data.get(position).url_img)
                .into(holder.img);

        holder.txtTitle.setText(data.get(position).title);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickItemPhoto.clickPhotoListener(data.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ListPhotoViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        ImageView img;
        LinearLayout layout;
        public ListPhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            img = itemView.findViewById(R.id.img);
            layout = itemView.findViewById(R.id.layout);
        }
    }

    public interface ClickItemPhoto{
        void clickPhotoListener(PhotoModel model);
    }
}

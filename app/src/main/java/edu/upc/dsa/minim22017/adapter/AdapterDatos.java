package edu.upc.dsa.minim22017.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.upc.dsa.minim22017.R;
import edu.upc.dsa.minim22017.domain.User;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolder> {

    private List<User> listUsers;

    final OnItemClickListener listener;



    public interface OnItemClickListener{
        void onItemClick(User user);
    }


    public AdapterDatos(List<User> listUsers, OnItemClickListener listener) {
        this.listUsers = listUsers;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameFollower);
            avatar = itemView.findViewById(R.id.avatarFollower);
        }

        void bindData(final User user){
            name.setText(user.getLogin());
            Picasso.get().load(user.getAvatar_url()).into(avatar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(user);
                }
            });
        }

    }

    @NonNull
    @Override //Enlaza el adaptador con la actividad item_list
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);

        return new ViewHolder(view);
    }

    @Override //Hace la comunicación entre el adaptador y la clase ViewHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(listUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }


}

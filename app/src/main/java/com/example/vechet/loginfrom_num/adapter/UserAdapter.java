package com.example.vechet.loginfrom_num.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vechet.loginfrom_num.R;
import com.example.vechet.loginfrom_num.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    List<User> users;
    Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    public void clearData(){
        this.users.clear();
        notifyDataSetChanged();
    }


    public void setUsers(List<User> users) {
        this.users.addAll(users);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false
        );

        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.tvUser.setText(user.name);
        holder.tvPass.setText(user.password);
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView tvUser, tvPass;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tvUsername);
            tvPass = itemView.findViewById(R.id.tvPassword);
        }
    }
}

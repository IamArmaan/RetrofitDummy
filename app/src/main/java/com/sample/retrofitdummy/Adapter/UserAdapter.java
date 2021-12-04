package com.sample.retrofitdummy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.retrofitdummy.Pojo.UserResponse;
import com.sample.retrofitdummy.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserModel> {

    Context context ;
    List<UserResponse> userList;
    int layout_id;

    public UserAdapter(Context context, List<UserResponse> userList, int layout_id) {
        this.context = context;
        this.userList = userList;
        this.layout_id = layout_id;
    }

    @NonNull
    @Override
    public UserModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.user_list,parent ,false);
        return new UserModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserModel holder, int position) {

        holder.tv_name.setText(userList.get(position).getName());
        holder.tv_mobile.setText(userList.get(position).getPhone());
        holder.tv_company.setText(userList.get(position).getCompany().getName());
        holder.tv_address.setText(userList.get(position).getAddress().getCity());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserModel extends RecyclerView.ViewHolder{

        TextView tv_name , tv_mobile,tv_address , tv_company;

        public UserModel(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name);
            tv_mobile = itemView.findViewById(R.id.tv_mobile);
            tv_company = itemView.findViewById(R.id.tv_company);
            tv_address = itemView.findViewById(R.id.tv_address);
        }
    }
}

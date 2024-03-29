package com.example.chip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private List<Contacts> contactsList;
    private RecyclerItemSelectedListener itemSelectedListener;

    public RecyclerAdapter(Context context,List<Contacts> contacts){
        this.context=context;
        this.contactsList=contacts;
        this.itemSelectedListener=(MainActivity)context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.profileName.setText(contactsList.get(position).getProfileName());
        holder.profilePic.setImageDrawable(ContextCompat.getDrawable(context,contactsList.get(position).getPicId()));
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView profilePic;
        TextView profileName;
        LinearLayout rootView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            profileName=itemView.findViewById(R.id.profileName);
            profilePic=itemView.findViewById(R.id.profilePic);
            rootView=itemView.findViewById(R.id.rootView);
            rootView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemSelectedListener.onItemSelected(contactsList.get(getAdapterPosition()));
        }
    }

//    public void updateList(List<Contacts> newContacts){
//        contactsList.clear();
//        contactsList.addAll(newContacts);
//        notifyDataSetChanged();
//    }
}

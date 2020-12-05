package com.miraz.tvmaze.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.miraz.tvmaze.R;
import com.miraz.tvmaze.model.entitites.Person;
import com.miraz.tvmaze.utils.RecyclerViewOnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder>{

    private ArrayList<Person> people;
    private RecyclerViewOnItemClickListener recycler;

    public PersonAdapter(ArrayList<Person> people, @NonNull RecyclerViewOnItemClickListener recycler) {
        this.people = people;
        this.recycler = recycler;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PersonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false));
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        Person person = people.get(position);

        if (person.getImage() != null) {
            if(person.getImage().getMedium() != null) {
                Picasso.get().load(person.getImage().getMedium()).into(holder.image);
            } else if(person.getImage().getOriginal() != null){
                Picasso.get().load(person.getImage().getOriginal()).into(holder.image);
            }
        }
        holder.name.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.item_image) ImageView image;
        @BindView(R.id.item_name) TextView name;

        public PersonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recycler.onClick(v, getAdapterPosition());
        }
    }
}
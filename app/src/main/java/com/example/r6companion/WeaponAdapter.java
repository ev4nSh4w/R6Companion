package com.example.r6companion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.WeaponViewHolder> {
    private List<Weapon> weapons;

    public WeaponAdapter(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    @NonNull
    @Override
    public WeaponViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weapon_item, parent, false);
        return new WeaponViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeaponViewHolder holder, int position) {
        Weapon weapon = weapons.get(position);
        holder.name.setText(weapon.getName());
        holder.description.setText(weapon.getDescription());
        holder.damage.setText("Damage: " + weapon.getDamage());
        holder.fireRate.setText("Fire Rate: " + weapon.getFireRate());
        holder.magazine.setText("Magazine: " + weapon.getMagazine());

        Glide.with(holder.itemView.getContext())
                .load(weapon.getIconUrl())
                .into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return weapons.size();
    }

    public static class WeaponViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView description;
        TextView damage;
        TextView fireRate;
        TextView magazine;

        public WeaponViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.weapon_icon);
            name = itemView.findViewById(R.id.weapon_name);
            description = itemView.findViewById(R.id.weapon_description);
            damage = itemView.findViewById(R.id.weapon_damage);
            fireRate = itemView.findViewById(R.id.weapon_fire_rate);
            magazine = itemView.findViewById(R.id.weapon_magazine);
        }
    }
}

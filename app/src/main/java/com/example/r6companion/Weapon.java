package com.example.r6companion;

import android.os.Parcel;
import android.os.Parcelable;

public class Weapon implements Parcelable {
    public int id;
    private String name;
    private String description;
    private int damage;
    private int fireRate;
    private int magazine;
    private String icon_url;

    // Constructor
    public Weapon() {}

    // Parcelable implementation
    protected Weapon(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        damage = in.readInt();
        fireRate = in.readInt();
        magazine = in.readInt();
        icon_url = in.readString();
    }

    public static final Creator<Weapon> CREATOR = new Creator<Weapon>() {
        @Override
        public Weapon createFromParcel(Parcel in) {
            return new Weapon(in);
        }

        @Override
        public Weapon[] newArray(int size) {
            return new Weapon[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(damage);
        dest.writeInt(fireRate);
        dest.writeInt(magazine);
        dest.writeString(icon_url);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public int getMagazine() {
        return magazine;
    }

    public void setMagazine(int magazine) {
        this.magazine = magazine;
    }

    public String getIconUrl() {
        return icon_url;
    }

    public void setIconUrl(String iconUrl) {
        this.icon_url = iconUrl;
    }
}
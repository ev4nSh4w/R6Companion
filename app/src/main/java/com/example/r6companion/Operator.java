package com.example.r6companion;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class Operator implements Parcelable {
    public int id;
    private String name;
    private String role;
    private String unit;
    public List<Weapon> weapons;
    private String image_url;
    private String icon_url;
    private String description;

    // Constructor
    public Operator() {}

    // Parcelable implementation
    protected Operator(Parcel in) {
        id = in.readInt();
        name = in.readString();
        role = in.readString();
        unit = in.readString();
        weapons = in.createTypedArrayList(Weapon.CREATOR);
        image_url = in.readString();
        icon_url = in.readString();
        description = in.readString();
    }

    public static final Creator<Operator> CREATOR = new Creator<Operator>() {
        @Override
        public Operator createFromParcel(Parcel in) {
            return new Operator(in);
        }

        @Override
        public Operator[] newArray(int size) {
            return new Operator[size];
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
        dest.writeString(role);
        dest.writeString(unit);
        dest.writeTypedList(weapons);
        dest.writeString(image_url);
        dest.writeString(icon_url);
        dest.writeString(description);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public String getIconUrl() {
        return icon_url;
    }

    public void setIconUrl(String iconUrl) {
        this.icon_url = iconUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
package com.example.rodneytressler.week2assessment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * BARAKA MULUNGULA
 */

public class Account implements Parcelable {

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
    private String firstName;
    private String email;

    public Account(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    protected Account(Parcel in) {
        firstName = in.readString();
        email = in.readString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(email);
    }
}

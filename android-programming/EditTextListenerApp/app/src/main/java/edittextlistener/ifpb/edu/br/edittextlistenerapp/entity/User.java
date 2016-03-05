package edittextlistener.ifpb.edu.br.edittextlistenerapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rerissondaniel on 05/03/16.
 */

public class User implements Parcelable {

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private Integer id;
    private String fullName;
    private String email;
    private Boolean isDelivered;
    private String typeInscription;

    protected User(Parcel in) {
        id = new Integer(in.readString());
        fullName = in.readString();
        email = in.readString();
        typeInscription = in.readString();
        isDelivered = Boolean.valueOf(in.readString()).booleanValue();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public String getTypeInscription() {
        return typeInscription;
    }

    public void setTypeInscription(String typeInscription) {
        this.typeInscription = typeInscription;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", isDelivered=" + isDelivered +
                ", typeInscription='" + typeInscription + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id.toString());
        dest.writeString(fullName);
        dest.writeString(email);
        dest.writeString(typeInscription);
        dest.writeString(Boolean.toString(isDelivered));
    }
}
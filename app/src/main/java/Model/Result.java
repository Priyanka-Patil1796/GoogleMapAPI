package Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable, Parcelable
{
@SerializedName("geometry")
@Expose
private Geometry geometry;
@SerializedName("icon")
@Expose
private String icon;
@SerializedName("id")
@Expose
private String id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("opening_hours")
@Expose
private OpeningHours openingHours;
@SerializedName("photos")
@Expose
private List<Photo> photos = null;
@SerializedName("place_id")
@Expose
private String placeId;
@SerializedName("plus_code")
@Expose
private PlusCode plusCode;
@SerializedName("rating")
@Expose
private Float rating;
@SerializedName("reference")
@Expose
private String reference;
@SerializedName("scope")
@Expose
private String scope;
@SerializedName("types")
@Expose
private List<String> types = null;
@SerializedName("user_ratings_total")
@Expose
private Integer userRatingsTotal;
@SerializedName("vicinity")
@Expose
private String vicinity;

    protected Result(Parcel in) {
        icon = in.readString();
        id = in.readString();
        name = in.readString();
        placeId = in.readString();
        if (in.readByte() == 0) {
            rating = null;
        } else {
            rating = in.readFloat();
        }
        reference = in.readString();
        scope = in.readString();
        types = in.createStringArrayList();
        if (in.readByte() == 0) {
            userRatingsTotal = null;
        } else {
            userRatingsTotal = in.readInt();
        }
        vicinity = in.readString();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public Geometry getGeometry() {
return geometry;
}

public void setGeometry(Geometry geometry) {
this.geometry = geometry;
}

public String getIcon() {
return icon;
}

public void setIcon(String icon) {
this.icon = icon;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public OpeningHours getOpeningHours() {
return openingHours;
}

public void setOpeningHours(OpeningHours openingHours) {
this.openingHours = openingHours;
}

public List<Photo> getPhotos() {
return photos;
}

public void setPhotos(List<Photo> photos) {
this.photos = photos;
}

public String getPlaceId() {
return placeId;
}

public void setPlaceId(String placeId) {
this.placeId = placeId;
}

public PlusCode getPlusCode() {
return plusCode;
}

public void setPlusCode(PlusCode plusCode) {
this.plusCode = plusCode;
}

public Float getRating() {
return rating;
}

public void setRating(Float rating) {
this.rating = rating;
}

public String getReference() {
return reference;
}

public void setReference(String reference) {
this.reference = reference;
}

public String getScope() {
return scope;
}

public void setScope(String scope) {
this.scope = scope;
}

public List<String> getTypes() {
return types;
}

public void setTypes(List<String> types) {
this.types = types;
}

public Integer getUserRatingsTotal() {
return userRatingsTotal;
}

public void setUserRatingsTotal(Integer userRatingsTotal) {
this.userRatingsTotal = userRatingsTotal;
}
public String getVicinity() {
return vicinity;
}

public void setVicinity(String vicinity)
{
this.vicinity = vicinity;
}

    @Override
    public String toString() {
        return "Result{" +
                "geometry=" + geometry +
                ", icon='" + icon + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", openingHours=" + openingHours +
                ", photos=" + photos +
                ", placeId='" + placeId + '\'' +
                ", plusCode=" + plusCode +
                ", rating=" + rating +
                ", reference='" + reference + '\'' +
                ", scope='" + scope + '\'' +
                ", types=" + types +
                ", userRatingsTotal=" + userRatingsTotal +
                ", vicinity='" + vicinity + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(icon);
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(placeId);
        if (rating == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(rating);
        }
        dest.writeString(reference);
        dest.writeString(scope);
        dest.writeStringList(types);
        if (userRatingsTotal == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userRatingsTotal);
        }
        dest.writeString(vicinity);
    }
}
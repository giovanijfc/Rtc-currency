package com.example.rtc_currency.database.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Exchange() : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var idDB: Int? = null
    @SerializedName("id")
    var remoteId: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("year_established")
    var yearEstablised: Int? = null
    @SerializedName("image")
    var image: String? = null
    @SerializedName("country")
    var country: String? = null
    @SerializedName("trust_score_rank")
    var trustScoreRank: Int? = null

    constructor(parcel: Parcel) : this() {
        idDB = parcel.readValue(Int::class.java.classLoader) as? Int
        remoteId = parcel.readString()
        name = parcel.readString()
        yearEstablised = parcel.readValue(Int::class.java.classLoader) as? Int
        image = parcel.readString()
        country = parcel.readString()
        trustScoreRank = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun toString(): String {
        return "Exchange(idDB=$idDB, remoteId=$remoteId, name=$name, yearEstablised=$yearEstablised, image=$image, country=$country, trustScoreRank=$trustScoreRank)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idDB)
        parcel.writeString(remoteId)
        parcel.writeString(name)
        parcel.writeValue(yearEstablised)
        parcel.writeString(image)
        parcel.writeString(country)
        parcel.writeValue(trustScoreRank)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Exchange> {
        override fun createFromParcel(parcel: Parcel): Exchange {
            return Exchange(parcel)
        }

        override fun newArray(size: Int): Array<Exchange?> {
            return arrayOfNulls(size)
        }
    }
}
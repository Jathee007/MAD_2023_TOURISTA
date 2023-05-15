package com.company.notes.feedback

import android.os.Parcel
import android.os.Parcelable

class FeedbackModel() : Parcelable {
    var name : String? = null
    var rating: String? = null
    var review: String? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        rating = parcel.readString()
        review = parcel.readString()

    }

    constructor(rating: String, review: String,name : String) : this() {
        this.rating = rating
        this.review = review
        this.name = name

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(review)
        parcel.writeString(rating)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FeedbackModel> {
        override fun createFromParcel(parcel: Parcel): FeedbackModel {
            return FeedbackModel(parcel)
        }

        override fun newArray(size: Int): Array<FeedbackModel?> {
            return arrayOfNulls(size)
        }
    }


}
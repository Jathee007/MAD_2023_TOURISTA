package com.company.notes.feedback

import android.content.Intent
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.company.notes.R
import com.company.notes.databinding.ActivityUpdateCardBinding
import com.google.firebase.database.*


class UpdateCard : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateCardBinding
    private lateinit var paymentID: String
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    lateinit var payment: FeedbackModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)


        binding = ActivityUpdateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paymentID = intent.getStringExtra("reviewID").toString()

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("Review").child(paymentID)

        val cardholderName = findViewById<RatingBar>(R.id.ratingBar)
        fetchsightDetails()

        binding.btndelete.setOnClickListener {
            databaseReference.removeValue()
            val intent = Intent(this, AllCardDetails::class.java)
            startActivity(intent)
            finish()


        }

        binding.btnupdate.setOnClickListener {
            val rating = binding.ratingBar.rating
            val review = binding.etCardnumber.text.toString()
            if (  review.isEmpty() ) {
                Toast.makeText(this, "Enter Review!!", Toast.LENGTH_SHORT).show()
            } else {


                databaseReference  = firebaseDatabase.getReference("Review").child(paymentID)

                var hashMap : HashMap<String, String> = HashMap<String, String>()
                hashMap.put("review", review);
                hashMap.put("rating", rating.toString());
                databaseReference.updateChildren(hashMap as Map<String, Any>)
                Toast.makeText(this, "Updated Succesfully", Toast.LENGTH_SHORT).show()
                val intent1 = Intent(this, UserViewFeedback::class.java)
                startActivity(intent1)
                finish()



            }
        }


    }

    private fun fetchsightDetails() {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.getValue(FeedbackModel::class.java)?.let {
                    payment = it
                    val rating = payment.rating.toString().toFloat()
                    val review = payment.review
//                        val rating: Float = snapshot.getValue().toString().toFloat()
                        binding.ratingBar.setRating(rating)

                    binding.etCardnumber.setText(review)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@UpdateCard, error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent1 = Intent(this, UserViewFeedback::class.java)
//        intent1.putExtra("reviewID", paymentID)
        startActivity(intent1)
        finish()
    }
}
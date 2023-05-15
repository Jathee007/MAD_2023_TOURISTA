package com.company.notes.feedback

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import com.company.notes.R
import com.company.notes.ThankYou
import com.company.notes.databinding.ActivityAddPaymentBinding
import com.google.firebase.database.*
import android.os.Handler
import android.os.Looper

class AddFeedback : AppCompatActivity() {
    /*add feedback */
    lateinit var binding: ActivityAddPaymentBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Tourista"
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("Review")

        val cardholderName = findViewById<RatingBar>(R.id.ratingBar)

        binding.savecard.setOnClickListener {
            val intent1 = Intent(this, AllCardDetails::class.java)
            startActivity(intent1)

        }

        binding.btnAddpayment.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val rating = binding.ratingBar.rating.toString()
            val review = binding.etCardnumber.text.toString()

            if (rating.isEmpty() || review.isEmpty()  || username.isEmpty()  ) {
                Toast.makeText(this, "Enter all fields first!!", Toast.LENGTH_SHORT).show()
            } else {

                val PaymentModel = FeedbackModel(

                    rating,
                    review,
                    username,

                )

                databaseReference.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        databaseReference.child(username).setValue(PaymentModel)

                        Handler(Looper.getMainLooper()).postDelayed({
                            Toast.makeText(
                                this@AddFeedback,
                                "Review Added Successfully !!!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }, 2000) // delay for 2 seconds
                    }


                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(
                            this@AddFeedback,
                            "Error: $error",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                )

                val intent = Intent(this, ThankYou::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
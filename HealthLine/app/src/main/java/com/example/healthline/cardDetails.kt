package com.example.healthline

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.braintreepayments.cardform.view.CardForm
import com.example.healthline.databinding.ActivityCardDetailsBinding

class cardDetails : AppCompatActivity() {
    private lateinit var binding: ActivityCardDetailsBinding
    private lateinit var  cardForm: CardForm
    private lateinit var  button8: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button8.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }
        binding.imageView78.setOnClickListener {
            val intent = Intent(this, Medication::class.java)
            startActivity(intent)
        }


        cardForm =findViewById(R.id.cardForm)
        cardForm.cardRequired(true)
            .expirationRequired(true)
            .cvvRequired(true)
            .cardholderName(CardForm.FIELD_REQUIRED)
            .actionLabel("Purchase")
            .postalCodeRequired(true)
            .mobileNumberRequired(true)
            .mobileNumberExplanation("The number is required for SMS verification")
            .setup(this@cardDetails)
        cardForm.cvvEditText.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD

        button8 = findViewById(R.id.button8)
        if(cardForm.isValid){
            Toast.makeText(this@cardDetails,"Card number: ${cardForm.cardNumber}" +
                    "Card expiry date: ${cardForm.expirationDateEditText.toString()}" +
                    "Card cvv: ${cardForm.cvv}" +
                    "Card holder name: ${cardForm.cardholderName}"+"Card postal code: ${cardForm.postalCode}"
                    +  "Card mobile number: ${cardForm.mobileNumber}\n"
                , Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this@cardDetails,"Please complete the form", Toast.LENGTH_LONG).show()
        }

    }
}

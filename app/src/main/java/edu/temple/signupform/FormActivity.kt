package edu.temple.signupform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.submitButton)
            .setOnClickListener{submitData()}
    }

    private fun submitData() {
        val nameText = findViewById<EditText>(R.id.editName)
        val emailText = findViewById<EditText>(R.id.editEmail)
        val passwordText1 = findViewById<EditText>(R.id.editPassword)
        val passwordText2 = findViewById<EditText>(R.id.editPassword2)
        var error: Boolean = false

        if (nameText.text.toString().isEmpty()) {
            nameText.error = "Error: Name is blank"
            error = true
        }

        if (emailText.text.toString().isEmpty()) {
            emailText.error = "Error: Email is blank"
            error = true
        }

        if (passwordText1.text.toString().isEmpty()) {
            passwordText1.error = "Error: Password is blank"
            error = true
        }

        if (passwordText2.text.toString().isEmpty()) {
            passwordText2.error = "Error: Must confirm password"
            error = true
        }

        if (!error && passwordText1.text.toString() != passwordText2.text.toString()) {
            passwordText2.error = "Error: Passwords must match"
            error = true
        }

        if (!error) {
            val toast = Toast.makeText(this, "Welcome, ${nameText.text.toString()}!", Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}
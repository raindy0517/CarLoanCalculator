package com.example.loancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            //val = value
            //var = variable
            val carPrice = editTextCarPrice.text.toString().toInt()
            if(carPrice == 0 || carPrice == null){
                editTextCarPrice.setError("Please Enter Car Price !")
            }

            val downPayment = editTextDownPayment.text.toString().toInt()
            if(downPayment <= (carPrice/10) || downPayment == null){
                editTextCarPrice.setError("Please Enter Car Price !")
            }

            val loanPeriod = editTextLoadPeriod.text.toString().toInt()
            if(loanPeriod == 0 || loanPeriod == null){
                editTextCarPrice.setError("Please Enter Car Price !")
            }

            val interestRate = editTextInterestRate.text.toString().toFloat()
            if(interestRate == null){
                editTextCarPrice.setError("Please Enter Car Price !")
            }

            /*TODO:Coninue your calculation here
              TODO:Find the locale of the user and display the currency sign
             */

            val carLoan =  carPrice - downPayment
            val interest = carLoan*interestRate*loanPeriod
            val monthlyPayment = (carLoan + interest) / loanPeriod / (12)


            textViewLoan.text = "Total Loan     : ${carLoan}"
            textViewInterest.text = "Total Interest : " + interest.toString();
            textViewMonthlyPayment.text = "Monthly Payment: " + monthlyPayment.toString();
        }

        fun reset(view: View) {
            //TODO : reset all inputs and output
            editTextCarPrice.text.clear()
            editTextDownPayment.text.clear()
            editTextInterestRate.text.clear()
            editTextLoadPeriod.text.clear()

        }
    }


}

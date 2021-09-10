package com.emlydltn.budgit

import SpendMoneyFragment
import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var foodText: TextView;
    private lateinit var gasText: TextView;
    private lateinit var toiletriesText: TextView;
    private lateinit var tuitionText: TextView;
    private lateinit var allowanceText: TextView;
    private lateinit var savingsText: TextView;
    private lateinit var charityText: TextView;
    private lateinit var spendingText: TextView;
    private lateinit var totalText: TextView;
    private lateinit var sharePref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        foodText = findViewById(R.id.foodBudget)
        gasText = findViewById(R.id.gasBudget)
        toiletriesText = findViewById(R.id.toiletriesBudget)
        tuitionText = findViewById(R.id.tuitionBudget)
        allowanceText = findViewById(R.id.allowanceBudget)
        savingsText = findViewById(R.id.savingsBudget)
        charityText = findViewById(R.id.charityBudget)
        spendingText = findViewById(R.id.spendingBudget)
        totalText = findViewById(R.id.totalBudget)

        sharePref = getSharedPreferences("MoneyValues", Context.MODE_PRIVATE)

        Money.food = sharePref.getString("food", "")?.toDouble() ?: 0.0;
        Money.gas = sharePref.getString("gas", "")?.toDouble() ?: 0.0;
        Money.toiletries = sharePref.getString("toiletries", "")?.toDouble() ?: 0.0;
        Money.tuition = sharePref.getString("tuition", "")?.toDouble() ?: 0.0;
        Money.allowance = sharePref.getString("allowance", "")?.toDouble() ?: 0.0;
        Money.savings = sharePref.getString("savings", "")?.toDouble() ?: 0.0;
        Money.charity = sharePref.getString("charity", "")?.toDouble() ?: 0.0;
        Money.spending = sharePref.getString("spending", "")?.toDouble() ?: 0.0;
        Money.total = sharePref.getString("total", "")?.toDouble() ?: 0.0;

        updateText()

        var calendar = Calendar.getInstance()
        var currentWeek = calendar.get(Calendar.DAY_OF_WEEK)
//        if(currentWeek.equals(Calendar.SATURDAY)){
//            Money.tuition += 69
//            updateText()
//        }


        val foodCard = findViewById<MaterialCardView>(R.id.FoodCard);
        foodCard.setOnClickListener{
            onButtonPressed("food")
        }

        val gasCard = findViewById<MaterialCardView>(R.id.GasCard);
        gasCard.setOnClickListener{
            onButtonPressed("gas")
        }

        val toiletriesCard = findViewById<MaterialCardView>(R.id.ToiletriesCard);
        toiletriesCard.setOnClickListener{
            onButtonPressed("toiletries")
        }

        val tuitionCard = findViewById<MaterialCardView>(R.id.TuitionCard);
        tuitionCard.setOnClickListener{
            onButtonPressed("tuition")
        }

        val allowanceCard = findViewById<MaterialCardView>(R.id.AllowanceCard);
        allowanceCard.setOnClickListener{
            onButtonPressed("allowance")
        }

        val savingsCard = findViewById<MaterialCardView>(R.id.SavingsCard);
        savingsCard.setOnClickListener{
            onButtonPressed("savings")
        }

        val charityCard = findViewById<MaterialCardView>(R.id.CharityCard);
        charityCard.setOnClickListener{
            onButtonPressed("charity")
        }

        val spendingCard = findViewById<MaterialCardView>(R.id.SpendingCard);
        spendingCard.setOnClickListener{
            onButtonPressed("spending")
        }
    }

    public fun updateText(){
        foodText.text = Money.foodString()
        gasText.text = Money.gasString()
        toiletriesText.text = Money.toiletriesString()
        tuitionText.text = Money.tuitionString()
        allowanceText.text = Money.allowanceString()
        savingsText.text = Money.savingsString()
        charityText.text = Money.charityString()
        spendingText.text = Money.spendingString()
        totalText.text = Money.totalString()
    }

    private fun onButtonPressed(type: String) {

//        Money.food += 5
//        var inDataBase = sharePref.getString("food", "")

        var newValue = sharePref.getString("food", "")
        updateText()
        allowanceText.text = newValue



        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Would you like to add or spend?")
        builder.setPositiveButton("Spend"
                ) { dialog, which ->
//                    var userInput = findViewById<EditText>(R.id.spentMoney)
//                    var money = userInput.getText().toString()
//                    PrintStream(money)
                    var dialog = SpendMoneyFragment(type, false, sharePref)
                    dialog.show(supportFragmentManager, "customDialog")
                }
                .setNegativeButton(
                        "Add"
                ) { dialog, which ->
                    var dialog = SpendMoneyFragment(type, true, sharePref)
                    dialog.show(supportFragmentManager, "customDialog")
                }
        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun onConfirmation() {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Time to start the new week!")
                .setNegativeButton(
                        "Continue"
                ) { dialog, which ->
                    dialog.cancel()
                }
        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun addMoney(){
        var leftOver = Money.food;


    }


}
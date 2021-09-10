package com.emlydltn.budgit

import android.content.SharedPreferences

object Money {
    var food = 00.00;
    var gas = 00.00;
    var toiletries = 00.00;
    var tuition = 0.00;
    var allowance = 0.00;
    var savings = 0.00;
    var charity = 0.00;
    var spending = 0.00;
    var total = food + gas + toiletries + tuition + allowance + savings + charity + spending;
    fun foodString(): String{
        return "$" + String.format("%.2f", food)
    }

    fun gasString(): String{
        return "$" + String.format("%.2f", gas)
    }

    fun toiletriesString(): String{
        return "$" + String.format("%.2f", toiletries)
    }

    fun tuitionString(): String{
        return "$" + String.format("%.2f", tuition)
    }

    fun allowanceString(): String{
        return "$" + String.format("%.2f", allowance)
    }

    fun savingsString(): String{
        return "$" + String.format("%.2f", savings)
    }

    fun charityString(): String{
        return "$" + String.format("%.2f", charity)
    }

    fun spendingString(): String{
        return "$" + String.format("%.2f", spending)
    }

    fun totalString(): String{

        return "$" + String.format("%.2f", total)
    }

    fun updateMoney(value: String, money: Double, operation: Boolean, editor: SharedPreferences.Editor){
        if(value == "food"){
            if(operation){
                food += money
                editor.putString(value, Money.food.toString())
                editor.commit()
            }else{
                food-= money
                editor.putString(value, Money.food.toString())
                editor.commit()
            }
        }else if(value == "gas"){
            if(operation){
                gas += money
                editor.putString(value, Money.gas.toString())
                editor.commit()
            }else{
                gas -= money
                editor.putString(value, Money.gas.toString())
                editor.commit()
            }
        }else if(value == "toiletries"){
            if(operation){
                toiletries += money
                editor.putString(value, Money.toiletries.toString())
                editor.commit()
            }else{
                toiletries -= money
                editor.putString(value, Money.toiletries.toString())
                editor.commit()
            }
        }else if(value == "spending"){
            if(operation){
                spending += money
                editor.putString(value, Money.spending.toString())
                editor.commit()
            }else{
                spending -= money
                editor.putString(value, Money.spending.toString())
                editor.commit()
            }
        }else if(value == "tuition"){
            if(operation){
                tuition += money
                editor.putString(value, Money.tuition.toString())
                editor.commit()
            }else{
                tuition -= money
                editor.putString(value, Money.tuition.toString())
                editor.commit()
            }
        }else if(value == "allowance"){
            if(operation){
                allowance += money
                editor.putString(value, Money.allowance.toString())
                editor.commit()
            }else{
                allowance -= money
                editor.putString(value, Money.allowance.toString())
                editor.commit()
            }
        }else if(value == "savings"){
            if(operation){
                savings += money
                editor.putString(value, Money.savings.toString())
                editor.commit()
            }else{
                savings -= money
                editor.putString(value, Money.savings.toString())
                editor.commit()
            }
        }else if(value == "charity"){
            if(operation){
                charity += money
                editor.putString(value, Money.charity.toString())
                editor.commit()
            }else{
                charity -= money
                editor.putString(value, Money.charity.toString())
                editor.commit()
            }
        }
        total = food + gas + toiletries + tuition + allowance + savings + charity + spending;
        editor.putString("total", total.toString())
        editor.commit()
    }
}
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.emlydltn.budgit.MainActivity
import com.emlydltn.budgit.Money
import com.emlydltn.budgit.R

class SpendMoneyFragment(var type: String, var operation: Boolean, var sharePref: SharedPreferences) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var editor = sharePref.edit();
        var rootView: View = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        var uiText = rootView.findViewById<TextView>(R.id.dialogTitle)
        if(operation){
            uiText.text = "How much would you like to add?"
        }
        var cancel = rootView.findViewById<Button>(R.id.cancelButton)
        cancel.setOnClickListener{
            dismiss()
        }

        var submit = rootView.findViewById<Button>(R.id.submitButton)
        var userInput = rootView.findViewById<EditText>(R.id.spentValue)
        submit.setOnClickListener{
            var text = userInput.text.toString().toDouble()
            Money.updateMoney(type, text, operation, editor)
            (activity as MainActivity).updateText()
            dismiss()
        }
        return rootView
    }
}
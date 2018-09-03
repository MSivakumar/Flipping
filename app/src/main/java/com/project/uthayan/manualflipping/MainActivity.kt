package com.project.uthayan.manualflipping

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import android.support.v4.content.ContextCompat.getSystemService
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager


class MainActivity : AppCompatActivity() {

    private  var size_of_belt : Float = 0.0f
    private  var number_of_belt : Float = 0.0f
    private var final : Float = 0.0f
    private var detaildialoguebox = Detaildialoguebox()
    private var dialog : String = "MM/IN    SIZE     COUNT     %     Total\n"

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val itemID = item!!.itemId
        if(itemID == R.id.app_info){
            lifecycle.addObserver(Component(this, detaildialoguebox, dialog))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculate.setOnClickListener {
            if(Calculate()){
                if(test.text.toString()=="MM") {
                    dialog = dialog+"MM      "+size_of_belt+"   "+number_of_belt+"    "
                    final = final + FindResultMM()
                    dialog = dialog+("%.2f".format(final))+"\n"
                }
                else {
                    dialog = dialog+"INCH     "+size_of_belt+"   "+number_of_belt+"    "
                    final = final + FindResultINCH()
                    dialog = dialog+("%.2f".format(final))+"\n"
                }
            }
            result.text = final.toString()
            sizeOfBelt.text = null
            numberOfBelt.text = null
            test.text = null
            hideKeyBoard(it)
            final = 0.0f
            Log.d("DIALOG",dialog)
            lifecycle.addObserver(Component(this, detaildialoguebox, dialog))
            dialog = "MM/IN    SIZE     COUNT     %     Total\n"
        }
        conti.setOnClickListener {
            if(Calculate()){
                if(test.text.toString()=="MM") {
                    dialog = dialog+"MM      "+size_of_belt+"   "+number_of_belt+"    "
                    final = final + FindResultMM()
                    dialog = dialog+("%.2f".format(final))+"\n"
                }
                else {
                    dialog = dialog+"INCH     "+size_of_belt+"   "+number_of_belt+"    "
                    final = final + FindResultINCH()
                    dialog = dialog+("%.2f".format(final))+"\n"
                }
            }
            sizeOfBelt.text = null
            numberOfBelt.text = null
            test.text = null
            hideKeyBoard(it)
            result.text = final.toString()
        }
        layout.setOnClickListener{
            hideKeyBoard(it)
        }
    }

    private fun hideKeyBoard(it: View?) {
        val inputMethodManager = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0)
    }

    private fun  Calculate (): Boolean {
        val size = sizeOfBelt.text
        val number = numberOfBelt.text
        if(size.isEmpty()||number.isEmpty()) {
            Toast.makeText(this, "Enter the size & number of belts", Toast.LENGTH_SHORT).show()
            return false
        }
        else if(size.toString().toFloat()==0.0f){
            var output: Float
            if(test.text.toString()=="MIN") {
                output = (number.toString().toFloat() * 13) / 60
                dialog += "REASON    "+number.toString()+"  Mins   "+("%.2f".format(output))+"      "
            }
            else {
                output = number.toString().toFloat() * 13
                dialog += "REASON    "+number.toString()+"  Hours   "+("%.2f".format(output))+"      "
            }
            final += output
            dialog += ("%.2f".format(final))+"\n"
            return false
        }
        else {
            size_of_belt = size.toString().toFloat()
            number_of_belt = number.toString().toFloat()
            return true
        }
    }

    private fun FindResultMM(): Float {
        var output: Float = 0.0f
        if ((size_of_belt >= 482 && size_of_belt <= 660))
            output = (number_of_belt / 1034) * 100
        else if ((size_of_belt >= 685 && size_of_belt <= 864))
            output = (number_of_belt / 1292) * 100
        else if ((size_of_belt >= 890 && size_of_belt <= 1016))
            output = (number_of_belt / 1292) * 100
        else if ((size_of_belt >= 1041 && size_of_belt <= 1270))
            output = (number_of_belt / 1240) * 100
        else if ((size_of_belt >= 1275 && size_of_belt <= 1524))
            output = (number_of_belt / 1230) * 100
        else if ((size_of_belt >= 1550 && size_of_belt <= 1702))
            output = (number_of_belt / 1258) * 100
        else if ((size_of_belt >= 1721 && size_of_belt <= 1880))
            output = (number_of_belt / 1214) * 100
        else if ((size_of_belt >= 1905 && size_of_belt <= 2286))
            output = (number_of_belt / 1146) * 100
        else if ((size_of_belt >= 2312 && size_of_belt <= 3048))
            output = (number_of_belt / 1022) * 100
        else if ((size_of_belt >= 3074 && size_of_belt <= 3556))
            output = (number_of_belt / 752) * 100
        else if ((size_of_belt >= 3581 && size_of_belt <= 4013))
            output = (number_of_belt / 707) * 100
        else if ((size_of_belt >= 4039 && size_of_belt <= 4395))
            output = (number_of_belt / 607) * 100
        else if ((size_of_belt >= 4420 && size_of_belt <= 4953))
            output = (number_of_belt / 566) * 100
        else if ((size_of_belt >= 4979 && size_of_belt <= 5359))
            output = (number_of_belt / 525) * 100
        else if ((size_of_belt >= 5360 && size_of_belt <= 6045))
            output = (number_of_belt / 495) * 100
        else if ((size_of_belt >= 6071 && size_of_belt <= 7875))
            output = (number_of_belt / 439) * 100
        else if ((size_of_belt >= 7900 && size_of_belt <= 8890))
            output = (number_of_belt / 349) * 100
        else if ((size_of_belt >= 8915 && size_of_belt <= 10160))
            output = (number_of_belt / 305) * 100
        else if ((size_of_belt >= 10185 && size_of_belt <= 15240))
            output = (number_of_belt / 248) * 100
        dialog = dialog+("%.2f".format(output))+"   "
        return output
    }
    private fun FindResultINCH(): Float {
        var output: Float = 0.0f
        if ((size_of_belt >= 18 && size_of_belt <= 26))
            output = (number_of_belt / 1034) * 100
        else if ((size_of_belt >= 27 && size_of_belt <= 34))
            output = (number_of_belt / 1292) * 100
        else if ((size_of_belt >= 35 && size_of_belt <= 40))
            output = (number_of_belt / 1292) * 100
        else if ((size_of_belt >= 41 && size_of_belt <= 50))
            output = (number_of_belt / 1240) * 100
        else if ((size_of_belt >= 51 && size_of_belt <= 60))
            output = (number_of_belt / 1230) * 100
        else if ((size_of_belt >= 61 && size_of_belt <= 67))
            output = (number_of_belt / 1258) * 100
        else if ((size_of_belt >= 68 && size_of_belt <= 74))
            output = (number_of_belt / 1214) * 100
        else if ((size_of_belt >= 75 && size_of_belt <= 90))
            output = (number_of_belt / 1146) * 100
        else if ((size_of_belt >= 91 && size_of_belt <= 120))
            output = (number_of_belt / 1022) * 100
        else if ((size_of_belt >= 121 && size_of_belt <= 140))
            output = (number_of_belt / 752) * 100
        else if ((size_of_belt >= 141 && size_of_belt <= 158))
            output = (number_of_belt / 707) * 100
        else if ((size_of_belt >= 159 && size_of_belt <= 173))
            output = (number_of_belt / 607) * 100
        else if ((size_of_belt >= 174 && size_of_belt <= 195))
            output = (number_of_belt / 566) * 100
        else if ((size_of_belt >= 196 && size_of_belt <= 210))
            output = (number_of_belt / 525) * 100
        else if ((size_of_belt >= 211 && size_of_belt <= 238))
            output = (number_of_belt / 495) * 100
        else if ((size_of_belt >= 239 && size_of_belt <= 310))
            output = (number_of_belt / 439) * 100
        else if ((size_of_belt >= 311 && size_of_belt <= 350))
            output = (number_of_belt / 349) * 100
        else if ((size_of_belt >= 351 && size_of_belt <= 400))
            output = (number_of_belt / 305) * 100
        else if ((size_of_belt >= 401 && size_of_belt <= 600))
            output = (number_of_belt / 248) * 100
        dialog = dialog+output.toString()+"    "
        return output
    }
}

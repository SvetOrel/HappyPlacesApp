package com.example.happyplaces

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.text.SimpleDateFormat
import com.example.happyplaces.databinding.ActivityAddHappyPlaceBinding
import java.util.*

class AddHappyPlaceActivity : AppCompatActivity() {
    private var binding: ActivityAddHappyPlaceBinding? = null
    //private var cal = Calendar.getInstance()
    //private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddHappyPlaceBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarAddPlace)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Add Happy Place"
       }

        binding?.toolbarAddPlace?.setNavigationOnClickListener {
           onBackPressed()
        }

//        dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
//                cal.set(Calendar.YEAR, year)
//                cal.set(Calendar.MONTH, monthOfYear)
//                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//
//                // TODO(Step 9 : Called a function as updateDateInView where after selecting a date from date picker is populated in the UI component.)
//                // START
//                updateDateInView()
//                // END
//            }
        // END

//        // TODO(Step 6 : We have extended the onClickListener above and the override method as onClick added and here we are setting a listener to date edittext.)
//        // START
//        binding?.etDate?.setOnClickListener(this)
//        // END
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
//
//    // TODO(Step 5 : This is a override method after extending the onclick listener interface.)
//    // START
//    override fun onClick(v: View?) {
//        when (v!!.id) {
//            // TODO(Step 7 : Launching the datepicker dialog on click of date edittext.)
//            // START
//            R.id.etDate -> {
//                DatePickerDialog(
//                    this@AddHappyPlaceActivity,
//                    dateSetListener, // This is the variable which have created globally and initialized in setupUI method.
//                    // set DatePickerDialog to point to today's date when it loads up
//                    cal.get(Calendar.YEAR), // Here the cal instance is created globally and used everywhere in the class where it is required.
//                    cal.get(Calendar.MONTH),
//                    cal.get(Calendar.DAY_OF_MONTH)
//                ).show()
//            }
//            // END
//        }
//    }
//    // END
//
//    // TODO(Step 8 : Created a function as updateDateInView where after selecting a date from date picker is populated in the UI component.)
//    // START
//    /**
//     * A function to update the selected date in the UI with selected format.
//     * This function is created because every time we don't need to add format which we have added here to show it in the UI.
//     */
//    private fun updateDateInView() {
//        val myFormat = "dd.MM.yyyy" // mention the format you need
//        val sdf = SimpleDateFormat(myFormat, Locale.getDefault()) // A date format
//        binding?.etDate?.setText(sdf.format(cal.time).toString()) // A selected date using format which we have used is set to the UI.
//    }
//    // END
}
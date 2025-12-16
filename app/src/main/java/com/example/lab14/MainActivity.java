package com.example.lab14;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioMale, radioFemale;
    CheckBox coding, design, gaming;
    Button btnDate, btnTime, btnSubmit;
    TextView tvSelectedDate, tvSelectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LIFECYCLE", "onCreate");
        setContentView(R.layout.activity_main);

        // Initialize Views
        radioGroup = findViewById(R.id.radioGroup);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        coding = findViewById(R.id.checkCoding);
        design = findViewById(R.id.checkDesign);
        gaming = findViewById(R.id.checkGaming);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvSelectedDate = findViewById(R.id.tvSelectedDate);
        tvSelectedTime = findViewById(R.id.tvSelectedTime);

        // Button Listeners
        btnDate.setOnClickListener(v -> showDatePicker());
        btnTime.setOnClickListener(v -> showTimePicker());
        btnSubmit.setOnClickListener(v -> showSubmitDialog());
    }

    // Date Picker
    private void showDatePicker() {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(this,
                (view, year, month, day) -> {
                    String selectedDate = day + "/" + (month + 1) + "/" + year;
                    tvSelectedDate.setText("Selected Date: " + selectedDate);
                },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)).show();
    }

    // Time Picker
    private void showTimePicker() {
        Calendar c = Calendar.getInstance();
        new TimePickerDialog(this,
                (view, hour, minute) -> {
                    String selectedTime = String.format("%02d:%02d", hour, minute);
                    tvSelectedTime.setText("Selected Time: " + selectedTime);
                },
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                true).show();
    }

    // Submit Button Dialog
    private void showSubmitDialog() {
        String gender = "";
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.radioMale) gender = "Male";
        else if (selectedId == R.id.radioFemale) gender = "Female";

        StringBuilder interests = new StringBuilder();
        if (coding.isChecked()) interests.append("Coding ");
        if (design.isChecked()) interests.append("Design ");
        if (gaming.isChecked()) interests.append("Gaming ");

        String message = "Gender: " + gender +
                "\nInterests: " + interests.toString() +
                "\n" + tvSelectedDate.getText() +
                "\n" + tvSelectedTime.getText();

        new MaterialAlertDialogBuilder(this)
                .setTitle("Submitted!")
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // Back Press Gesture
    @Override
    public void onBackPressed() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // Activity Lifecycle Logging
    @Override protected void onStart() { super.onStart(); Log.d("LIFECYCLE","onStart"); }
    @Override protected void onResume() { super.onResume(); Log.d("LIFECYCLE","onResume"); }
    @Override protected void onPause() { super.onPause(); Log.d("LIFECYCLE","onPause"); }
    @Override protected void onStop() { super.onStop(); Log.d("LIFECYCLE","onStop"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d("LIFECYCLE","onDestroy"); }
}

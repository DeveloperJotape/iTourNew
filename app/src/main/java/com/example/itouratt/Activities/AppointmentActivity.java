package com.example.itouratt.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.itouratt.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AppointmentActivity extends AppCompatActivity {
    private int passengers = 1;
    private ImageView btnPlus, btnMinus, btnDeparture, btnReturn;
    private TextView travelPassengers, departureDate, returnDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM, yyyy", Locale.ENGLISH);
    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_appointment);

        initPassengers();
        initDatePickup();
        setVariable();
    }

    private void initDatePickup() {
        departureDate = findViewById(R.id.departureDate);
        returnDate = findViewById(R.id.returnDate);
        btnDeparture = findViewById(R.id.btnDeparture);
        btnReturn = findViewById(R.id.btnReturn);

        Calendar calendarToday = Calendar.getInstance();
        String currentDate = dateFormat.format(calendarToday.getTime());
        departureDate.setText(currentDate);

        Calendar calendarTomorrow = Calendar.getInstance();
        calendarTomorrow.add(Calendar.DAY_OF_YEAR, 1);
        String tomorrowDate = dateFormat.format(calendarTomorrow.getTime());
        returnDate.setText(tomorrowDate);

        btnDeparture.setOnClickListener(view -> {
            showDatePickerDialog(departureDate);
        });

        btnReturn.setOnClickListener(view -> {
            showDatePickerDialog(returnDate);
        });

    }

    private void initPassengers() {
        travelPassengers = findViewById(R.id.travelPassengers);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passengers < 5) {
                    passengers++;
                    travelPassengers.setText(Integer.toString(passengers));
                }

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passengers > 1){
                    passengers--;
                    travelPassengers.setText(Integer.toString(passengers));
                }
            }
        });

    }

    private void setVariable(){
        ConstraintLayout btnConfirmAppointment = findViewById(R.id.btnConfirmAppointment);
        btnConfirmAppointment.setOnClickListener(view -> {
            Intent in = new Intent(AppointmentActivity.this, TicketsActivity.class);
            in.putExtra("date", departureDate.getText().toString());
            in.putExtra("numPassengers", passengers);
            startActivity(in);
        });
    }

    private void showDatePickerDialog(TextView textView) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
            calendar.set(selectedYear, selectedMonth, selectedDay);
            String formattedDate = dateFormat.format(calendar.getTime());
            textView.setText(formattedDate);
        }, year, month, day);
        datePickerDialog.show();
    }

    public void detailsActivity(View view) {
        Intent in = new Intent(AppointmentActivity.this, DetailsActivity.class);
        startActivity(in);
    }

}

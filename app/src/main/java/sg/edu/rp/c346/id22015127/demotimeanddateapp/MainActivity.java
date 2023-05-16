package sg.edu.rp.c346.id22015127.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp = findViewById(R.id.timePicker);
        dp = findViewById(R.id.datePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                if (min < 10) {
                    tvDisplay.setText("Time is " + hour + " : " + "0" + min);
                } else {
                    tvDisplay.setText("Time is " + hour + " : " + min);
                }
            }
        });
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int d = dp.getDayOfMonth();
                int m = dp.getMonth() + 1;
                int y = dp.getYear();
                tvDisplay.setText("Date is " + d + "/" + m + "/"+ y);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020, 0, 1);
                tvDisplay.setText("");
            }
        });
    }
}
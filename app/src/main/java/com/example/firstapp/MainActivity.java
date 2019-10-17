package com.example.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.firstapp.models.NumberClass;
import com.example.firstapp.viewmodels.NumberViewModel;

public class MainActivity extends AppCompatActivity {

    TextView main_Text;

    Button button_increase;
    Button button_decrease;

    NumberViewModel mNumberViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_Text = (TextView) findViewById(R.id.TViewNumber);

        mNumberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        mNumberViewModel.init();

        mNumberViewModel.getNumber().observe(this, new Observer<NumberClass>() {
            @Override
            public void onChanged(@Nullable NumberClass number) {
                String s = String.valueOf(number.GetNumber());
                main_Text.setText(s);
            }
        });

        button_increase = (Button) findViewById(R.id.btnIncrease);
        button_increase.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mNumberViewModel.changeValueBy(1);
            }
        });

        button_decrease = (Button) findViewById(R.id.btnDecrease);
        button_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mNumberViewModel.changeValueBy(-1);
            }
        });
    }

    void updateText(String s)
    {
        main_Text.setText(s);
    }
}

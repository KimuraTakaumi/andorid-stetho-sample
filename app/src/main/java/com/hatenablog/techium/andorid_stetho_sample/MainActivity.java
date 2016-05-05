package com.hatenablog.techium.andorid_stetho_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.click);
        button.setOnClickListener(mListener);
        button = (Button) findViewById(R.id.clear);
        button.setOnClickListener(mListener);
    }

    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ClickManager clickManager = ClickManager.getInstance();

            switch(view.getId()){
                case R.id.click:
                    clickManager.click();
                    break;
                case R.id.clear:
                    clickManager.clear();
                    break;
            }
        }
    };
}

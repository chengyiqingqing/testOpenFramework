package com.meitu.testbutterknife;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author shaowenwen
 * @Date 2020-09-01 21:33
 */
public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.text_view)
    TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.text_view)).setText("haha");

    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);

    }

}

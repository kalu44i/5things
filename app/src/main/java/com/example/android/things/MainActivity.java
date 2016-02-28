package com.example.android.things;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    Map<String, Boolean> answers = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    public void clickYes(View view) {
        setContentView(R.layout.activity_first);
        answers = new HashMap<>();
        answers.put("Stop", true);
        answers.put("Unsop", false);
        answers.put("Unsop1", false);
        answers.put("Unsop2", false);
        String question = "testQuestion";
        String info = "testInfo";
        Page page = new Page(question, info, answers);

        TextView q = (TextView) findViewById(R.id.first_question);
        q.setText(page.getQuestion());
        RadioButton rb1 = (RadioButton) findViewById(R.id.ans1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.ans2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.ans3);
        RadioButton rb4 = (RadioButton) findViewById(R.id.ans4);
        List<RadioButton> rbs = new ArrayList<>();
        rbs.add(rb1);
        rbs.add(rb2);
        rbs.add(rb3);
        rbs.add(rb4);

        int i = 0;
        for (Map.Entry<String, Boolean> entry : answers.entrySet()) {
            rbs.get(i).setText(entry.getKey());
            i++;
        }
    }

    public void submit(View view) {
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton)radioGroup.findViewById(radioButtonID);
        CharSequence text = radioButton.getText();
        boolean isTrue = answers.get(text);
        TextView textView = (TextView) findViewById(R.id.wrong_alert);
        if (isTrue) {
            textView.setVisibility(View.VISIBLE);
            textView.setText("Right");
            textView.setTextColor(Color.GREEN);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText("Wrong answer");
            textView.setTextColor(Color.RED);
        }

    }

}

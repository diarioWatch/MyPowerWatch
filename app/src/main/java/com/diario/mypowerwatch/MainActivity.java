package com.diario.mypowerwatch;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.lang.Integer;

import java.util.List;
import java.util.ArrayList;
//Read more: http://mrbool.com/making-a-jtable-in-swing-using-java/24918#ixzz4E3El0tXX

public class MainActivity extends WearableActivity {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private BoxInsetLayout mContainerView;
    private TextView mTextView;
    private TextView mClockView;
    private ImageButton mButton1;
    private ImageButton mButton2;
    private ImageButton mButton3;
    private ImageButton mButton4;

    String[] columnNames = {"QuestionID",
            "Asked Time",
            "Answered Time",
            "Answer"};


    List<Object> answerList = new ArrayList<Object>();

    //Object[][] data = {};
    //JTable answerTable = new JTable(data, columnNames);
    //JTable answerTable = new JTable(new DefaultTableModel(new Object[]
    //        {"QuestionID", "Asked Time", "Answered Time", "Answer"}));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        mClockView = (TextView) findViewById(R.id.clock);
        mButton1 = (ImageButton) findViewById(R.id.button1);
        mButton2 = (ImageButton) findViewById(R.id.button2);
        mButton3 = (ImageButton) findViewById(R.id.button3);
        mButton4 = (ImageButton) findViewById(R.id.button4);
    }


    public void questionAnswer1(View view) {
        //mButtonGood.setVisibility(View.GONE);
        //mTextView.setText("@string/Question2_TeacherFeeling");
        recordData(1);
        questionChange();
    }

    public void questionAnswer2(View view) {
        //mButtonGood.setVisibility(View.GONE);
        //mTextView.setText("@string/Question2_TeacherFeeling");
        recordData(2);
        questionChange();
    }

    public void questionAnswer3(View view) {
        //mButtonGood.setVisibility(View.GONE);
        //mTextView.setText("@string/Question2_TeacherFeeling");
        recordData(3);
        questionChange();
    }

    public void questionAnswer4(View view) {
        //mButtonGood.setVisibility(View.GONE);
        //mTextView.setText("@string/Question2_TeacherFeeling");
        recordData(4);
        questionChange();
    }

    public void recordData(int answer) {
        if(mTextView.getText().equals(getText(R.string.Question1_HowAreYou))) {
            //DefaultTableModel model = (DefaultTableModel) answerTable.getModel();
            Object[] newData = new Object[]{new Integer(1), new Integer(111),new Integer(222),new Integer(answer)};
            answerList.add(newData);
        }
        else if (mTextView.getText().equals(getText(R.string.Question2_TeacherFeeling))) {
            //DefaultTableModel model = (DefaultTableModel) answerTable.getModel();
            Object[] newData = new Object[]{new Integer(2), new Integer(111),new Integer(222),new Integer(answer)};
            answerList.add(newData);
        }
        else if (mTextView.getText().equals(getText(R.string.Question3_BodyFeeling))) {
            //DefaultTableModel model = (DefaultTableModel) answerTable.getModel();
            Object[] newData = new Object[]{new Integer(3), new Integer(111),new Integer(222),new Integer(answer)};
            answerList.add(newData);
        }
        else if (mTextView.getText().equals(getText(R.string.Question4_StressFeeling))) {
            //DefaultTableModel model = (DefaultTableModel) answerTable.getModel();
            Object[] newData = new Object[]{new Integer(4), new Integer(111),new Integer(222),new Integer(answer)};
            answerList.add(newData);
        }

    }
    public void questionChange(){

        if(mTextView.getText().equals(getText(R.string.Question1_HowAreYou))) {
            mTextView.setText(getApplicationContext().getText(R.string.Question2_TeacherFeeling));
        }
        else if (mTextView.getText().equals(getText(R.string.Question2_TeacherFeeling))) {
            mTextView.setText(getApplicationContext().getText(R.string.Question3_BodyFeeling));
            //mButton1.setText("Tired");
            //mButton2.setText("Awake");
            //mButton3.setText("ToRun");
            //mButton4.setText("ToFlip");
        }
        else if (mTextView.getText().equals(getText(R.string.Question3_BodyFeeling))) {
            mTextView.setText(getApplicationContext().getText(R.string.Question4_StressFeeling));
            //mButton1.setText("relaxed");
            //mButton2.setText("Tense");
            //mButton3.setText("Stressed");
            //mButton4.setText("strsOut");
        }

    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));
            mClockView.setVisibility(View.VISIBLE);

            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));
            mClockView.setVisibility(View.GONE);
        }
    }
}

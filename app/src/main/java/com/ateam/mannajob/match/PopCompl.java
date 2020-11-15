package com.ateam.mannajob.match;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ateam.mannajob.R;

public class PopCompl extends Activity {
    TextView compl_id;
    RadioGroup compl_radio_group;
    RadioButton complA;
    RadioButton complB;
    RadioButton complC;
    RadioButton complD;
    RadioButton complE;
    EditText complE_txt;
    Button compl_ok_btn;
    Button compl_cancel_btn;
    String compl_contents;
    String m_id;
    String b_num;
    int etc_chk = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_pop_compl);
        UiInit();

        compl_radio_group.setOnCheckedChangeListener(groupClickListener);
        Intent intent = getIntent();
        b_num = intent.getExtras().getString("b_num");
        m_id = intent.getExtras().getString("m_id");

        compl_id.setText(m_id);
        compl_ok_btn.setOnClickListener(v -> {
            if(etc_chk ==1){
                compl_contents = complE_txt.getText().toString();
                if(compl_contents.equals("")) {
                    Log.d("선택한 내용 :", "입력내용이 없습니다.");
                }else {
                    Log.d("선택한 내용 :", compl_contents);
                }
            }else {
                Log.d("선택한 내용 :", compl_contents);
            }
        });
        compl_cancel_btn.setOnClickListener(v -> {
            finish();
        });

    }

    private void UiInit(){
        compl_id = findViewById(R.id.complID);
        compl_radio_group = findViewById(R.id.compl_radio_group);
        complA = findViewById(R.id.complA);
        complB = findViewById(R.id.complB);
        complC = findViewById(R.id.complC);
        complD = findViewById(R.id.complD);
        complE = findViewById(R.id.complE);
        complE_txt = findViewById(R.id.complE_txt);
        compl_ok_btn = findViewById(R.id.compl_ok_btn);
        compl_cancel_btn =findViewById(R.id.compl_cancel_btn);
        compl_contents = complA.getText().toString();

    }
    RadioGroup.OnCheckedChangeListener groupClickListener = new RadioGroup.OnCheckedChangeListener() {
        @Override public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i == R.id.complA){
                compl_contents = complA.getText().toString();
                complE_txt.setVisibility(View.GONE);
                etc_chk = 0;
            } else if(i == R.id.complB){
                compl_contents = complB.getText().toString();
                complE_txt.setVisibility(View.GONE);
                etc_chk = 0;
            } else if(i == R.id.complC){
                compl_contents = complC.getText().toString();
                complE_txt.setVisibility(View.GONE);
                etc_chk = 0;
            } else if(i == R.id.complD){
                compl_contents = complD.getText().toString();
                complE_txt.setVisibility(View.GONE);
                etc_chk = 0;
            } else if(i == R.id.complE){
                etc_chk = 1;
                complE_txt.setVisibility(View.VISIBLE);
            }
        }
    };



}
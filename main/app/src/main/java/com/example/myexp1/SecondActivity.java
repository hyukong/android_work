package com.example.myexp1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sec_lay);

        Button button=(Button)findViewById(R.id.call);
        Button button2=(Button)findViewById(R.id.ob);
        Button button3=(Button)findViewById(R.id.tolast);
        Button button4=(Button)findViewById(R.id.test);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intcall=new Intent(Intent.ACTION_DIAL);
                startActivity(intcall);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.baidu.com");
                Intent ob=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(ob);

            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SecondActivity.this,FirstAct.class);
                intent.putExtra("data_return", "This data from buttonTolast！"); //暂存数据
                setResult(RESULT_OK, intent);
                finish();
                startActivity(intent);
            }});

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello FirstA");
                setResult(RESULT_OK, intent);
                finish();
            }});

    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_return", "onBackpressed");
        setResult(RESULT_OK, intent);
        finish();
    }

}

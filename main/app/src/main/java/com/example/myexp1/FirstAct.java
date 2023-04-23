package com.example.myexp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstAct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_lay);
        Button button1 = (Button) findViewById(R.id.button_1);//按钮对象
        Button button2 = (Button) findViewById(R.id.button_2);//按钮对象
        Button button3 = (Button) findViewById(R.id.button_3);//按钮对象
        Button button4 = (Button) findViewById(R.id.button_4);//按钮对象
        Button button5 = (Button) findViewById(R.id.button_5);//按钮对象

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstAct.this, "you click 显式", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(FirstAct.this,SecondActivity.class);//构建intent传入上下文和目标活动
                startActivity(intent);//显性intent
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstAct.this, "you click 隐式", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent("com.example.activitytest.ACTION_START");
                startActivity(intent2);//隐性intent
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstAct.this, "you click 数据传递", Toast.LENGTH_SHORT).show();
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstAct.this, SecondActivity.class);
                intent.putExtra("extra_data", data);//第一个参数是键，用于后面从Intent中取值，第二个参数才是真正要传递的数据
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                //获取暂存数据
                String datalast=intent.getStringExtra("data_return");
                Toast.makeText(FirstAct.this, "data:"+datalast, Toast.LENGTH_SHORT).show();

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstAct.this, DataAct.class);
                startActivityForResult(intent, 1);//请求码只要是一个唯一值就行


            }
        });

    }


        public boolean onCreatOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.main, menu);
            return true;

        }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
            default:
        }
        return true;}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){//第一个参数为启动活动时传入的请求码，第二个参数为返回数据是传入的处理结果，第三个参数为携带返回数据的Intent
        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);}
                break;
            default:
        }
    }






}

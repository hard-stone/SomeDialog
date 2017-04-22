package com.example.administrator.newclockproj;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.common.design.MaterialDialog;

/*
* Gradle引用方法

dependencies {
   compile 'com.android.design:MaterialDialog:1.0.2'
}*/
public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {

    MaterialDialog materialDialog;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
                dialog2.setTitle("列表选择对话框");
                //    指定下拉列表的显示数据
                final String[] cities = {"开灯", "关灯"};
                //    设置一个下拉的列表选择项
                dialog2.setItems(cities, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "选择的操作：" +
                                cities[which], Toast.LENGTH_SHORT).show();
                    }
                });
                dialog2.show();
                break;
            case R.id.button2:
                //Alter是Dialog的一个直接子类，不能通过它的构造函数直接创造一个AlterDialog，
                //要通过AlterDialog.Builder；
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("AlertDialog");
                dialog.setMessage("android.support.v7.app.AlertDialog 的dialog");
                dialog.setCancelable(false);//可以取消对话框，false不能
                dialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "点击确定",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "点击取消",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setIcon(R.drawable.cool);//添加图片
                dialog.setView(R.layout.dialog_test);//可以加入布局
                dialog.setNeutralButton("第三个按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "点击setNeutralButton",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;
            case R.id.button3:
                //ProgressDialog是Dialog的一个子类。是可以通过构造函数直接得到的。
                //通过调用dismiss()方法控制progressDialog的消失；
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("ProgressDialog");
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.button4:
                /*
            *   Gradle引用方法
                dependencies {
                   compile 'com.android.design:MaterialDialog:1.0.2'
                }*/
                final String[] item3 = {"开灯", "关灯"};
                new MaterialDialog.Builder(this)
                        .setTitle("单选框")
                        .setSingleChoiceItems(item3, 2, new MaterialDialog.OnClickListener() {
                            @Override
                            public boolean onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), item3[which], Toast.LENGTH_SHORT).show();
                                return true;
                            }
                        }).setPositiveButton("确定", null)
                        .setNegativeButton("取消", null)
                        .setNeutralButton("不在提示", null).show();
                break;
        }
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
}

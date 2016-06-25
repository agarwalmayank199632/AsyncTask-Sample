package com.mayank.asynctasktry;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText,editText2;
    String name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);

    }

    public void onClick1(View view)
    {
        name = editText.getText().toString();
        pass = editText2.getText().toString();
        new AsyncTry().execute(name,pass);
    }

    public class AsyncTry extends AsyncTask<String,String,String>
    {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Connecting");
            progressDialog.setCancelable(true);
        }

        @Override
        protected String doInBackground(String... params) {

            String name = params[0];
            String pass = params[1];
            if(name.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin"))
            {
             return String.valueOf(1);
            }
            else
            {
                return String.valueOf(0);
            }
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            if(Integer.parseInt(result)==1)
            {
                Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        }
    }

}
package com.example.interam.veteransfinance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MainActivity extends Activity {

    private Button mGIBillInfoButton;
    private Spinner mUniversities;
    private TextView mZip;
    private TextView mBAH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGIBillInfoButton = (Button) findViewById(R.id.GIBillInfo_button);
        mGIBillInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_info = new Intent(MainActivity.this, SecondScreen.class);
                startActivity(get_info);
            }
        });

        initializeTextView();

        addItemsToSpinner();

        addListenerToSpinner();
    }

    public void addItemsToSpinner(){

        mUniversities = (Spinner) findViewById(R.id.Uni_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.university_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mUniversities.setAdapter(adapter);
    }

    public void addListenerToSpinner(){

        mUniversities = (Spinner) findViewById(R.id.Uni_spinner);
        mUniversities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateZipCode(position);
                updateBAH(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void initializeTextView(){
        mZip = (TextView)findViewById(R.id.zipcodeInfo);
        mBAH = (TextView)findViewById(R.id.BAH_Info);

    }
    public void updateZipCode(int pos){
        mZip = (TextView)findViewById(R.id.zipcodeInfo);

        String zipCodes[] = {"94720", "95616", "92697","90095", "95343", "92521","92093","93106"};

        mZip.setText(zipCodes[pos]);
    }

    public void updateBAH(int pos){
        mBAH = (TextView)findViewById(R.id.BAH_Info);

        String BAH[] = {"3132.00", "1701.00", "2433.00","2433.00", "1323.00", "1863.00","2325.00","2079.00"};
        mBAH.setText(BAH[pos]);

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
        } else if (id == R.id.exit_app) {

            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
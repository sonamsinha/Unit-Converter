package sonamsinha.unitconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText temp;
    String recievedValue;
    Spinner spinner;
    Spinner valueSpinner;
    TextView view1;
    TextView view2;
    TextView view3;
    TextView view4;

    DropdownListener dropDown = new DropdownListener();
    ItemDropdownListener itemDropdown = new ItemDropdownListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dropDown.setActivity(this);
        itemDropdown.setActivity(this);
        temp = (EditText) findViewById(R.id.temperatureEditText);
        spinner = (Spinner) findViewById(R.id.converterSpinner);
        valueSpinner = (Spinner) findViewById(R.id.valuesSpinner);
        spinner.setOnItemSelectedListener(dropDown);
        valueSpinner.setOnItemSelectedListener(itemDropdown);
        view1 = (TextView)findViewById(R.id.textView1);
        view2 = (TextView)findViewById(R.id.textView2);
        view3 = (TextView)findViewById(R.id.textView3);
        view4 = (TextView)findViewById(R.id.textView4);
        TextView heading = (TextView)findViewById(R.id.selectEditText);
        //heading.setEnabled(false);
        Log.w("Yipee!","Got value "+ recievedValue);

    }

    public String hasChanged(String value) {
        String v = "";
        recievedValue = value;
        //Log.w("Value recieved ", "Hurray " + value);
        if (value.equalsIgnoreCase("Area")) {
            temp.setHint("Enter Area");
            //temp.setText(null);
            resetText();
            dropDownItem("Area");

        }
        if (value.equalsIgnoreCase("Temperature")) {
            temp.setHint("Enter Temperature");
            //temp.setText(null);
            resetText();
            dropDownItem("Temperature");
        }
        if (value.equalsIgnoreCase("Length")) {
            temp.setHint("Enter Length");
            //temp.setText(null);
            resetText();
            dropDownItem("Length");
        }
        return v;
    }

    public void dropDownItem(String recievedValue) {
        List<String> tempOptions = new ArrayList<String>();
        List<String> areaOptions = new ArrayList<String>();
        List<String> lengthOptions = new ArrayList<String>();

        tempOptions.add("Fahrenheit");
        tempOptions.add("Celsius");

        areaOptions.add("Square meters");
        areaOptions.add("Square feets");

        lengthOptions.add("Feets");
        lengthOptions.add("Miles");
        lengthOptions.add("Yards");
        lengthOptions.add("Meters");

        if(recievedValue == null)
        {

            ArrayAdapter<CharSequence> adapterTemperature = ArrayAdapter.createFromResource(this, R.array.tempConversion, android.R.layout.simple_spinner_item);
            adapterTemperature.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            valueSpinner.setAdapter(adapterTemperature);
        }

        if (recievedValue.equalsIgnoreCase("Temperature")) {

            ArrayAdapter<CharSequence> adapterTemperature = ArrayAdapter.createFromResource(this, R.array.tempConversion, android.R.layout.simple_spinner_item);
            adapterTemperature.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            valueSpinner.setAdapter(adapterTemperature);
        }

        if (recievedValue.equalsIgnoreCase("Area")) {
            ArrayAdapter<CharSequence> adapterArea = ArrayAdapter.createFromResource(this, R.array.areaConversion, android.R.layout.simple_spinner_item);
            adapterArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            valueSpinner.setAdapter(adapterArea);
        }

        if (recievedValue.equalsIgnoreCase("Length")) {
            ArrayAdapter<CharSequence> adapterLength = ArrayAdapter.createFromResource(this, R.array.lengthConversion, android.R.layout.simple_spinner_item);
            adapterLength.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            valueSpinner.setAdapter(adapterLength);
        }


    }

    public void convert(String itemSelected) {
        Log.w(" Main Activity ", " selected item "+itemSelected);
        if (recievedValue.equalsIgnoreCase("Area")) {
            areaConvert(itemSelected);
        }
        if (recievedValue.equalsIgnoreCase("Temperature")) {
            tempConvert(itemSelected);
        }
        if (recievedValue.equalsIgnoreCase("Length")) {
            lengthConvert(itemSelected);
        }
    }

    public void tempConvert(String itemSelected) {
        if(temp.getText()!= null) {
            if(!temp.getText().toString().isEmpty()){
                double value = Double.valueOf(temp.getText().toString());
                temp.setText(Double.toString(value));
                view1 = (TextView)findViewById(R.id.textView1);
                view2 = (TextView)findViewById(R.id.textView2);

                if(itemSelected.equalsIgnoreCase("Fahrenheit"))
                {
                    value = UnitConverter.fahrenheit2Celsius(value);
                    view1.setText(Double.toString(value)+ "  C");
                    view2.setText((temp.getText().toString())+ "  F");
                }
                if(itemSelected.equalsIgnoreCase("Celsius"))
                {
                    value = UnitConverter.celsius2Fahrenheit(value);
                    view1.setText(Double.toString(value)+ "  F");
                    view2.setText((temp.getText().toString())+ "  C");
                }
            }
        }
    }

    public void areaConvert(String itemSelected) {
        if(temp.getText()!= null)
        {
            if(!temp.getText().toString().isEmpty()) {
                double value = Double.valueOf(temp.getText().toString());
                temp.setText(Double.toString(value));

                view1 = (TextView)findViewById(R.id.textView1);
                view2 = (TextView)findViewById(R.id.textView2);
                Log.w(" Sds ", " Selected "+itemSelected);
                if (itemSelected.equalsIgnoreCase(("Square meters")))
                {
                    value = UnitConverter.sqMeter2sqFeet(value);
                    view1.setText(Double.toString(value)+ "  Sqft");
                    view2.setText((temp.getText().toString())+ "  Sqmt");
                }
                if (itemSelected.equalsIgnoreCase(("Square feet")))
                {
                    value = UnitConverter.sqFeet2sqMeter(value);
                    view1.setText(Double.toString(value)+ "  Sqmt");
                    view2.setText((temp.getText().toString())+ "  Sqft");
                }
            }
        }
    }

    public void lengthConvert(String itemSelected) {
        if(temp.getText()!= null)
        {
            if(!temp.getText().toString().isEmpty()){
                double value = Double.valueOf(temp.getText().toString());
                temp.setText(Double.toString(value));




                if (itemSelected.equalsIgnoreCase(("Meters"))) {
                    double mt1= UnitConverter.meters2Feet(value);
                    double mt2= UnitConverter.meters2Miles(value);
                    double mt3= UnitConverter.meters2Yards(value);
                    view1.setText(Double.toString(mt1) + "  Feet");
                    view2.setText(Double.toString(mt2) + "  Miles");
                    view3.setText(Double.toString(mt3) + "  Yards");
                    view4.setText(temp.getText().toString()+ "  Meters");
                }
                if (itemSelected.equalsIgnoreCase(("Feet"))) {
                    double ft1= UnitConverter.feet2Meters(value);
                    double ft2= UnitConverter.feet2Miles(value);
                    double ft3= UnitConverter.feet2Yards(value);
                    view1.setText(Double.toString(ft1) + "  Meters");
                    view2.setText(Double.toString(ft2) + "  Miles");
                    view3.setText(Double.toString(ft3) + "  Yards");
                    view4.setText(temp.getText().toString()+ "  Feet");
                }

                if (itemSelected.equalsIgnoreCase(("Miles"))) {
                    double mi1= UnitConverter.miles2Meters(value);
                    double mi2= UnitConverter.miles2Feet(value);
                    double mi3= UnitConverter.miles2Yards(value);
                    view1.setText(Double.toString(mi1) + " Meters");
                    view2.setText(Double.toString(mi2) + " Feet");
                    view3.setText(Double.toString(mi3) + " Yards");
                    view4.setText(temp.getText().toString() +" Miles" );
                }

                if (itemSelected.equalsIgnoreCase(("Yards"))) {
                    double yd1= UnitConverter.yards2Meters(value);
                    double yd2= UnitConverter.yards2Feet(value);
                    double yd3= UnitConverter.yards2Miles(value);
                    view1.setText(Double.toString(yd1) + "  Meters");
                    view2.setText(Double.toString(yd2) + "  Feet");
                    view3.setText(Double.toString(yd3) + "  Miles");
                    view4.setText(temp.getText().toString() +"  Yards" );
                }

            }
        }
    }

    public void resetText(){
        temp.setText(null);
        view1.setText(null);
        view2.setText(null);
        view3.setText(null);
        view4.setText(null);

    }


}

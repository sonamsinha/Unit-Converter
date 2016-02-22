package sonamsinha.unitconverter;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by sonamsinha on 2/11/16.
 */
class ItemDropdownListener implements AdapterView.OnItemSelectedListener {

    private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String valueSelected = (String)parent.getItemAtPosition(position);
        //Log.w("Dropdownlistener", "Got the value " + valueSelected);
        ((MainActivity)getActivity()).convert(valueSelected);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

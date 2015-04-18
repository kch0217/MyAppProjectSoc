package drive.app.ken.socialable;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import drive.app.ken.socialable.User.UserModel;


public class SearchMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);

        ImageButton setting = (ImageButton) findViewById(R.id.SettingButton);
        setting.setOnClickListener(new pressListener());

        Spinner spinner = (Spinner) findViewById(R.id.SearchInterestSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.interest_array, R.layout.spinner_layout);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        // Set default value of spinner
        spinner.setSelection(((ArrayAdapter)spinner.getAdapter()).getPosition(UserModel.getUserModel().getInterest()));




    }

    public class pressListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.SettingButton){
                Log.i(null, "Setting Button is clicked");
                Intent intent = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent);

            }
        }
    }




}

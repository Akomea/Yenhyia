package ghsoft.yenhyia_chatmeetdating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.sign_out_button:
                // User chose the "Settings" item, show the app settings UI...
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(this, PhoneAuthActivity.class);
                startActivity(intent);
                return true;
            case R.id.set:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent set_intent = new Intent(this, SettingsActivity.class);
                startActivity(set_intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}

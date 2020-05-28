package sg.edu.rp.c346.s19040010.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btnDBS, btnOCBC, btnUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"English");
        menu.add(0,3,3,"Chinese");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId()==0) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intent);
        }

        else {

            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800-111-1111"));
            startActivity(intentCall);

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.textViewTranslatedText) {
            tv.setText("English ");
            return true;
        } else if (id == R.id.textViewTranslatedText2) {
            tv.setText("Chinese");
            return true;
        } else {
            tv.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }



}

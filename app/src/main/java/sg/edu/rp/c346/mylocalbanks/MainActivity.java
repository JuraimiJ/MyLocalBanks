package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    Integer view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        view = v.getId();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == 0 && (view == R.id.textViewDBS)) { //check whether the selected menu item ID is 0
            //code for action
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intentWeb);

            return true; //menu item successfully handled
        } else if (item.getItemId() == 1 && (view == R.id.textViewDBS)) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001 + 111111));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        } else if (item.getItemId() == 0 && (view == R.id.textViewOCBC)) { //check if the selected menu item ID is 1
            //            //code for action
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(intentWeb);

            return true;
        } else if (item.getItemId() == 1 && (view == R.id.textViewOCBC)) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18003 + 633333));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        } else if (item.getItemId() == 0 && (view == R.id.textViewUOB)) { //check if the selected menu item ID is 1
            //code for action
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(intentWeb);

            return true;
        } else if (item.getItemId() == 1 && (view == R.id.textViewUOB)) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18002 + 222121));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        }else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

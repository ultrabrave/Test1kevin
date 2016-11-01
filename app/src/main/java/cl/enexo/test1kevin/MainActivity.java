package cl.enexo.test1kevin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String hour;
    private String food;
    private String km;
    private String color;
    private RadioGroup rghour;
    private RadioGroup rgfood;
    private RadioGroup rgkm;
    private RadioGroup rgcolor;
    private Button btn;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try
        {

            rghour = (RadioGroup) findViewById(R.id.rg_hour);
            rgfood = (RadioGroup) findViewById(R.id.rg_food);
            rgkm = (RadioGroup) findViewById(R.id.rg_vel);
            rgcolor = (RadioGroup) findViewById(R.id.rg_color);
            btn = (Button) findViewById(R.id.btnresultado);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    msg = "";
                    if (rghour.getCheckedRadioButtonId() == -1) {
                        msg = "Debe seleccionar lo siguiente:";
                        msg = msg + " \n Hora del día";
                    }
                    else if(rghour.getCheckedRadioButtonId() == 1)
                    {
                        hour = "day";
                    }
                    else if (rghour.getCheckedRadioButtonId() == 2)
                    {
                        hour = "night";
                    }

                    if (rgfood.getCheckedRadioButtonId() == -1)
                    {
                        if (msg.equals("")) {
                            msg = "Debe seleccionar lo siguiente:";
                            msg = msg + " \n Comida";
                        } else {
                            msg = msg + " \n Comida";
                        }
                    }
                    else if (rgfood.getCheckedRadioButtonId() == 3)
                    {
                        food = "meet";
                    }
                    else if (rgfood.getCheckedRadioButtonId() == 4)
                    {
                        food = "fruit";
                    }

                    if (rgkm.getCheckedRadioButtonId() == -1)
                    {
                        if (msg.equals("")) {
                            msg = "Debe seleccionar lo siguiente:";
                            msg = msg + " \n Velocidad o lentitud";
                        } else {
                            msg = msg + " \n Velocidad o lentitud";
                        }
                    }
                    else if (rgkm.getCheckedRadioButtonId() == 5)
                    {
                        km = "fast";
                    }
                    else if (rgkm.getCheckedRadioButtonId() == 6)
                    {
                        km = "slow";
                    }

                    if (rgcolor.getCheckedRadioButtonId() == -1)
                    {
                        if (msg.equals("")) {
                            msg = "Debe seleccionar lo siguiente:";
                            msg = msg + " \n Color";
                        } else {
                            msg = msg + " \n Color";
                        }
                    }
                    else if (rgcolor.getCheckedRadioButtonId() == 7)
                    {
                        color = "pink";
                    }
                    else if(rgcolor.getCheckedRadioButtonId() == 9)
                    {
                        color = "black";
                    }

                    if (msg.equals(""))
                    {
                        Intent i =  new Intent(getApplicationContext(),ResultActivity.class);
                        i.putExtra("hour",hour);
                        i.putExtra("food",food);
                        i.putExtra("km",km);
                        i.putExtra("color",color);
                        startActivity(i);
                    }
                    else
                    {
                        mensaje(msg);
                    }
                }
            });
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }


    public void mensaje(String cadena) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(this).create();
        alertDialog.setTitle("Atención:");
        alertDialog.setMessage(cadena);


        alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        //alertDialog.setIcon(R.drawable.ic_launcher);
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {

    }
}

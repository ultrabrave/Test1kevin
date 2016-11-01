package cl.enexo.test1kevin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Kevin on 31-10-2016.
 */
public class ResultActivity extends Activity{
    private String hour,food,km,color;
    private LinearLayout lineacolor;
    private ImageView imagephoto;
    private TextView txttitulo;
    private MediaPlayer mpp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);

        imagephoto = (ImageView) findViewById(R.id.imagephoto);
        lineacolor = (LinearLayout) findViewById(R.id.backgroundimage);
        txttitulo = (TextView) findViewById(R.id.txttitulo);
        hour = getIntent().getStringExtra("hour");
        food = getIntent().getStringExtra("food");
        km = getIntent().getStringExtra("km");
        color = getIntent().getStringExtra("color");

        if (color.equals("pink"))
        {
            lineacolor.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        }
        else
        {
            lineacolor.setBackgroundColor(getResources().getColor(R.color.colorBlack));
        }

        if (hour.equals("day") && food.equals("fruit") && km.equals("fast"))
        {
            mpp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mpp = MediaPlayer.create(ResultActivity.this, R.raw.caballo);
            mpp.setLooping(true);
            mpp.start();
            txttitulo.setText("Eres un Caballo");
            imagephoto.setBackgroundResource(R.drawable.caballo);
        }
        else if (hour.equals("night") && food.equals("fruit") && km.equals("fast"))
        {
            mpp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mpp = MediaPlayer.create(ResultActivity.this, R.raw.mono);
            mpp.setLooping(true);
            mpp.start();
            txttitulo.setText("Eres un mono");
            imagephoto.setBackgroundResource(R.drawable.mono);
        }
        else if (hour.equals("day") && food.equals("meet") && km.equals("fast"))
        {
            mpp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mpp = MediaPlayer.create(ResultActivity.this, R.raw.tigre);
            mpp.setLooping(true);
            mpp.start();
            txttitulo.setText("Eres un Tigre");
            imagephoto.setBackgroundResource(R.drawable.tigre);
        }
        else if (hour.equals("day") && food.equals("fruit") && km.equals("slow"))
        {
            txttitulo.setText("Eres una vaca");
            mpp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mpp = MediaPlayer.create(ResultActivity.this, R.raw.vaca);
            mpp.setLooping(true);
            mpp.start();
            imagephoto.setBackgroundResource(R.drawable.vaca);
        }
        else if (hour.equals("night") && food.equals("fruit") && km.equals("slow"))
        {
            mpp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mpp = MediaPlayer.create(ResultActivity.this, R.raw.caracol);
            mpp.setLooping(true);
            mpp.start();
            txttitulo.setText("Eres una caracol");
            imagephoto.setBackgroundResource(R.drawable.caracol);
        }
        else if (hour.equals("night") && food.equals("meet") && km.equals("slow"))
        {
            mpp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mpp = MediaPlayer.create(ResultActivity.this, R.raw.zombie);
            mpp.setLooping(true);
            mpp.start();
            //mpp.pause();
            txttitulo.setText("Eres un zombie");
            imagephoto.setBackgroundResource(R.drawable.zombie);
        }
        else if (hour.equals("night") && food.equals("meet") && km.equals("fast"))
        {
            mpp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mpp = MediaPlayer.create(ResultActivity.this, R.raw.rata);
            mpp.setLooping(true);
            mpp.start();
            txttitulo.setText("Eres una rata");
            imagephoto.setBackgroundResource(R.drawable.rata);
        }
        else
        {
            mpp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mpp = MediaPlayer.create(ResultActivity.this, R.raw.ovni);
            mpp.setLooping(true);
            mpp.start();
            txttitulo.setText("Eres un alienigena");
            imagephoto.setBackgroundResource(R.drawable.alien);
        }
    }


    @Override
    public void onBackPressed() {
        mpp.reset();
        mpp.release();
        finish();
    }
}

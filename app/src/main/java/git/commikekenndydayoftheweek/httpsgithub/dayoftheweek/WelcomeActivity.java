package git.commikekenndydayoftheweek.httpsgithub.dayoftheweek;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //----------Handler used to pause on welcome before sending away----------//
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                sendToMain();

            }
        }, (3000)); // pause for 3 seconds
    }

    private void sendToMain() {

        Intent startIntent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(startIntent);
        finish();

    }
}

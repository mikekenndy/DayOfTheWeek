package git.commikekenndydayoftheweek.httpsgithub.dayoftheweek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mWednesday;
    private TextView mNotWednesday;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAdMob();

        mWednesday = (TextView) findViewById(R.id.main_wednesday);
        mNotWednesday = (TextView) findViewById(R.id.main_not_wednesday);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if(day == Calendar.WEDNESDAY) {

            mNotWednesday.setVisibility(View.INVISIBLE);
            mWednesday.setVisibility(View.VISIBLE);

        } else {

            mWednesday.setVisibility(View.INVISIBLE);
            mNotWednesday.setVisibility(View.VISIBLE);

        }
    }

    private void setupAdMob() {

        MobileAds.initialize(this, "ca-app-pub-1416108780379218/2898636440");

        final String TAG = "MainActivity";

        mAdView = (AdView) findViewById(R.id.main_adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-1416108780379218/2898636440");

        //----------Set ad events if desired-----
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });

    }
}

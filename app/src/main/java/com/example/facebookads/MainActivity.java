/*package com.example.facebookads;

import android.os.Bundle;


import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        AudienceNetworkAds.initialize(this);

        String placementId = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID";
        RelativeLayout banner50,banner90;
        banner50 = findViewById(R.id.banner_ad_50);
        banner90 = findViewById(R.id.banner_ad_90);
        AdView adView = new AdView(MainActivity.this,placementId,AdSize.BANNER_HEIGHT_50);
        banner50.addView(adView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Toast.makeText(MainActivity.this,"Error"+adError.getErrorMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Toast.makeText(MainActivity.this,"Adloaded",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

         AdView.AdViewLoadConfig config = adView.buildLoadAdConfig().withAdListener(adListener).build();
         adView.loadAd(config);

         AdView adView1 = new AdView(MainActivity.this,placementId,AdSize.BANNER_HEIGHT_90);
         banner90.addView(adView1);
         AdListener adListener1 = new AdListener() {
             @Override
             public void onError(Ad ad, AdError adError) {
                 Toast.makeText(MainActivity.this,"Error:" +adError.getErrorMessage(),Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onAdLoaded(Ad ad) {
                 Toast.makeText(MainActivity.this,"Ad Loaded" , Toast.LENGTH_SHORT).show();

             }

             @Override
             public void onAdClicked(Ad ad) {

             }

             @Override
             public void onLoggingImpression(Ad ad) {

             }
         };
        AdView.AdViewLoadConfig config1 = adView.buildLoadAdConfig().withAdListener(adListener1).build();

        adView1.loadAd(config1);




    }
}*/

package com.example.facebookads;

import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);

        // Initialize the Audience Network SDK
        AudienceNetworkAds.initialize(this);

        // Replace this with your actual test placement ID
        String placementId = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID";
        AdSettings.addTestDevice("03fb35f6-a81c-471e-af40-444c5adbb174");
//my code changes
        RelativeLayout banner50 = findViewById(R.id.banner_ad_50);
        RelativeLayout banner90 = findViewById(R.id.banner_ad_90);

        if (banner50 != null && banner90 != null) {
            loadBannerAd(placementId, banner50, AdSize.BANNER_HEIGHT_50);
            loadBannerAd(placementId, banner90, AdSize.BANNER_HEIGHT_90);
        } else {
            Log.e(TAG, "One or both banner layouts are null");
        }
    }

    private void loadBannerAd(String placementId, RelativeLayout bannerContainer, AdSize adSize) {
        AdView adView = new AdView(this, placementId, adSize);
        bannerContainer.addView(adView);

        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "Ad error: " + adError.getErrorMessage());
                Toast.makeText(MainActivity.this, "Ad Error: " + adError.getErrorMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d(TAG, "Ad loaded successfully");
                Toast.makeText(MainActivity.this, "Ad Loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d(TAG, "Ad clicked");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d(TAG, "Ad impression logged");
            }
        };

        AdView.AdViewLoadConfig loadAdConfig = adView.buildLoadAdConfig()
                .withAdListener(adListener)
                .build();

        adView.loadAd(loadAdConfig);
    }

    @Override
    protected void onDestroy() {
        // Clean up any resources if needed
        super.onDestroy();
    }
}
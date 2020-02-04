package com.carmel.materialactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import Model.JsonModel;

public class JsonActivity extends AppCompatActivity {
    private final static String JSON_FILE_ANDROID_WEAR = "androidwear.json";
    private final static String TAG = "JsonActivity";

    private WatchAdapter watchAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        init();

    }

    public void init() {
        listView = findViewById(R.id.listView);
        watchAdapter = new WatchAdapter(JsonActivity.this, getWatchesData());
        listView.setAdapter(watchAdapter);
    }

    /* Convert JSON String to BaseWatch Model via GSON */
    public List<JsonModel> getWatchesData() {
        String jsonString = getAssetsJSON(JSON_FILE_ANDROID_WEAR);
        Log.d(TAG, "Json: " + jsonString);
        Gson gson = new Gson();
        BaseWatch baseWatch = gson.fromJson(jsonString, BaseWatch.class);
        return baseWatch.getWatches();
    }
    /* Get File in Assets Folder */
    public String getAssetsJSON(String fileName) {
        String json = null;
        try {
            InputStream inputStream = this.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}

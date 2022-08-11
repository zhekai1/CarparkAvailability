package sg.edu.rp.c346.id21024750.carparkavailability;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvCarpark;
    AsyncHttpClient client;
    ArrayList<Carpark> alCarpark;
    CarparkAdapter aaCarpark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCarpark = findViewById(R.id.lvCarpark);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();
        alCarpark = new ArrayList<Carpark>();
        aaCarpark = new CarparkAdapter(MainActivity.this, R.layout.row, alCarpark);
        lvCarpark.setAdapter(aaCarpark);
        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            String area;
            String availability;
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrAvailability = firstObj.getJSONArray("availability");
                    for(int i = 0; i < jsonArrAvailability.length(); i++) {
                        JSONObject jsonObjAvailability = jsonArrAvailability.getJSONObject(i);
                        area = jsonObjAvailability.getString("area");
                        availability = jsonObjAvailability.getString("availability");
                        Carpark carpark = new Carpark(area, availability);
                        alCarpark.add(carpark);
                    }
                }
                catch(JSONException e){

                }
                aaCarpark.notifyDataSetChanged();
            }//end onSuccess
        });
    }//end onResume
}
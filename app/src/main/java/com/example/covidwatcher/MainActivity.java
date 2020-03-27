package com.example.covidwatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Aditya Verma on 26-03-2020
 */

public class MainActivity extends AppCompatActivity {

    private TextView mNewCases;
    private Button mGetDatabtn,mHospitalBtn,mSafeBtn;
    private RequestQueue requestQueue;
    String CountryName;
    private AutoCompleteTextView mGetCountry;
    private TextView textCase;
    private TextView mTotalCases;
    private TextView mLabelTotCases;
    private TextView mDeath, mLabelDeath, mRecovered, mLabelRecovered;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNewCases = (TextView) findViewById(R.id.newCases);
        mGetDatabtn = (Button) findViewById(R.id.getDatabtn);
        mGetCountry = (AutoCompleteTextView) findViewById(R.id.getCountry);
        requestQueue = Volley.newRequestQueue(this);
        textCase = (TextView) findViewById(R.id.textCase);
        mTotalCases = (TextView) findViewById(R.id.totCases);
        mLabelTotCases = (TextView) findViewById(R.id.textTotCases);
        mDeath = (TextView) findViewById(R.id.deaths);
        mLabelDeath = (TextView) findViewById(R.id.labelDeath);
        mRecovered = (TextView) findViewById(R.id.recovered);
        mLabelRecovered = (TextView) findViewById(R.id.labelRecovered);
        mHospitalBtn = (Button) findViewById(R.id.hospitalBtn);
        mSafeBtn = (Button) findViewById(R.id.safeBtn);

        int fire = 0x1F525;
        String emoji = getFireEmoji(fire);
        textCase.append(" " + emoji);

        int sick = 0x1F637;
        String sickemoji = getSickEmoji(sick);
        mLabelTotCases.append(" " + sickemoji);

        int cry = 0x1F62D;
        String cryemoji = getCryEmoji(cry);
        mLabelDeath.append(" " + cryemoji);

        int dance = 0x1F483;
        String danceemoji = getDanceEmoji(dance);
        mLabelRecovered.append(" " + danceemoji);

        String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
                "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
                "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
                "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam",
                "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
                "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia",
                "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
                "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
                "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
                "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
                "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
                "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
                "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
                "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
                "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait",
                "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
                "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar",
                "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
                "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat",
                "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
                "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands",
                "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
                "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda",
                "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
                "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
                "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
                "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon",
                "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
                "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga",
                "Trinidad and Tobago", "Tunisia", "Türkiye", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
                "United Arab Emirates", "United Kingdom", "US", "United States Minor Outlying Islands", "Uruguay",
                "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
                "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Russia", "Turkey"};

        mGetCountry.setAdapter(new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , countries));

        mGetDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CountryName = mGetCountry.getEditableText().toString();
                jsonParse();

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mGetCountry.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

            }
        });

        mHospitalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext() , HospitalActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext() , "Click on a Card" , Toast.LENGTH_LONG).show();
            }
        });

        mSafeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SafeActivity.class);
                startActivity(intent);

            }
        });

    }

    public String getFireEmoji(int fire){
        return new String(Character.toChars(fire));
    }

    public String getSickEmoji(int sick){
        return new String(Character.toChars(sick));
    }

    public String getCryEmoji(int cry){
        return new String(Character.toChars(cry));
    }

    public String getDanceEmoji(int dance){
        return new String(Character.toChars(dance));
    }

    private void jsonParse() {

        String url = "https://api.covid19api.com/summary";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Countries");
                    for (int i = 0 ; i<= jsonArray.length() ; i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        String name = object.getString("Country");
                        if (name.equals(CountryName)){
                            String recovered = object.getString("TotalRecovered");
                            String deaths = object.getString("TotalDeaths");
                            String totalcases = object.getString("TotalConfirmed");
                            String newcases = object.getString("NewConfirmed");
                            mNewCases.setText(newcases);
                            mTotalCases.setText(totalcases);
                            mDeath.setText(deaths);
                            mRecovered.setText(recovered);
                            break;
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);

    }

}


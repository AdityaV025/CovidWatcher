package com.example.covidwatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aditya Verma on 26-03-2020
 */

public class HospitalActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HospitalAdapter mAdapter;
    private List<People> mHospitalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mHospitalList = new ArrayList<>();
        mHospitalList.add(new People("All India Institute Medical Sciences (AIIMS)"));
        mHospitalList.add(new People("National Centre for Disease Control (NCDC)"));
        mHospitalList.add(new People("Indira Gandhi Government Medical College, Nagpur"));
        mHospitalList.add(new People("Kasturba Hospital for Infectious Diseases, Mumbai"));
        mHospitalList.add(new People("Sawai Man Singh, Jaipur"));
        mHospitalList.add(new People("Dr. S.N Medical College, Jodhpur"));
        mHospitalList.add(new People("Jhalawar Medical College, Jhalawar"));
        mHospitalList.add(new People("SP Med. College, Bikaner"));
        mHospitalList.add(new People("RNT Medical College, Udaipur"));
        mHospitalList.add(new People("King's Institute of Preventive Medicine & Research, Chennai"));
        mHospitalList.add(new People("Government Medical College, Theni)"));
        mHospitalList.add(new People("Tirunelveli Medical College, Tirunelveli"));
        mHospitalList.add(new People("Govt. Medical college, Thiruvaru"));
        mHospitalList.add(new People("King's George Medical University, Lucknow"));
        mHospitalList.add(new People("Institute of Medical Sciences, Banaras Hindu University, Varanasi  "));
        mHospitalList.add(new People("Jawaharlal Nehru Medical College, Aligarh"));
        mHospitalList.add(new People("Government Medical College, Haldwani"));
        mHospitalList.add(new People("National Institute of Cholera and Enteric Diseases, Kolkata"));
        mHospitalList.add(new People("IPGMER, Kolkata"));
        mHospitalList.add(new People("All India Institute Medical Sciences, Bhopal"));
        mHospitalList.add(new People("National Institute of Research in Tribal Health (NIRTH), Jabalpur"));
        mHospitalList.add(new People("National Institute of Virology Field Unit"));
        mHospitalList.add(new People("Govt. Medical College, Thriuvananthapuram"));
        mHospitalList.add(new People("Govt. Medical College, Kozhikhode"));
        mHospitalList.add(new People("Govt. Medical College, Thrissur"));
        mHospitalList.add(new People("Bangalore Medical College & Research Institute, Bangalore  "));
        mHospitalList.add(new People("National Institute of Virology Field Unit Bangalore"));
        mHospitalList.add(new People("Mysore Medical College & Research Institute, Mysore"));
        mHospitalList.add(new People("Hassan Inst. of Med. Sciences, Hassan"));
        mHospitalList.add(new People("Shimoga Inst. of Med. Sciences, Shivamogga"));
        mHospitalList.add(new People("BJ Medical College, Ahmedabad"));
        mHospitalList.add(new People("M.P.Shah Government Medical College, Jamnagar"));
        mHospitalList.add(new People("BPS Govt Medical College, Sonipat"));
        mHospitalList.add(new People("Pt. B.D. Sharma Post Graduate Inst. of Med. Sciences, Rohtak"));
        mHospitalList.add(new People("Indira Gandhi Medical College, Shimla, Himachal Pradesh"));
        mHospitalList.add(new People("Dr. Rajendra Prasad Govt. Med. College, Kangra, Tanda"));
        mHospitalList.add(new People("Sher-e- Kashmir Institute of Medical Sciences, Srinagar  "));
        mHospitalList.add(new People("Government Medical College, Jammu"));
        mHospitalList.add(new People("Government Medical College, Srinagar"));
        mHospitalList.add(new People("MGM Medical College, Jamshedpur"));
        mHospitalList.add(new People("NEIGRI of Health and Medical Sciences, Shillong"));
        mHospitalList.add(new People("J N Inst. of Med. Sciences Hospital, Imphal-East, Manipur"));
        mHospitalList.add(new People("Regional Institute of Medical Sciences, Imphal"));
        mHospitalList.add(new People("Regional Medical Research Center, Bhubaneswar   "));
        mHospitalList.add(new People("Government Medical College, Patiala"));
        mHospitalList.add(new People("Government Medical College, Amritsar"));
        mHospitalList.add(new People("Jawaharlal Institute of Postgraduate Medical Education & Research, Puducherry"));
        mHospitalList.add(new People("Gandhi Medical College, Secunderabad"));
        mHospitalList.add(new People("Osmania Medical College, Hyderabad"));
        mHospitalList.add(new People("Government Medical College, Agartala"));
        mHospitalList.add(new People("Rajendra Memorial Research Institute of Medical Sciences, Patna"));
        mHospitalList.add(new People("Post Graduate Institute of Medical Education & Research, Chandigarh"));
        mHospitalList.add(new People("All India Institute  Medical Sciences, Raipur"));
        mHospitalList.add(new People("Regional Medical Research Centre, Port Blair, Andaman and Nicobar"));
        mHospitalList.add(new People("Sri Venkateswara Institute of Medical Sciences, Tirupati"));
        mHospitalList.add(new People("Andhra Medical College, Visakhapatnam"));
        mHospitalList.add(new People("GMC, Anantapur"));
        mHospitalList.add(new People("Sidhartha Medical College, Vijayawada"));
        mHospitalList.add(new People("Rangaraya Medical College, Kakinada"));
        mHospitalList.add(new People("Gauhati Medical College, Guwahati"));
        mHospitalList.add(new People("Regional Medical Research Center, Dibrugarh"));
        mHospitalList.add(new People("Silchar Medical College, Silchar"));
        mHospitalList.add(new People("Jorhat Medical College, Jorhat"));

        //set adapter to recyclerview
        mAdapter = new HospitalAdapter(mHospitalList,this);
        mRecyclerView.setAdapter(mAdapter);
    }

}

package com.shivam.busroutesearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	 private static List<String> mRouteList;
	 private static List<String> mSearchRouteList = new ArrayList<>();
	 private AutoCompleteTextView mAutoCompleteTextView;
	 private ListView mLlistView;
	 private BusListAdapter mListAdapter = null;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_main);
		  initializeRouteData();
		  initViews();
		  setListAdapter();
		  registerListener();


	 }

	 private void registerListener() {
		  mLlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					 Toast.makeText(MainActivity.this, "You clicked on " + mSearchRouteList.get(position), Toast.LENGTH_SHORT).show();
				}
		  });

		  mAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				}

				@Override
				public void onTextChanged(CharSequence text, int start, int before, int count) {
					 if(text.length() == 0){
						  mSearchRouteList.clear();
						  mSearchRouteList.addAll(mRouteList);
						  mListAdapter.notifyDataSetChanged();
					 }else{
						  updateListItem(text);
					 }
				}

				@Override
				public void afterTextChanged(Editable s) {

				}
		  });
	 }

	 private void updateListItem(final CharSequence s) {
		  mSearchRouteList.clear();
		  for (int i = 0; i < mRouteList.size(); i++) {
				if (mRouteList.get(i).toLowerCase().startsWith(s.toString().toLowerCase())) {
					 mSearchRouteList.add(mRouteList.get(i));
				}
		  }
		  mListAdapter.notifyDataSetChanged();
	 }


	 private void setListAdapter() {
		  mSearchRouteList.addAll(mRouteList);
		  mListAdapter = new BusListAdapter(this, mSearchRouteList);
		  mLlistView.setAdapter(mListAdapter);
	 }

	 private void initViews() {
		  mLlistView = (ListView) findViewById(R.id.id_listView);
		  mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompletextView);
	 }

	 public void initializeRouteData() {
		  mRouteList = new ArrayList<>();
		  mRouteList.add("50 BANASHANKARI TTMC<->Banashankari Bus Station");
		  mRouteList.add("500 BANASHANKARI TTMC<->Hebbala");
		  mRouteList.add("500AA Jn of Marathalli Bridge<->Yelahanka Satelite Town 4th Phase");
		  mRouteList.add("500AB BANASHANKARI TTMC<->Hebbala");
		  mRouteList.add("500B Yeshwanthpura TTMC<->Central Silk Board");
		  mRouteList.add(" 500BA Yeshwanthpur TTMC<->Maratahalli Bridge");
		  mRouteList.add("60 BANASHANKARI TTMC<->BANASHANKARI TTMC");
		  mRouteList.add("600 Banashankari Bus Station<->Chandapura");
		  mRouteList.add("600CA BANASHANKARI TTMC<->Anekal");
		  mRouteList.add("600CB BANASHANKARI TTMC<->Anekal");
		  mRouteList.add("600CF BANASHANKARI TTMC<->Electronic City Wipro Gate");
		  mRouteList.add("600CH Banashankari Bus Station<->Huskur");

	 }
}

package com.shivam.busroutesearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SHIVAM on 09-07-2016.
 */
public class BusListAdapter extends BaseAdapter {
	 private List<String> mList;
	Context mContext;
	 private LayoutInflater mInflater = null;

	 public BusListAdapter(Context context, List<String> mBusDataList) {
		  this.mList = mBusDataList;
		  mContext = context;
		  mInflater = LayoutInflater.from(mContext);
	 }

	 @Override
	 public int getCount() {
		  return mList.size();
	 }

	 @Override
	 public Object getItem(int position) {
		  return null;
	 }

	 @Override
	 public long getItemId(int position) {
		  return 0;
	 }

	 class ViewHolder {
			TextView nameTextView;

		  public ViewHolder(View view){
				nameTextView = (TextView) view.findViewById(R.id.id_busTitle);
		  }
	 }

	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
		  ViewHolder holder;

		  if (convertView == null ){
				convertView = mInflater.inflate(R.layout.list_items, parent, false);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
		  } else {
				holder = (ViewHolder) convertView.getTag();
		  }

		  holder.nameTextView.setText(mList.get(position));
		  return convertView;
	 }
}

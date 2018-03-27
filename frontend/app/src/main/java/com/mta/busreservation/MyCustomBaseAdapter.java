package com.mta.busreservation;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mta.busreservation.R;

import java.util.ArrayList;

public class MyCustomBaseAdapter extends BaseAdapter {
	Context context;
	 private static ArrayList<SearchResults> searchArrayList;
	 
	 private LayoutInflater mInflater;

	 public MyCustomBaseAdapter(Context context, ArrayList<SearchResults> results) {
	  searchArrayList = results;
	  mInflater = LayoutInflater.from(context);
	 }

	 public int getCount() {
	  return searchArrayList.size();
	 }

	 public Object getItem(int position) {
	  return searchArrayList.get(position);
	 }

	 public long getItemId(int position) {
	  return position;
	 }

	 

	 static class ViewHolder {
	  TextView timing;
	  TextView agency;
		 TextView seat;
		 TextView categary;
		 TextView bus_no;
		 TextView range;
		 TextView price;
		 TextView id;
		 TextView bus_day;

	 }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 ViewHolder holder;
		  if (convertView == null) {
		   convertView = mInflater.inflate(R.layout.custom_row_view, null);
		   holder = new ViewHolder();
		   holder.timing = (TextView) convertView.findViewById(R.id.timings);
		   holder.agency = (TextView) convertView.findViewById(R.id.agency);
			  holder.seat = (TextView) convertView.findViewById(R.id.seat);
			  holder.categary = (TextView) convertView.findViewById(R.id.categary);
			  holder.bus_no = (TextView) convertView.findViewById(R.id.bus_no);
			  holder.range = (TextView) convertView.findViewById(R.id.range);
			  holder.price = (TextView) convertView.findViewById(R.id.price);
			  holder.id = (TextView) convertView.findViewById(R.id.hidden);
			  holder.bus_day = (TextView) convertView.findViewById(R.id.bus_day);

		   convertView.setTag(holder);
		  } else {
		   holder = (ViewHolder) convertView.getTag();
		  }
		  holder.timing.setText(searchArrayList.get(position).getTimimg());
		  holder.agency.setText(searchArrayList.get(position).getAgency());
		  holder.seat.setText(searchArrayList.get(position).getSeat());
		holder.categary.setText(searchArrayList.get(position).getCategary());
		holder.bus_no.setText(searchArrayList.get(position).getBus_no());
		holder.range.setText(searchArrayList.get(position).getRange());
		holder.price.setText(searchArrayList.get(position).getPrice());
		holder.id.setText(searchArrayList.get(position).getid());
		holder.bus_day.setText(searchArrayList.get(position).getbus_day());
		  return convertView;
		
	}
	}
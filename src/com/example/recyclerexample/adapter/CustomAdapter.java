package com.example.recyclerexample.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerexample.R;
import com.example.recyclerexample.Data.UserInfo;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>
{
	UserInfo[] userInfoArray;

	public class ViewHolder extends RecyclerView.ViewHolder
	{
		protected TextView tvName, tvAge;

		public ViewHolder(View v)
		{
			super(v);
			tvName = (TextView) v.findViewById(R.id.tv_name);
			tvAge = (TextView) v.findViewById(R.id.tv_age);
		}
	}

	public CustomAdapter(UserInfo[] userInfoList)
	{
		this.userInfoArray = userInfoList;
	}

	@Override
	public int getItemCount()
	{
		if (userInfoArray == null)
			return 0;
		return userInfoArray.length;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position)
	{
		if (userInfoArray.length > position)
		{
			UserInfo uInfo = userInfoArray[position];
			holder.tvName.setText(uInfo.strName);
			holder.tvAge.setText(String.valueOf(uInfo.age));
		}
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		/*
		 * parent view should be null, else IllegalStateExecption will be
		 * thrown. Child should not have any parent.
		 */
		View v = inflater.inflate(R.layout.list_item_view, null);
		return new ViewHolder(v);
	}
}
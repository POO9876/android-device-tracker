package com.example.androidtablayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class InstallAppAdapter extends BaseAdapter {
	Activity mActivity;
	List<InstalledApps> mInstallApp;
	LayoutInflater mInflater;

	public InstallAppAdapter(Activity activity, List<InstalledApps> installApp) {
		mActivity = activity;
		mInstallApp = installApp;
		mInflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return mInstallApp.size();
	}

	public Object getItem(int position) {
		return mInstallApp.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.view_instal_app, null);
			holder = new ViewHolder();
			holder.txtName = (TextView) convertView
					.findViewById(R.id.txt_app_name);
			holder.txtDateTime = (TextView) convertView
					.findViewById(R.id.txt_date_time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		InstalledApps install = mInstallApp.get(position);

		Date date = new Date(install.getDateTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		holder.txtName.setText(install.getAppName());
		holder.txtDateTime.setText(df.format(date) + "");
		return convertView;
	}

	static class ViewHolder {
		TextView txtName, txtDateTime;
	}

}

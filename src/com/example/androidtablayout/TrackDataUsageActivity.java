package com.example.androidtablayout;

import android.app.Activity;
import android.net.TrafficStats;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.TextView;

public class TrackDataUsageActivity extends Activity {

	TextView totalDownload, totalUploaded, totalMobileDowload,
			totalMobileUpload, totalWifiDownload, totalWifiUpload,
			txtIPAddress;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_usage);

		txtIPAddress = (TextView) findViewById(R.id.txt_ip_address);
		totalDownload = (TextView) findViewById(R.id.txt_total_download);
		totalUploaded = (TextView) findViewById(R.id.txt_total_upload);
		totalMobileDowload = (TextView) findViewById(R.id.txt_total_mobile_download);
		totalMobileUpload = (TextView) findViewById(R.id.txt_total_mobile_upload);
		totalWifiDownload = (TextView) findViewById(R.id.txt_total_wifi_download);
		totalWifiUpload = (TextView) findViewById(R.id.txt_total_wifi_upload);

		WifiManager wifiManager = (WifiManager) this
				.getSystemService(this.WIFI_SERVICE);
		String macAddress = wifiManager.getConnectionInfo().getMacAddress();
		String ip = Formatter.formatIpAddress(wifiManager.getConnectionInfo()
				.getIpAddress());
		txtIPAddress.setText("Ip Address: "+ip);

		long otalDownload = TrafficStats.getTotalRxBytes() / 1048576;
		long otalUploaded = TrafficStats.getTotalTxBytes() / 1048576;

		long otalMobileDowload = TrafficStats.getMobileRxBytes() / 1048576;
		long otalMobileUpload = TrafficStats.getMobileTxBytes() / 1048576;

		long otalWifiDownload = otalDownload - otalMobileDowload;
		long otalWifiUpload = otalUploaded - otalMobileUpload;

		totalDownload.setText("Total Download:  " + otalDownload + " Mb");
		totalUploaded.setText("Total Uploaded:  " + otalUploaded + " Mb");
		totalMobileDowload.setText("Total Mobile Download: "
				+ otalMobileDowload + " Mb");
		totalMobileUpload.setText("Total Mobile Uploaded: " + otalMobileUpload
				+ " Mb");
		totalWifiDownload.setText("Total WiFi Download: " + otalWifiDownload
				+ " Mb");
		totalWifiUpload.setText("Total WiFi Upload: " + otalWifiUpload + " Mb");

		// System.out.println("totalDownload " + totalDownload);
		// System.out.println("totalUploaded " + totalUploaded);
		// System.out.println("totalMobileDowload " + totalMobileDowload);
		// System.out.println("totalMobileUpload " + totalMobileUpload);
		// System.out.println("totalWifiDownload " + totalWifiDownload);
		// System.out.println("totalWifiUpload " + totalWifiUpload);
	}
}
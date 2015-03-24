package com.example.androidtablayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MemoryUsageActivity extends Activity {

	TextView txtTotalMemory, txtFreeMemory, txtUsedMemory;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_memory_usage);
		txtTotalMemory = (TextView) findViewById(R.id.txt_total_memory);
		txtFreeMemory = (TextView) findViewById(R.id.txt_free_memory);
		txtUsedMemory = (TextView) findViewById(R.id.txt_used_memory);
		getUsedMemorySize();
	}

	public long getUsedMemorySize() {

		long freeSize = 0L;
		long totalSize = 0L;
		long usedSize = -1L;
		try {
			Runtime info = Runtime.getRuntime();
			freeSize = info.freeMemory() / 1048576;
			totalSize = info.totalMemory() / 1048576;
			usedSize = totalSize - freeSize;

			txtTotalMemory
					.setText("Total Memory Used:    " + totalSize + " Mb");
			txtFreeMemory.setText("Free Memory:    " + freeSize + " Mb");
			txtUsedMemory.setText("Memory Used:    " + usedSize + " Mb");

			System.out.println("memory used free: " + freeSize
					+ " total size: " + totalSize + " used size: " + usedSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usedSize;

	}
}
package com.example.androidtablayout;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.ListView;

public class InstalledApplicationActivity extends Activity {
	ListView listInstallApps;
	private List<InstalledApps> listAppInstalMap;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvity_install_apps);

		listInstallApps = (ListView) findViewById(R.id.list_install_apps);
		listAppInstalMap = new ArrayList<InstalledApps>();
		final PackageManager pm = this.getPackageManager();
		List<ApplicationInfo> packages = pm
				.getInstalledApplications(PackageManager.GET_META_DATA);
		for (ApplicationInfo packageInfo : packages) {
			InstalledApps mInstalledApps;
			try {
				mInstalledApps = new InstalledApps(
						"" + packageInfo.loadLabel(pm),
						packageInfo.packageName,
						InstalledApplicationActivity.this.getPackageManager()
								.getPackageInfo(packageInfo.packageName, 0).firstInstallTime);
				listAppInstalMap.add(mInstalledApps);
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		InstallAppAdapter adapter = new InstallAppAdapter(InstalledApplicationActivity.this,
				listAppInstalMap);

		listInstallApps.setAdapter(adapter);

		System.out.println("installed apps: " + listAppInstalMap.toString());
	}
}

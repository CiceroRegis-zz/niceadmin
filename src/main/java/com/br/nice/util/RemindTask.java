package com.br.nice.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class RemindTask extends TimerTask {
	Timer timer = new Timer();

	@SuppressWarnings({ "resource", "unused" })
	@Override
	public void run() {
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				try {
					// Executando get para manter servidor ativo
					URL url = new URL("https://nice-admin.herokuapp.com");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					InputStream content = connection.getInputStream();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, 0l, Duration.ofMinutes(2).toMillis());
		{
		}
	}
}

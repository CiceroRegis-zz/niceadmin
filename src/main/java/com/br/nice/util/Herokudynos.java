package com.br.nice.util;

import java.util.Timer;

public class Herokudynos {
	Timer timer;
	
	public void Reminder(int seconds) {
		
			timer = new Timer();
			timer.schedule(new RemindTask(), seconds * 1000000);
		}
		
}

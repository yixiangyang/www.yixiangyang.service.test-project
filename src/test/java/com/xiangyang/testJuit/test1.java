package com.xiangyang.testJuit;

import java.util.Timer;
import java.util.TimerTask;

public class test1 {

	public static void main(String[] args) {
//		Timer timer = new Timer();
//		 
//	    timer.schedule(new TimerTask() {
//	      public void run() {
//	    	int s = 5;
//	    	int b = 0;
//	       if(s != 0){
//	    	   s --;
//	       }
//	       System.out.println(s);
//	      }
//	    }, 1000);
		Timer t = new Timer();
		
		TimerTask tt = new TimerTask(){
			int s = 5;
			public void run(){
				if(s >1){
					s--;
					System.out.println(s);
				}
		  System.gc();
			}
		};
		t.scheduleAtFixedRate(tt,0,1000);
	}

}

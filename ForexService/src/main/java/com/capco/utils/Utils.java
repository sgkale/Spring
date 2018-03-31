package com.capco.utils;

import java.util.Random;

public class Utils {

		public static Random random=new Random();
		
		public static  int GetRandom() {
			return random.nextInt();
		}
	
}

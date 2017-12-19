package hystrix.scheduling.service;

import java.util.Date;

public class TimePeriod {

	public TimePeriod() { }
		
		@SuppressWarnings("deprecation")
		public static String timePeriod() {
			
			String timePeriod = "";
			
			Date currenttime = new Date();
			
			if( currenttime.getHours() >= 9 && currenttime.getHours()<=17 && currenttime.getDay() != 0 && currenttime.getDay() != 7)
			{
				timePeriod = "workingHours";
			}
			else if( currenttime.getDay() == 0 || currenttime.getDay() == 7 )
			{
				timePeriod = "weekend";
			}
			else
			{
				timePeriod = "afterHours";
			}
			
			return timePeriod;	
		}	
}

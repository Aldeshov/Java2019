package pack4;
public class Time implements Comparable<Time>{
	private int hour;
	private int minute;
	private int second;
	public Time(int hour, int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public String toUniversal(){
		String h = hour + "",m = minute + "",s = second + "";
		if(hour < 10)
			h = "0" + h;
		if(minute < 10)
			m = "0" + m;
		if(second < 10)
			s = "0" + s;
		return h + ":" + m + ":" + s;
	}
	public String toStandart(){
		String h = hour + "",m = minute + "",s = second + "", t = "";
		if(hour == 0)
		{
			h = (hour + 12) + "";
			t = "AM";
		}
		if(hour > 0 && hour < 12)
		{
			t = "AM";
		}
		if(hour == 12)
		{
			t = "PM";
		}
		if(hour > 12 && hour < 24)
		{
			h = (hour - 12) + "";
			t = "PM";
		}
		if(hour < 10)
			h = "0" + h;
		if(minute < 10)
			m = "0" + m;
		if(second < 10)
			s = "0" + s;
		return h + ":" + m + ":" + s + " " + t;
	}
	public void add(Time time){
		hour += time.hour;
		minute += time.minute;
		second += time.second;
		while(second >= 60){
			minute++; second -= 60;
		}
		while(minute >= 60){
			hour++;  minute -= 60;
		}
		while(hour >= 24)
			hour -= 24;
	}
	@Override
	public int compareTo(Time o) {
		Time t = (Time) o;
		if(hour < t.hour) return 1;
		if(hour > t.hour) return -1;
		if(minute < t.minute) return 1;
		if(minute > t.minute) return -1;
		if(second < t.second) return 1;
		if(second > t.second) return -1;
		return 0;
	}
}
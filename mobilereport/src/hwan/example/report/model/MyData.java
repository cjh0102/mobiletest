package hwan.example.report.model;

public class MyData {

	private String date;
	private String memo;
	private String time;
	private String title;
	
	public MyData() {
		
	}
	
	public MyData(String date, String memo, String time, String title) {
		this.date = date;
		this.memo = memo;
		this.time = time;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}

package com.mta.busreservation;

import android.widget.ImageView;

public class SearchResults {
	private String timings = "";
	private String agency = "";
	private String seat = "";
    private String categary = "";
    private String bus_no = "";
    private String range = "";
    private String price = "";
	private String id = "";
	private String bus_day = "";
	ImageView imageView;

	

	public void setTimimg(String timing) {
		this.timings = timing;
	}
	public String getTimimg() {
		return timings;
	}
	

	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getAgency() {return agency;}

	public void setSeat(String seat) {
		this.seat = seat;
	}
    public String getSeat() {return seat;}


    public void setCategary(String categary){this.categary=categary;}
    public String getCategary(){return categary;}

    public void setBus_no(String bus_no){this.bus_no=bus_no;}
    public String getBus_no(){return bus_no;}

    public void setRange(String range){this.range=range;}
    public String getRange(){return range;}

    public void setPrice(String price){this.price=price;}
    public String getPrice(){return price;}

	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}

	public String getbus_day() {
		return bus_day;
	}
	public void setbus_day(String bus_day) {
		this.bus_day = bus_day;
	}

}

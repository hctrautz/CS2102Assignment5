class Reading {
private Time t;
private int tempF;

Reading(Time t, int tempF){
	this.t = t;
	this.tempF = tempF;
}
public int getTemp() {
	return this.tempF; 
}
}

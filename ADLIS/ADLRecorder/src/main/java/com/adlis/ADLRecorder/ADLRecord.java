package com.adlis.ADLRecorder;


/**
 * ADLRecord
 */

public class ADLRecord {

	/* private Long id = 0L; */
	private String fin;
	private String gps;
	private int electromotiveBeltTensionings;
	private int vehicleIlluminationHours;
	private int km;
	private int fuelPercentage;
	private double tirePressure;
	private int refrigerantPercentage;
	private int brakefluidPercentage;
	private int screenWashPercentage;
	private int kmHighway;
	private int kmRoad;
	private int kmCity;
	private int temperatureCelsius;
	private int elektricSeatAdjustments;
	private int cdSwap;
	private int chargeCycles;

	public ADLRecord(String fin, String gps, int electromotiveBeltTensionings, int vehicleIlluminationHours, int km,
			int fuelPercentage, double tirePressure, int refrigerantPercentage, int brakefluidPercentage,
			int screenWashPercentage, int kmHighway, int kmRoad, int kmCity, int temperatureCelsius,
			int elektricSeatAdjustments, int cdSwap, int chargeCycles) {
		super();
		this.fin = fin;
		this.gps = gps;
		this.electromotiveBeltTensionings = electromotiveBeltTensionings;
		this.vehicleIlluminationHours = vehicleIlluminationHours;
		this.km = km;
		this.fuelPercentage = fuelPercentage;
		this.tirePressure = tirePressure;
		this.refrigerantPercentage = refrigerantPercentage;
		this.brakefluidPercentage = brakefluidPercentage;
		this.screenWashPercentage = screenWashPercentage;
		this.kmHighway = kmHighway;
		this.kmRoad = kmRoad;
		this.kmCity = kmCity;
		this.temperatureCelsius = temperatureCelsius;
		this.elektricSeatAdjustments = elektricSeatAdjustments;
		this.cdSwap = cdSwap;
		this.chargeCycles = chargeCycles;
	}

	public ADLRecord() {
		// needed for Database
	}

	public String getFin() {
		return this.fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getGps() {
		return this.gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public int getElectromotiveBeltTensionings() {
		return this.electromotiveBeltTensionings;
	}

	public void setElectromotiveBeltTensionings(int electromotiveBeltTensionings) {
		this.electromotiveBeltTensionings = electromotiveBeltTensionings;
	}

	public int getVehicleIlluminationHours() {
		return this.vehicleIlluminationHours;
	}

	public void setVehicleIlluminationHours(int vehicleIlluminationHours) {
		this.vehicleIlluminationHours = vehicleIlluminationHours;
	}

	public int getKm() {
		return this.km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getFuelPercentage() {
		return this.fuelPercentage;
	}

	public void setFuelPercentage(int fuelPercentage) {
		this.fuelPercentage = fuelPercentage;
	}

	public double getTirePressure() {
		return this.tirePressure;
	}

	public void setTirePressure(int tirePressure) {
		this.tirePressure = tirePressure;
	}

	public int getRefrigerantPercentage() {
		return this.refrigerantPercentage;
	}

	public void setRefrigerantPercentage(int refrigerantPercentage) {
		this.refrigerantPercentage = refrigerantPercentage;
	}

	public int getBrakefluidPercentage() {
		return this.brakefluidPercentage;
	}

	public void setBrakefluidPercentage(int brakefluidPercentage) {
		this.brakefluidPercentage = brakefluidPercentage;
	}

	public int getScreenWashPercentage() {
		return this.screenWashPercentage;
	}

	public void setScreenWashPercentage(int screenWashPercentage) {
		this.screenWashPercentage = screenWashPercentage;
	}

	public int getKmHighway() {
		return this.kmHighway;
	}

	public void setKmHighway(int kmHighway) {
		this.kmHighway = kmHighway;
	}

	public int getKmRoad() {
		return this.kmRoad;
	}

	public void setKmRoad(int kmRoad) {
		this.kmRoad = kmRoad;
	}

	public int getKmCity() {
		return this.kmCity;
	}

	public void setKmCity(int kmCity) {
		this.kmCity = kmCity;
	}

	public int getTemperatureCelsius() {
		return this.temperatureCelsius;
	}

	public void setTemperatureCelsius(int temperatureCelsius) {
		this.temperatureCelsius = temperatureCelsius;
	}

	public int getElektricSeatAdjustments() {
		return this.elektricSeatAdjustments;
	}

	public void setElektricSeatAdjustments(int elektricSeatAdjustments) {
		this.elektricSeatAdjustments = elektricSeatAdjustments;
	}

	public int getCdSwap() {
		return this.cdSwap;
	}

	public void setCdSwap(int cdSwap) {
		this.cdSwap = cdSwap;
	}

	public int getChargeCycles() {
		return this.chargeCycles;
	}

	public void setChargeCycles(int chargeCycles) {
		this.chargeCycles = chargeCycles;
	}

	@Override
	public String toString() {
		return "ADLRecord [fin=" + this.fin + ", gps=" + this.gps + ", electromotiveBeltTensionings="
				+ this.electromotiveBeltTensionings + ", vehicleIlluminationHours=" + this.vehicleIlluminationHours
				+ ", km=" + this.km + ", fuelPercentage=" + this.fuelPercentage + ", tirePressure=" + this.tirePressure
				+ ", refrigerantPercentage=" + this.refrigerantPercentage + ", brakefluidPercentage="
				+ this.brakefluidPercentage + ", screenWashPercentage=" + this.screenWashPercentage + ", kmHighway="
				+ this.kmHighway + ", kmRoad=" + this.kmRoad + ", kmCity=" + this.kmCity + ", temperatureCelsius="
				+ this.temperatureCelsius + ", elektricSeatAdjustments=" + this.elektricSeatAdjustments + ", cdSwap="
				+ this.cdSwap + ", chargeCycles=" + this.chargeCycles + "]";
	}

}
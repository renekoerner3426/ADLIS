package com.vw.fakultaet73.ADLRecorder;

import java.util.Random;

public class ADLRecordGenerator {
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
	private Random number;

	public ADLRecordGenerator() {
	}

	public ADLRecord generateADLRecord(String fin) {
		this.number = new Random();

		this.kmHighway = this.number.nextInt(200000);
		this.kmCity = this.number.nextInt(200000);
		this.kmRoad = this.number.nextInt(200000);
		this.km = this.kmHighway + this.kmCity + this.kmRoad;

		this.createGpsCoordinates();

		ADLRecord generatedADLRecord = new ADLRecord(fin, this.gps,
				this.electromotiveBeltTensionings = this.number.nextInt(12001),
				this.vehicleIlluminationHours = this.number.nextInt(18001), this.km,
				this.fuelPercentage = this.number.nextInt(101), this.tirePressure = (1 + this.number.nextInt(30)) / 10,
				this.refrigerantPercentage = this.number.nextInt(101),
				this.brakefluidPercentage = this.number.nextInt(101),
				this.screenWashPercentage = this.number.nextInt(101), this.kmHighway, this.kmRoad, this.kmCity,
				this.temperatureCelsius = this.number.nextInt(160),
				this.elektricSeatAdjustments = this.number.nextInt(401), this.cdSwap = this.number.nextInt(501),
				this.chargeCycles = this.number.nextInt(10001));

		return generatedADLRecord;
	}

	private void createGpsCoordinates() {
		// latitude(X) has to be between -90 and +90
		// longitude(Y) has to be between -180 and +180>
		// our format: xx,12345 yy,12345
		double latitude = this.generateCoordinate(-90, 90);
		double longitude = this.generateCoordinate(-180, 180);

		this.gps = "" + latitude + ", " + longitude;
	}

	private double generateCoordinate(int rangeMin, int rangeMax) {
		double coordinate = rangeMin + (rangeMax - rangeMin) * this.number.nextDouble();
		return this.nDecimalNumbers(coordinate, 5);
	}

	private double nDecimalNumbers(double coordinate, int nDecimal) {
		String decimalValue = "1";
		for (int i = 0; i < nDecimal; i++) {
			decimalValue += "0";
		}

		double decimalNumber = Double.parseDouble(decimalValue);
		return (Math.round(coordinate * decimalNumber)) / decimalNumber;
	}
}

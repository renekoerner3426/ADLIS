package main.java.adlis.ADLRecorder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class ADLRecordExport {

	public void sendPost() throws Exception {
		ADLRecord adbRecord = new ADLRecordGenerator().generateADLRecord();
		URL url = new URL("http://localhost:8082/adl-api/v1/saveADL");
		// URL url = new URL("http://35.224.128.80:8081/adl-api/v1/saveADL");
		HttpURLConnection con = establishConnection(url);

		StringBuilder jsonBuilder = new StringBuilder();
		createJsonAsString(adbRecord, jsonBuilder);

		String jsonInputString = jsonBuilder.toString();
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}
	}

	private void createJsonAsString(ADLRecord adbRecord, StringBuilder jsonBuilder) {
		jsonBuilder.append("{");
		appendCreatedJsonPart("fin", adbRecord.getFin(), jsonBuilder);
		appendCreatedJsonPart("gps", adbRecord.getGps(), jsonBuilder);
		appendCreatedJsonPart("electromotiveBeltTensionings", "" + adbRecord.getElectromotiveBeltTensionings(),
				jsonBuilder);
		appendCreatedJsonPart("vehicleIlluminationHours", "" + adbRecord.getVehicleIlluminationHours(), jsonBuilder);
		appendCreatedJsonPart("km", "" + adbRecord.getKm(), jsonBuilder);
		appendCreatedJsonPart("fuelPercentage", "" + adbRecord.getFuelPercentage(), jsonBuilder);
		appendCreatedJsonPart("tirePressure", "" + adbRecord.getTirePressure(), jsonBuilder);
		appendCreatedJsonPart("refrigerantPercentage", "" + adbRecord.getRefrigerantPercentage(), jsonBuilder);
		appendCreatedJsonPart("brakefluidPercentage", "" + adbRecord.getBrakefluidPercentage(), jsonBuilder);
		appendCreatedJsonPart("screenWashPercentage", "" + adbRecord.getScreenWashPercentage(), jsonBuilder);
		appendCreatedJsonPart("kmHighway", "" + adbRecord.getKmHighway(), jsonBuilder);
		appendCreatedJsonPart("kmRoad", "" + adbRecord.getKmRoad(), jsonBuilder);
		appendCreatedJsonPart("kmCity", "" + adbRecord.getKmCity(), jsonBuilder);
		appendCreatedJsonPart("temperatureCelsius", "" + adbRecord.getTemperatureCelsius(), jsonBuilder);
		appendCreatedJsonPart("elektricSeatAdjustments", "" + adbRecord.getElektricSeatAdjustments(), jsonBuilder);
		appendCreatedJsonPart("cdSwap", "" + adbRecord.getCdSwap(), jsonBuilder);
		appendCreatedJsonPart("chargeCycles", "" + adbRecord.getChargeCycles(), jsonBuilder);
		jsonBuilder.replace(jsonBuilder.length() - 1, jsonBuilder.length(), "");
		jsonBuilder.append("}");
	}

	private void appendCreatedJsonPart(String attribute, String value, StringBuilder jsonBuilder) {
		jsonBuilder.append(createJsonPart(attribute, value));
	}

	private String createJsonPart(String attribute, String value) {
		String jsonPart = "\"" + attribute + "\": ";
		jsonPart += "\"" + value + "\",";

		return jsonPart;
	}

	private HttpURLConnection establishConnection(URL url) throws IOException, ProtocolException {
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		return con;
	}
}

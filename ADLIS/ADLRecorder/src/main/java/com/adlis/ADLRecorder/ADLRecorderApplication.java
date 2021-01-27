package com.adlis.ADLRecorder;


public class ADLRecorderApplication {

	public static void main(String[] args) {
		ADLRecordExport export = new ADLRecordExport();
		try {
			export.sendPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}

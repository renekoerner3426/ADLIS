package com.adlis.ADLBackEnd.entities;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class LastChangedStorage {
	private List<LastChanged> list = new ArrayList<>();
	
	public LastChangedStorage() {
	}
	
	public void change(String fin) {
		for (LastChanged lastChanged : this.list) {
			if (lastChanged.getFin().equals(fin)) {
				lastChanged.setLastChange("" + LocalDateTime.now(ZoneId.of("Europe/Berlin")));
			}
		}
	}
	
	public void changeAll() {
		for (LastChanged lastChanged : this.list) {
				lastChanged.setLastChange("" + LocalDateTime.now(ZoneId.of("Europe/Berlin")));
		}
	}
	
	public LastChanged getLastChangedByState(String fin) {
		for (LastChanged lastChanged : this.list) {
			if (lastChanged.getFin().equals(fin)) {
				return lastChanged;
			}
		}
		return null;
	}

}

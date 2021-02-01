import { Component, OnInit, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { PassDataService } from '../pass-data.service';


interface ADLRecord {
  fin: string;
  gps: string;
  electromotiveBeltTensionings: number;
  vehicleIlluminationHours: number;
  km: number;
  fuelPercentage: number;
  tirePressure: number;
  refrigerantPercentage: number;
  brakefluidPercentage: number;
  screenWashPercentage: number;
  kmHighway: number;
  kmRoad: number;
  kmCity: number;
  temperatureCelsius: number;
  elektricSeatAdjustments: number;
  cdSwap: number;
  chargeCycles: number;
}

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})

export class OverviewComponent implements OnInit {
  subscription: Subscription;
  httpHeaders: HttpHeaders;

  constructor(@Inject('ADLBackEnd-CLUSTERIP') private basicUrl: string, private http: HttpClient, private ds: PassDataService) {
    this.httpHeaders = new HttpHeaders({
    'Content-Type':'application/json',
    'Authorization':'Basic ' + btoa('admin:admin')});
  }

  recordUrl: string;

  //Import
  failedImport: boolean = false;
  successfullImport: boolean = false;

  //all
  adlRecords: ADLRecord[] = [
    {
      fin: "test", gps: "hierundda", electromotiveBeltTensionings: 1, vehicleIlluminationHours: 2, km: 3, fuelPercentage: 4, tirePressure: 5, refrigerantPercentage: 6, brakefluidPercentage: 7,
      screenWashPercentage: 8, kmHighway: 9, kmRoad: 10, kmCity: 11, temperatureCelsius: 12, elektricSeatAdjustments: 13, cdSwap: 14, chargeCycles: 15
    },
    {
      fin: "vielleichteintest", gps: "nirgendwo666", electromotiveBeltTensionings: 10, vehicleIlluminationHours: 20, km: 30, fuelPercentage: 40, tirePressure: 50, refrigerantPercentage: 60, brakefluidPercentage: 70,
      screenWashPercentage: 80, kmHighway: 90, kmRoad: 100, kmCity: 110, temperatureCelsius: 120, elektricSeatAdjustments: 130, cdSwap: 140, chargeCycles: 150
    }
  ];

  fin: string;
  column: string;

  ngOnInit(): void {
    this.getADLRecords();
  }

  private getADLRecordUrl() {
    this.recordUrl = this.ds.getFinString() == "ADMIN" ? "http://" + this.basicUrl + "/adl-api/v1/adlRecords" : "http://" + this.basicUrl + "/adl-api/v1/retrieveADLByFin/" + this.ds.getFinString();
  }

  public getADLRecords() {
    this.getADLRecordUrl();
    this.http.get<ADLRecord[]>(this.recordUrl, {observe: 'body', headers: this.httpHeaders}, ).subscribe(({
    error: error => console.error('getADLRecords() - could not use ADLBackEnd', error),
    next: data => data.forEach(element => {
      this.adlRecords.push(element);
      console.log(element);
    })
    }));
  }
}
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PassDataService } from '../pass-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  correctData: boolean = false;
  userName: string;
  userPassword: string ;
  newName: string;
  newPassword: string;
  warningVisible: boolean = false;
  succesWarningVisible: boolean = false;
  registryWindowVisible: boolean = false;
  succes: boolean = false;

  constructor(private ds: PassDataService) { 
  }

  ngOnInit(): void {
  }

  public checkData() {
    if(this.userName == "admin" && this.userPassword == "admin") {
      this.sendData();
      this.correctData = true;
      return true;
    } else {
      return false;
    }
  }

  public login() {
    if(!this.checkData()) {
      this.warningVisible = true;
    }
  }

  public succesWarning() {
    this.succesWarningVisible = true;
  }

  public registry() {
    //new user to db
    this.succes = true;
    this.registryWindowVisible = false;
  }

  public startRegistry() {
    this.registryWindowVisible = true;
  }

  sendData(){
    this.ds.sendFin(this.userName);
  }
}

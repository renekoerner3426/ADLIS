import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
  newPasswordCheck: string;
  notTheSame: boolean = false;
  wrongPassword: boolean = false;
  isEmpty: boolean = false;
  succesWarningVisible: boolean = false;
  registryWindowVisible: boolean = false;
  succes: boolean = false;

  constructor(private ds: PassDataService, private router: Router) { 
  }

  ngOnInit(): void {
  }

  public checkData() {
    if(this.userName == "" || this.userName == undefined ){
      this.isEmpty = true;
    } else {
      this.isEmpty = false;
      this.userName = this.userName.toUpperCase();
      if(this.userName == "ADMIN" && this.userPassword == "admin") {
        this.correctData = true;
        return true;
      } else {
        console.log(this.userName)
        return false;
      }
    }
  }

  public login() {
    if(!this.checkData()) {
      this.wrongPassword = true;
    } else {
      this.sendData();
      this.router.navigateByUrl("/overview");
    }
  }

  public succesWarning() {
    this.succesWarningVisible = true;
  }

  public registry() {
    //new user to db
    if(this.newPassword == this.newPasswordCheck) {
      this.notTheSame = false;
      this.succes = true;
      this.registryWindowVisible = false;
    } else {
      this.notTheSame = true;
    }
  }

  public startRegistry() {
    this.registryWindowVisible = true;
  }

  sendData(){
    this.ds.sendFin(this.userName);
  }
}

import { Component, Inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PassDataService } from '../pass-data.service';
import { HttpClient } from '@angular/common/http';

interface Account {
  fin: string,
  password: string
}

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
  newNameError: boolean = false;
  newPassword: string;
  newPasswordCheck: string;
  newPasswordError: boolean = false;
  notTheSame: boolean = false;
  wrongPassword: boolean = false;
  isEmpty: boolean = false;
  missingName: boolean = false;
  succesWarningVisible: boolean = false;
  registryWindowVisible: boolean = false;
  succes: boolean = false;
  correctLoginData: boolean = false; 

  constructor(@Inject('CLUSTERIP') private basicUrl: string, 
              @Inject('ADMIN_USER') private adminUser: string, 
              @Inject('ADMIN_PASSWORD') private adminPassword: string,
              private ds: PassDataService, private router: Router, private http: HttpClient) { 
  }

  ngOnInit(): void {
  }

  public checkData() {
    if(this.userName == "" || this.userName == undefined ){
      this.isEmpty = true;
    } else {
      this.isEmpty = false;
      this.userName = this.userName.toUpperCase();
      this.loginCheck();
      if((this.userName == this.adminUser && this.userPassword == this.adminPassword) || this.correctLoginData) {
        this.correctData = true;
        return true;
      } else {
        return false;
      }
    }
  }

  public async loginCheck() {
    var account: Account;
    const promise = this.http.post<boolean>("http://" + this.basicUrl + "/account/login", account = {fin: this.userName, password: this.userPassword}).toPromise();
    promise.then((data) => {
      this.correctLoginData = data;
    }).catch((error) => {
      console.error('login() - could not use login', error)
    });
  }

  public newAccount() {
    var account: Account;
    this.http.post<boolean>("http://" + this.basicUrl + "/account/new", account = {fin: this.newName.toUpperCase(), password: this.newPassword}).subscribe(({
    error: error => console.error('new() - could not create new Account', error),
    next: data => {
      console.log(this.newName)
      this.succes = data;
     }
    }));
  }

  public login() {
    if(!this.checkData) {
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
    if (this.newName == undefined) {
      this.newNameError = true;
    } else {
      this.newNameError = false;
    }
    if (this.newPassword != this.newPasswordCheck) {
      this.notTheSame = true;
    } else {
      this.notTheSame = false;
    }
    if (this.newPassword == undefined) {
      this.newPasswordError = true;
    } else {
      this.newPasswordError = false;
    }
    if(this.newPassword == this.newPasswordCheck && this.newPassword != undefined && this.newName != undefined) {
      this.newAccount();
      //implementieren
      this.registryWindowVisible = false;
    }  
  }

  public startRegistry() {
    this.registryWindowVisible = true;
  }

  sendData(){
    this.ds.sendFin(this.userName);
  }
}

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { PassDataService } from './pass-data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ADLFrontEnd'
  fin: string = "";
  subscription: Subscription;

  constructor(private ds: PassDataService) {
    this.subscription = this.ds.getFin().subscribe(x => { 
      this.fin = x; 
    });
  }

  ngOnInit(): void {
  }


}



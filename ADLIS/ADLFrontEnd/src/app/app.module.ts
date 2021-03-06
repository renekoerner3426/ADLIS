import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { OverviewComponent } from './overview/overview.component';
import { environment } from 'src/environments/environment.prod';
import { GroupUiModule } from '@sdc-wob-type-3/group-ui-angular';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    OverviewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    GroupUiModule
  ],
  providers: [
    {provide: 'CLUSTERIP', useValue: environment.basicUrl},
    {provide: 'ADMIN_USER', useValue: environment.adminuser},
    {provide: 'ADMIN_PASSWORD', useValue: environment.adminpassword},
    {provide: 'BACKEND_USER', useValue: environment.backenduser},
    {provide: 'BACKEND_PASSWORD', useValue: environment.backendPassword}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

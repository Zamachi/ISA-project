import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { MaterialModule } from './material/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { FlexLayoutModule } from "@angular/flex-layout";
import { FormsModule } from '@angular/forms';
import { SearchComponent } from './search/search.component';
import { NgxSliderModule } from "@angular-slider/ngx-slider";
import { CountriesService } from './services/countries.service';
import { UserService } from './services/user.service';
import { ItemsService } from './services/items.service';
import { SessionService } from './services/session.service';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { ProfileComponent } from './profile/profile.component';
import { CategoryService } from './services/category.service';
import { TokenInterceptorService } from './services/token-interceptor.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    SearchComponent,
    AdminPanelComponent,
    ProfileComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    FormsModule,
    NgxSliderModule
  ],
  providers: [
    CountriesService,
    UserService,
    ItemsService,
    SessionService,
    CategoryService,
  { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptorService, multi: true} ],
  bootstrap: [AppComponent]
})
export class AppModule { }

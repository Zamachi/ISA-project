import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CountriesService } from '../services/countries.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  errorExists = false;
  errorText = "";
  selectedCountry: any;

  countries = [  ];
  data: any;
  constructor(private router: Router,
    private countryService: CountriesService,
     private userService: UserService,
     private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.countryService.findAllCountries().subscribe(
      value => {
         this.countries = value.body.map( country => country.name );
      }

    );
  }

  onSubmit(form: NgForm){
    this.userService.registerUser(
      form.value.username,
      form.value.password,
      form.value.email,
      form.value.country
    ).subscribe(
      data => {
        if(data != null){
          this.data = data;
          this._snackBar.open("User "+this.data.username+" created!", "Close", {duration: 3000});
          this.router.navigate(["/login"]);
        }else{
          this._snackBar.open("User cannot be created, user with a given username exists in the database!", "Close", {duration: 3000});

        }
       }
    );

  }

}

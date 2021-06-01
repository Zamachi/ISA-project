import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
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

  constructor(private router: Router, private countryService: CountriesService, private userService: UserService) { }

  ngOnInit(): void {
    this.countryService.findAllCountries().subscribe(
      value => { this.countries = value.body.map( country => country.name ) }

    );
  }

  onSubmit(form: NgForm){
    // if(!this.userService.getUser(form.value.email)){
    //   this.errorExists = false;
    //   var newUser = this.userService.registerUser( form.value.email,
    //                                                form.value.password,
    //                                                form.value.date );
    //   this.router.navigate(['']); //redirekcija na welcome komponentu
    // } else {
    //   this.errorExists = true;
    //   this.errorText = "already exists";
    // }
    this.userService.registerUser(
      form.value.username,
      form.value.password,
      form.value.email,
      form.value.country
    );

  }

}

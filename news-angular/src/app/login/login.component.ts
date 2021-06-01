import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errorExists = false;
  errorText = "";

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    // var email = form.value.email;
    // var password = form.value.password;
    // // var user = this.userService.getUser(email);

    // if(!user) {
    //   this.errorExists = true;
    //   this.errorText = "no registered user" + email;
    //   return;
    // }

    // // var isPassValid = this.userService.isPassOk(email, password);

    // // if(!isPassValid) {
    //   this.errorExists = true;
    //   this.errorText = "pass incorrect";
    //   return;
    // }

    // this.errorExists = false; //ukoliko je sve u redu ->
    // this.router.navigate(['']); //-> redirekcija na welcome komponentu

  }

}

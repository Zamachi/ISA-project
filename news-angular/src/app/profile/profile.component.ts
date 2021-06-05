import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Roles } from '../models/roles';
import { User } from '../models/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: User;

  errorExists = false;
  errorText = "";

  constructor() { }

  ngOnInit(): void {
    this.user = {
          id: "asdy89y78$Uuiashdiuaihuia$IOJAsjdow$",
          slug: "" ,
          username: "zamachi",
          password:"" ,
          email:"" ,
          dateCreated: new Date(),
          country: "",
          goldAmount: 10000,
          isActive: true,
          userRoles: new Array<Roles>()
        };
  }

  onSubmit(form: NgForm){
    console.log(this.user);

  }

}

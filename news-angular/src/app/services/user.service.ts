import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private client:HttpClient) { }

  registerUser(username: String, password: String, email: String, country: String){

    const url = "http://localhost:8080/user/createaccount"
    const user = {
      "username":username,
      "password":password,
      "email":email,
      "country":country
    };

    this.client.post<any>(url, user).subscribe();


  }



}

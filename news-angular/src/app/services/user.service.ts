import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private isLoggedIn = new BehaviorSubject<boolean>(false);

  constructor(private client:HttpClient) { }

  registerUser(username: String, password: String, email: String, country: String) : Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/user/createaccount"
    const user = {
      "username":username,
      "password":password,
      "email":email,
      "country":country
    };

    return this.client.post<any>(url, user);


  }

  logOnUser(username: String, password:String) : Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/auth/loginuser";
    const user ={
      "username":username,
      "password":password
    };

    return this.client.post<any>(url, user);
  }

  getIsLoggedOn() : BehaviorSubject<boolean>{
    return this.isLoggedIn;
  }

  log_user_in(){
    this.isLoggedIn.next(true);
  }

  log_user_out(){
    this.isLoggedIn.next(false);
  }

}

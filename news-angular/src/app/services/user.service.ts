import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private isLoggedIn = new BehaviorSubject<boolean>(false);
  private isAdmin = new BehaviorSubject<boolean>(false);
  private goldAmount = new BehaviorSubject<number>(-1);
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

    return this.client.post<any>(url, user, {observe: 'response'});
  }

  getIsLoggedOn() : BehaviorSubject<boolean>{

    if(localStorage.length > 0)
      this.log_user_in();

    return this.isLoggedIn;
  }

  log_user_in(){
    this.isLoggedIn.next(true);
  }

  log_user_out(){
    this.isLoggedIn.next(false);
  }

  getIsAdmin() : BehaviorSubject<boolean>{
    for (let index = 0; index < localStorage.length; index++) {
      if( localStorage.length>0 && localStorage.getItem("role-"+index) != null && localStorage.getItem("role-"+index).valueOf() == "ROLE_ADMIN" )
        this.make_admin();
    }

    return this.isAdmin;
  }

  make_admin(){
    return this.isAdmin.next(true);
  }
  remove_admin(){
    return this.isAdmin.next(false);
  }

  getGold() : BehaviorSubject<number>{

    if( (Number) (localStorage.getItem("goldAmount")) > -1){
      this.setGold((Number) (localStorage.getItem("goldAmount")));
    }

    return this.goldAmount;
  }

  setGold(number: number){
    this.goldAmount.next(number);
  }

  unsetGold(){
    this.goldAmount.next(-1);
  }



}

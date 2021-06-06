import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class SessionService {


  constructor() { }

  loadSession( response: any ){
    // console.log(response);

    localStorage.setItem("username", response.body.username.toString());
    localStorage.setItem("goldAmount", response.body.goldAmount?.toString());
    localStorage.setItem("token",response?.headers?.get("authorization"));
  }

  clearSession( ){
    localStorage.clear();
  }

}

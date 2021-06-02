import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class SessionService {


  constructor() { }

  loadSession( user: User ){
    localStorage.setItem("username", user.username.toString());
    localStorage.setItem("goldAmount", user.goldAmount?.toString());
  }

  clearSession( ){
    localStorage.clear();
  }

}

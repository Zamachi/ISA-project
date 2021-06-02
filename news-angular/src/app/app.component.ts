import { Component, OnInit } from '@angular/core';
import { SessionService } from './services/session.service';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  isLoggedIn$: any;

  constructor(
    private userService: UserService,
    private sessionService: SessionService){
  }

  ngOnInit(): void {
    // this.isLoggedIn = "true" == localStorage.getItem("isLoggedIn")?.toLowerCase();
    this.isLoggedIn$ = this.userService.getIsLoggedOn();
  }

  logout(){
    this.userService.log_user_out();
    this.sessionService.clearSession();
  }

  title = 'trade_store';
}

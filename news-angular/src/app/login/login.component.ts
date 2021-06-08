import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { SessionService } from '../services/session.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  errorExists = false;
  errorText = '';
  dataResponse: any;

  constructor(
    private router: Router,
    private userService: UserService,
    private _snackBar: MatSnackBar,
    private sessionService: SessionService,
    private route: Router
  ) {}

  ngOnInit(): void {}

  onSubmit(form: NgForm) {
    this.userService
      .logOnUser(form.value.username, form.value.password)
      .subscribe((data) => {
        console.log(data);
        if (data.body != null) {
          // console.log(data.headers.get("authorization"));

          this.dataResponse = data;
          this.sessionService.loadSession(this.dataResponse);
          this.userService.log_user_in();

          if(data.body.userRoles.find( role => (String) (role.roleName).toLowerCase() == 'role_admin'))
            this.userService.make_admin();

          this.route.navigate(['/home']);
        }
      })
      .add(() => {
        this.dataResponse == null
          ? this._snackBar.open("User doesn't exist!", 'Close', {
              duration: 3000,
            })
          : this._snackBar.open('Logged in!', 'Close', { duration: 3000 });
      });
      //NOTE: add se izvrsava nakon sto se unsubscribe-uje sa Observable-a
  }
}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';
import { AuthguardService } from './services/guards/authguard.service';
import { DoubleAuthGuardService } from './services/guards/double-auth-guard.service';
import { RoleGuardService } from './services/guards/role-guard.service';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent, canActivate : [ DoubleAuthGuardService ] },
  { path: 'login', component: LoginComponent, canActivate : [ DoubleAuthGuardService ] },
  { path: 'items', component: SearchComponent },
  { path: 'items/simpleSearch/:slug', component: SearchComponent },
  { path: 'items/search/:slug', component: SearchComponent },
  { path: 'admin-panel', component: AdminPanelComponent, canActivate: [AuthguardService, RoleGuardService] },
  { path: 'logout', component: LoginComponent },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthguardService] },
  { path: 'items/complexSearch/:complexSearch', component: SearchComponent },
  { path: "**", component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

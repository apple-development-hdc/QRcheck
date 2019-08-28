import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent} from './add/add.component';
import { CheckComponent} from './check/check.component';
import { FormComponent} from './form/form.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import {AuthGaurdService} from './service/auth-guard.service';
import { EmployeeinfoComponent } from './employeeinfo/employeeinfo.component';

const routes: Routes = [
{ path: 'login', component: LoginComponent },
    { path: 'logout', component: LogoutComponent , canActivate: [AuthGaurdService]},
    {path: 'create', component: FormComponent, canActivate: [AuthGaurdService]},
    {path: 'check', component: CheckComponent},
    {path: 'add', component: AddComponent, canActivate: [AuthGaurdService]},
  {path: 'edit/:id', component: FormComponent, canActivate: [AuthGaurdService]},
  {path: 'employee/:id', component: EmployeeinfoComponent, canActivate: [AuthGaurdService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

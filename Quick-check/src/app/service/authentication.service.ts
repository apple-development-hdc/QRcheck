import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }
  authenticate(username, password) {
    if (username === 'Admin' && password === 'admin123') {
      sessionStorage.setItem('username', username);
      return true;
    } else {
      return false;
    }
  }
  authenticateID(Emp_id) {
    if(Emp_id === '123') {
      sessionStorage.setItem('Emp_id',Emp_id);
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    const user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('username');
  }
}


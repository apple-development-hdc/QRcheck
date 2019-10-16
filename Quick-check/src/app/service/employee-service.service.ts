import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Employee } from '../model/Employee';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})

export class EmployeeServiceService {

    EmpUrl:string = 'http://localhost:3000/QRauth';

  constructor(private http:HttpClient) { }

  getEmployee(id):Observable<Employee> {
    
    return this.http.get<Employee>(`${this.EmpUrl}/${id}`);
  }

  putEmployee(employee:Employee):Observable<void> {
    console.log(employee);
    return this.http.put<void>(`${this.EmpUrl}/${employee.id}`, employee, httpOptions);
  }
  postEmployee(employee: Employee):Observable<any> {
    const url = `${this.EmpUrl}`;
    return this.http.post(url, employee, httpOptions);
  }

}


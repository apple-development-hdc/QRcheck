import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeServiceService } from '../service/employee-service.service';
import { Employee } from '../model/Employee';
@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
})
export class AddComponent implements OnInit {
  employee : Employee ={
    id: 0,
    Name: null,
    AssetId: null,
    SerialTag: null,
    StartDate: null ,
    EndDate: null ,
    Email: null,}

  constructor(private router: Router,
              private employeeservice: EmployeeServiceService) { }

  ngOnInit() {
  }

 putemployee(){
 this.employeeservice.postEmployee(this.employee).subscribe();
  this.router.navigate(['edit', this.employee.id]);
 }
}

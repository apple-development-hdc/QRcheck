import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeServiceService } from '../service/employee-service.service';

@Component({
  selector: 'app-check',
  templateUrl: './check.component.html',
  styleUrls: ['./check.component.css']
})
export class CheckComponent implements OnInit {

  constructor(private router: Router,
    private employeeservice : EmployeeServiceService) { }

  ngOnInit() {
  }
  checkID(Emp_ID: number){
this.router.navigate(['employee',Emp_ID])
}
}

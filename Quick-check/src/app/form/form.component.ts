import { Component, OnInit,EventEmitter, Output } from '@angular/core';
import { EmployeeServiceService } from '../service/employee-service.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../model/Employee';
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor (private employeeService:EmployeeServiceService,
    private route: Router,
    private router :ActivatedRoute) {

    }
    error:any = {isError:false,errorMessage:""};
    isValidDate:any;

    employee : Employee ;
  ngOnInit() {const id = this.router.snapshot.params['id'];
              this.getEmployee(id);
           }

  getEmployee(id){
    this.employeeService.getEmployee(id).subscribe(
      (employee) => this.employee = employee)
  }
  putEmployee(): void {
    var date1 = new Date(this.employee.StartDate);
var date2 = new Date(this.employee.EndDate);
this.isValidDate=this.validateDates(date1,date2);
if(this.isValidDate){
    this.employeeService.putEmployee(this.employee).subscribe();
    console.log('abc');
    this.route.navigate(['add']);
    console.log('def');
  }}
  validateDates(sDate:Date,eDate:Date){
    var date3 = new Date();
    this.isValidDate = true;
    if(sDate>eDate){
      this.error.isError=true;
      this.error.errorMessage='End Date shpuld be greater than starting Date';
      this.isValidDate=false;
    }
    if (sDate > this.addMonths(date3,1) && eDate > this.addMonths(date3,6) ){
      this.error.isError=true;
      this.error.errorMessage='Enter date in a span of 6 months';
      this.isValidDate=false;
    }
    return this.isValidDate;
  }
  addMonths(thedate: Date, months: number){
    return new Date(thedate.getTime() + months*30*24*60*60*1000);
 }
}

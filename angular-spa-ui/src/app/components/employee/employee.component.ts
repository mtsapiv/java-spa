import { Component, OnInit } from '@angular/core';

export interface Department {
  id: number;
  name: string;
}
export interface Employee {
  id: number;
  name: string;
  isActive: boolean;
  department: Department;
}

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employee: Employee = { id: 1, name: 'Test1', isActive: true, department: {id: 2, name: 'Tech'}};

  constructor() { }

  ngOnInit() {
  }

}

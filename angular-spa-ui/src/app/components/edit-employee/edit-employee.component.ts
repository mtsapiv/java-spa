import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';

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
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit, OnChanges {

  employee: Employee = { id: 1, name: 'Test1', isActive: true, department: {id: 2, name: 'Tech'}};

  @Input()
  id;
  @Input()
  action;

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges): void {
  }


}

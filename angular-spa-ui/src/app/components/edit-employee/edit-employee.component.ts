import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {EmployeeService} from '../../services/employee.service';
import {EmployeeUpdate} from '../../app.models';

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

  @Input()
  id;
  @Input()
  action;

  departments;

  isActive = [true, false];

  @Output()
  closeEditAction = new EventEmitter<string>();


  employee: any;


  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.getDepartments();
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.getEmployee();
  }

  getDepartments() {
    this.employeeService.getDepartments()
        .subscribe(
            result => {
              this.departments = result;
            }
        );
  }

  getEmployee() {
    this.employeeService.getEmployeeById(this.id)
        .subscribe(result => {
          this.employee = result;
        });
  }

  close() {
    this.action = 'close-edit';
    this.closeEditAction.emit(this.action);
  }

  setNewEmployee(id, name, isActive, departmentId) {
    let updEmploye: EmployeeUpdate = {
      id: id,
      name: name,
      isActive: isActive,
      departmentId: departmentId
    };

    this.employeeService.updateEmployee(updEmploye)
        .subscribe(
            result => {
              this.close();
            }
        );
  }


}

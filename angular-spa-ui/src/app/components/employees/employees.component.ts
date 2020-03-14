import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource, PageEvent} from '@angular/material';
import {EmployeeService} from '../../services/employee.service';
import {Employee} from '../../app.models';


@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  id: number;

  action: string;

  employees: any = [];

  pageSize = 5;

  pageIndex = 0;

  length = 200;

  @Output()
  startAction = new EventEmitter<{id: number, action: string}>();

  displayedColumns: string[] = ['id', 'name', 'isActive', 'department.name', 'actions'];
  dataSource = new MatTableDataSource<Employee>(this.employees);

  // @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private employeeService: EmployeeService) {}

  getEmployees(event?: PageEvent) {


    this.employeeService.getAllEmployees(this.pageIndex, this.pageSize)
        .subscribe(
            result => {
              this.employees = result;
              console.log(this.employees);
              this.dataSource = new MatTableDataSource<Employee>(this.employees);
              this.pageIndex = 0;
              this.pageSize = 10;
              this.length = 200;

            }
        );
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.getEmployees(null);
  }

  edit(id) {
    this.id = id;
    this.action = 'edit';
    this.startAction.emit({id: this.id, action: this.action});
  }

  view(id) {
    this.id = id;
    this.action = 'view';
    this.startAction.emit({id: this.id, action: this.action});
  }

  delete(id) {

  }
}


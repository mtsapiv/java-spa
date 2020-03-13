import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';


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

const ELEMENT_DATA: Employee[] = [
  {id: 1, name: 'Test1', isActive: true, department: {id: 2, name: 'Tech'}},
  {id: 2, name: 'Test2', isActive: true, department: {id: 2, name: 'Tech'}},
  {id: 3, name: 'Test3', isActive: true, department: {id: 2, name: 'Tech'}},
];

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  id: number;

  action: string;
ç
  @Output()
  startAction = new EventEmitter<{id: number, action: string}>();

  displayedColumns: string[] = ['id', 'name', 'isActive', 'department.name', 'actions'];
  dataSource = new MatTableDataSource<Employee>(ELEMENT_DATA);

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
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


import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource, PageEvent} from '@angular/material';
import {EmployeeService} from '../../services/employee.service';
import {Employee} from '../../app.models';


@Component({
    selector: 'app-employees',
    templateUrl: './employees.component.html',
    styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit, OnChanges {

    id: number;

    action: string;

    employees: any = [];

    pageSize = 5;

    pageIndex = 0;

    length;

    pageEvent: PageEvent;

    name = '';


    @Output()
    startAction = new EventEmitter<{id: number, action: string}>();

    displayedColumns: string[] = ['id', 'name', 'isActive', 'department.name', 'actions'];
    dataSource = new MatTableDataSource<Employee>(this.employees);

    // @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

    constructor(private employeeService: EmployeeService) {}


    getEmployeesPage(event?: PageEvent) {

        console.log(this.pageIndex);
        if (this.name === '') {
            this.employeeService.getAllEmployees(event.pageIndex, event.pageSize)
                .subscribe(
                    result => {
                        this.employees = result.content;
                        this.dataSource = new MatTableDataSource<Employee>(this.employees);
                        this.pageIndex = result.number;
                        this.pageSize = result.size;
                        this.length = result.totalElements;

                    }
                );
        } else {
            this.employeeService.getAllEmployeesByName(event.pageIndex, event.pageSize, this.name)
                .subscribe(
                    result => {
                        this.employees = result.content;
                        this.dataSource = new MatTableDataSource<Employee>(this.employees);
                        this.pageIndex = result.number;
                        this.pageSize = result.size;
                        this.length = result.totalElements;

                    }
                );
        }

    }


    getEmployees() {

        this.employeeService.getAllEmployees(this.pageIndex, this.pageSize)
            .subscribe(
                result => {
                    this.employees = result.content;
                    this.dataSource = new MatTableDataSource<Employee>(this.employees);
                    this.pageIndex = result.number;
                    this.pageSize = result.size;
                    this.length = result.totalElements;

                }
            );
    }

    ngOnChanges(changes: SimpleChanges): void {
        this.getEmployees();
    }

    ngOnInit() {
        this.dataSource.paginator = this.paginator;
        this.getEmployees();
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
        this.employeeService.deleteEmployee(id)
            .subscribe(
                result => {
                    this.getEmployees();
                }
            );
    }

    getEmployeesByName() {

        console.log(this.name);
        this.employeeService.getAllEmployeesByName(this.pageIndex, this.pageSize, this.name)
            .subscribe(
                result => {
                    this.employees = result.content;
                    this.dataSource = new MatTableDataSource<Employee>(this.employees);
                    this.pageIndex = result.number;
                    this.pageSize = result.size;
                    this.length = result.totalElements;
                }
            );
    }
}


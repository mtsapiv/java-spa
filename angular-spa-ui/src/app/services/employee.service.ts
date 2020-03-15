import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Employee, EmployeeUpdate} from '../app.models';
import {Observable} from 'rxjs';


@Injectable({
    providedIn: 'root'
})
export class EmployeeService {

    constructor(private http: HttpClient) { }

    getAllEmployees(page, size): Observable<any> {
        return this.http.get(environment.employees + '?page=' + page + '&size=' + size);
    }

    getAllEmployeesByName(page, size, name): Observable<any> {
        return this.http.get(environment.employees + '/find?page=' + page + '&size=' + size + '&name=' + name);
    }

    getEmployeeById(id): Observable<any> {
        return this.http.get(environment.employee + '?id=' + id);
    }

    deleteEmployee(id): Observable<any> {
        return this.http.delete(environment.employee + '?id=' + id);
    }

    updateEmployee(employee: EmployeeUpdate): Observable<any> {
        return this.http.put(environment.employee, employee);
    }

    createEmployee(employee: Employee): Observable<any> {
        return this.http.post(environment.employee, employee);

    }

    getDepartments(): Observable<any> {
        return this.http.get(environment.departments);
    }
}


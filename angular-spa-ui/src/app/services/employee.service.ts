import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Employee, EmployeeUpdate} from '../app.models';
import {Observable} from 'rxjs';


@Injectable({
    providedIn: 'root'
})
export class EmployeeService {

    constructor(private http: HttpClient) { }

    createHeaders() {
        const username = sessionStorage.getItem('username');
        const password = sessionStorage.getItem('password');
        const headers = new  HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
        return headers;

    }

    getAllEmployees(page, size): Observable<any> {

        const headers = this.createHeaders();

        return this.http.get(environment.employees + '?page=' + page + '&size=' + size, {headers});
    }

    getAllEmployeesByName(page, size, name): Observable<any> {
        const headers = this.createHeaders();

        return this.http.get(environment.employees + '/find?page=' + page + '&size=' + size + '&name=' + name, {headers});
    }

    getEmployeeById(id): Observable<any> {
        const headers = this.createHeaders();

        return this.http.get(environment.employee + '?id=' + id, {headers});
    }

    deleteEmployee(id): Observable<any> {
        const headers = this.createHeaders();

        return this.http.delete(environment.employee + '?id=' + id, {headers});
    }

    updateEmployee(employee: EmployeeUpdate): Observable<any> {
        const headers = this.createHeaders();

        return this.http.put(environment.employee, employee, {headers});
    }

    createEmployee(employee: Employee): Observable<any> {
        const headers = this.createHeaders();

        return this.http.post(environment.employee, employee, {headers});

    }

    getDepartments(): Observable<any> {
        const headers = this.createHeaders();

        return this.http.get(environment.departments, {headers});
    }
}


import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Employee} from '../app.models';


@Injectable({
    providedIn: 'root'
})
export class EmployeeService {

    constructor(private http: HttpClient) { }

    getAllEmployees(page, size) {
        return this.http.get(environment.employees + '?page=' + page + '&size=' + size);
    }

    getAllEmployeesByName(page, size, name) {
        return this.http.get(environment.employees + '?page=' + page + '&size=' + size + '&name=' + name);
    }

    getEmployeeById(id) {
        return this.http.get(environment.employee + '?id=' + id);
    }

    deleteEmployee(id) {
        return this.http.delete(environment.employee + '?id=' + id);
    }

    updateEmployee(employee: Employee) {
        return this.http.put(environment.employee, employee);
    }

    createEmployee(employee: Employee) {
        return this.http.post(environment.employee, employee);

    }
}


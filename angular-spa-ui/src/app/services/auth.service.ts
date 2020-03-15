import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }

    public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    return !!token;
  }
}

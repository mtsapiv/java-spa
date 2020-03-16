export interface Employee {
  id: number;
  name: string;
  isActive: boolean;
  department: string;
}


export interface EmployeeUpdate {
  id: number;
  name: string;
  isActive: boolean;
  departmentId: number;
}

export interface Department {
  id: number;
  name: string;
}

export interface User {
  username: string;
  password: string;
}

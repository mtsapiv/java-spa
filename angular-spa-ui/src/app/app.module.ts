import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EmployeesComponent } from './components/employees/employees.component';
import { EmployeeComponent } from './components/employee/employee.component';
import {
  MatButtonModule,
  MatCardModule, MatDividerModule, MatFormFieldModule, MatGridListModule, MatIconModule, MatInputModule, MatListModule, MatOptionModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatSelectModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {RouterModule, Routes} from '@angular/router';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { MainComponent } from './components/main/main.component';
import { EditEmployeeComponent } from './components/edit-employee/edit-employee.component';
import {FormsModule} from '@angular/forms';
import { NotFoundComponent } from './components/not-found/not-found.component';

const appRoutes: Routes = [
  { path: 'employees', component: EmployeesComponent },
  { path: 'employee/:id',      component: EmployeeComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    EmployeeComponent,
    ToolbarComponent,
    MainComponent,
    EditEmployeeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    MatToolbarModule,
    MatCardModule,
    MatProgressBarModule,
    MatFormFieldModule,
    MatOptionModule,
    MatSelectModule,
    MatButtonModule,
    MatInputModule,
    MatDividerModule,
    MatListModule,
    MatGridListModule,
    MatIconModule,
    RouterModule.forRoot(
        appRoutes,
        { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  action: string;
  id: number;
  showEdit: boolean;
  showView: boolean;

  constructor() { }

  ngOnInit() {
  }

  getAction(data) {
    this.id = data.id;
    this.action = data.action;
    if (this.action === 'view') {
      this.showView = true;
      this.showEdit = false;
    } else {
      this.showView = false;
      this.showEdit = true;
    }
  }
}

import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-food-search',
  templateUrl: './food-search.component.html',
  styleUrls: ['./food-search.component.css']
})

export class FoodSearchComponent implements OnInit {
 
  @Output() searchEmitter: any; 
  
  searchString: string ="";
  constructor() {
    this.searchEmitter = new EventEmitter();  
   }

  ngOnInit() {
  }

  filterData() {
    this.searchEmitter.emit(this.searchString);
  }

}

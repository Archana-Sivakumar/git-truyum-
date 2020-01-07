import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FoodItem } from '../foodItem';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {
  
  @Input() menuItem:any;
  @Input() userRoleName:string;
  @Input() addedItemId: number;
  @Input() cartMsg: boolean;

  @Output() addCart:any;
  @Output() editEmitter: any;
  
  constructor() {
    this.addCart = new EventEmitter;
    this.editEmitter = new EventEmitter();
   }

  ngOnInit() {
  }

  addToCart(id) {
    this.addCart.emit(id); 
  }

  editMenuItem(id){
    this.editEmitter.emit(id);
  }
}

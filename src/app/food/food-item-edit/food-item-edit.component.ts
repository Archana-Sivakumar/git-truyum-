import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodService } from '../food.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-food-item-edit',
  templateUrl: './food-item-edit.component.html',
  styleUrls: ['./food-item-edit.component.css']
})

export class FoodItemEditComponent implements OnInit {

  foodItem: any;
  id:any;
  foodItemForm : any;
  editMsg: boolean = false;
  activeStatus = "No";
  freeDeliveryStatus = "No";
  constructor(private router: ActivatedRoute,private foodService:FoodService) {

    this.foodItemForm = new FormGroup({
      "itemName" : new FormControl(""),
      "price" : new FormControl(""),
      "dateOfLaunch" : new FormControl(""),
      "category" : new FormControl(""),
      "active" : new FormControl(""),
      "freeDelivery" : new FormControl("")
      
    })
  }

  ngOnInit() {

      let activeStatus = false;
      let  freeDeliveryStatus =  false;

      this.router.paramMap.subscribe(params=> {
      this.id = params.get("itemId");
      })
      this.foodService.getMenuItem(this.id).subscribe((response) =>{
      this.foodItem = response;

      if(this.foodItem.active=="Yes") {
        activeStatus =true
     }
     if(this.foodItem.freeDelivery=="Yes") {
      freeDeliveryStatus =true
     }

    
      this.foodItemForm = new FormGroup({
        "itemName" : new FormControl(this.foodItem.itemName,[Validators.required,Validators.minLength(2)]),
        "price" : new FormControl(this.foodItem.price,[Validators.required]),
        "dateOfLaunch" : new FormControl(this.foodItem.dateOfLaunch,[Validators.required]),
        "category" : new FormControl(this.foodItem.category),
        "active" : new FormControl(activeStatus),
        "freeDelivery" : new FormControl(freeDeliveryStatus),
      })
    });
     
  }
  
  updateFoodItem(id,foodItemForm) {

    if(foodItemForm.active==true) {
      this.activeStatus ="Yes"
    }
    if(foodItemForm.freeDelivery==true) {
      this.freeDeliveryStatus ="Yes"
    }

    let edittedItem:any={
      id : id,
      itemName: foodItemForm.itemName,
	    price :foodItemForm.price,
	    active : this.activeStatus,
		  dateOfLaunch : foodItemForm.dateOfLaunch,
		  category : foodItemForm.category,
      freeDelivery : this.freeDeliveryStatus,
      imageUrl: this.foodItem.imageUrl
    }
    this.foodService.updateMenuItem(edittedItem).subscribe(response=>{
    this.editMsg = true;
    })
  }  
 
}

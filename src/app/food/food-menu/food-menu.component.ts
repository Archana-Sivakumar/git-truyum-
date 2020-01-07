import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/site/auth.service';
import { CartService } from 'src/app/shopping/cart.service';

@Component({
  selector: 'app-food-menu',
  templateUrl: './food-menu.component.html',
  styleUrls: ['./food-menu.component.css']
})
export class FoodMenuComponent implements OnInit {
  
  foodItem:any;
  filteredMenuItemList: any;
  userRoleName: string;
  cartMsg: boolean = false;
  addedItemId: number;
  
  constructor(private foodService:FoodService,private cartService:CartService,private router: Router,private authService:AuthService) {
     this.userRoleName = this.authService.userName;
  }
 
  ngOnInit() {

    this.foodService.getFoodItems()
        .subscribe((response)=>{
            this.foodItem = response;
            this.filteredMenuItemList =  this.foodItem;
    });
     
  }

  search(searchString) {
    let filterFood = searchString.toLocaleLowerCase();
    this.filteredMenuItemList = this.foodService.getFilterFood(this.foodItem,filterFood);
  }
  
  addToCart(id) {
    if(this.authService.isLoggedIn()) {
        this.cartService.addToCartItem(id).subscribe((response)=>{
        this.cartMsg = true;
        this.addedItemId = id;
     });
     
    }
    else{
      this.authService.anonymousUserStatus(true);
      this.router.navigate(["login"]);
    }
  }

  editMenuItem(id) {
    this.router.navigate(['edit-item',id]);
  }

}

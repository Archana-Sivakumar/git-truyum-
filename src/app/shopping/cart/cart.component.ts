import { Component, OnInit} from '@angular/core';
import { CartService } from '../cart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartItem: any;
  total : number;
  cartMsg: boolean = false;
  error: string;

  constructor(private cartService:CartService,private router: Router) { 
      cartService. getCartList().subscribe((response)=>{
      this.cartItem = response;
    
      this.total = cartService.calculateTotal(this.cartItem);
      },(responseError) => 
      this.error=(responseError.error.message));
  }

  ngOnInit() {
  }
 
  removeFromCart(id) {
    
      this.cartService.deleteCartItem(id).subscribe((response)=>{
      this.cartItem = response;
      this.total = this.cartService.calculateTotal(this.cartItem); 
      this.cartMsg = true;
    });

  }

}

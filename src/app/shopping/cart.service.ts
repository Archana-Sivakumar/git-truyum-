import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from '../site/auth.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  
  constructor(private httpClient:HttpClient,private authService:AuthService) { 
  }

  addToCartItem(id) {

    let token = 'Bearer '+this.authService.getToken();
    let user = this.authService.getRole();
    const httpOptions ={
      headers: new HttpHeaders({
         'Content-Type': 'application/json',
         'Authorization': token
      })
    };
    return this.httpClient.post(environment.baseUrl+"/menuitem-service/truyum/cart-items/"+user+ "/"+id,{},httpOptions)

  }
  
  getCartList(){

    let token = 'Bearer '+this.authService.getToken();
    let user = this.authService.getRole();
    const httpOptions ={
      headers: new HttpHeaders({
         'Content-Type': 'application/json',
         'Authorization': token
      })
    };
    return this.httpClient.get(environment.baseUrl+"/menuitem-service/truyum/cart-items/"+user, httpOptions)

  }
   
  calculateTotal(cartItem) {

    let total=0;
    for(let i=0;i<cartItem.length;i++) {
      total +=cartItem[i].price;
    }
    return total;

  }

  deleteCartItem(id){

    let token = 'Bearer '+this.authService.getToken();
    let user = this.authService.getRole();
    const httpOptions ={
      headers: new HttpHeaders({
         'Content-Type': 'application/json',
         'Authorization': token
      })
    };
    return this.httpClient.delete(environment.baseUrl+"/menuitem-service/truyum/cart-items/"+user+ "/"+id,httpOptions)
    
  }

}

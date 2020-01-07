import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../site/auth.service';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private httpClient:HttpClient,private authService:AuthService) {}

  getFoodItems():Observable<any>{

      if(this.authService.userName == 'anonymous') {

        return this.httpClient.get(environment.baseUrl+"/menuitem-service/truyum/menu-items");

      } else{

            let token = 'Bearer '+this.authService.getToken();
            const httpOptions ={
              headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': token
              })
            };
            
            return this.httpClient.get(environment.baseUrl+"/menuitem-service/truyum/menu-items", httpOptions);
      }
  }

  getFilterFood(foodItem,filterFood) {
     return foodItem.filter((menu) => menu.itemName.toLocaleLowerCase().indexOf(filterFood)!= -1);
  }

  getMenuItem(id){

    let token = 'Bearer '+this.authService.getToken();
    const httpOptions ={
      headers: new HttpHeaders({
         'Content-Type': 'application/json',
         'Authorization': token
      })
    };
    return this.httpClient.get(environment.baseUrl+"/menuitem-service/truyum/menu-items/"+id, httpOptions);
  }

  updateMenuItem(edittedItem) {

    let token = 'Bearer '+this.authService.getToken();
    const httpOptions ={
      headers: new HttpHeaders({
         'Content-Type': 'application/json',
         'Authorization': token
      })
    };
    return this.httpClient.put(environment.baseUrl+"/menuitem-service/truyum/menu-items",edittedItem,httpOptions);
  }

}

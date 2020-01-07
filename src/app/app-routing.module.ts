import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FoodMenuComponent } from './food/food-menu/food-menu.component';
import { CartComponent } from './shopping/cart/cart.component';
import { FoodItemEditComponent } from './food/food-item-edit/food-item-edit.component';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { AuthGuard } from './site/auth.guard';


const routes: Routes = [
  {path: "", component: FoodMenuComponent},
  {path: "food-menu", component: FoodMenuComponent},
  {path: "edit-item",component: FoodItemEditComponent,canActivate:[AuthGuard]},
  {path: "cart-item", component: CartComponent,canActivate:[AuthGuard]},
  {path: "edit-item/:itemId", component: FoodItemEditComponent,canActivate:[AuthGuard]},
  {path: "signup", component: SignupComponent},
  {path: "login", component: LoginComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FoodMenuComponent } from './food/food-menu/food-menu.component';
import { FoodItemComponent } from './food/food-item/food-item.component';
import { FoodSearchComponent } from './food/food-search/food-search.component';
import { CartComponent } from './shopping/cart/cart.component';
import { FoodItemEditComponent } from './food/food-item-edit/food-item-edit.component';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { HeaderComponent } from './header/header.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    FoodMenuComponent,
    FoodItemComponent,
    FoodSearchComponent,
    CartComponent,
    FoodItemEditComponent,
    SignupComponent,
    LoginComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

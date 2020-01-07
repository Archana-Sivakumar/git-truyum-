import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isAnonymousUser: boolean = false;
  name : string = '';
  password: string = '';
  errorMsg: boolean = false;

  constructor(private router:Router,private authservice:AuthService) {
    this.isAnonymousUser = this.authservice.isAnonymous;
  }

  ngOnInit() {
  }
 
  loginDetails() {
  
      this.authservice.authenticate(this.name,this.password).subscribe((response) => {
      
         this.authservice.setToken(response.token);
         this.authservice.setRole(response.role);
         this.authservice.logIn();
         this.authservice.getUserList(this.name);
         this.router.navigate(["/food-menu"]);
       },
       (responseError) =>
       this.errorMsg = true); 
  }

}

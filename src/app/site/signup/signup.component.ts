import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit {

  signupForm : any;
  signupStatus: boolean = false;
  error: string;
  
  constructor(private userService: UserService,private router:Router) { }

  ngOnInit() {

      this.signupForm = new FormGroup({
        "userName" : new FormControl("",[Validators.required,Validators.maxLength(10),Validators.minLength(2)]),
        "firstName" :new FormControl("",[Validators.required,Validators.maxLength(10),Validators.minLength(2)]),
        "lastName" : new FormControl("",[Validators.required]),
        "password" :new FormControl("",[Validators.required,Validators.minLength(3)]),
        "confirmPassword" :new FormControl("",[Validators.required])
      })
  }

  addUser(signupForm) {

     if(signupForm.password!= signupForm.confirmPassword) {
        this.signupStatus = true;
     } else {
  
            let signupDetails:any ={
              userName : signupForm.userName,
              firstName : signupForm.firstName,
              lastName : signupForm.lastName,
              password : signupForm.password,
              confirmPassword : signupForm.confirmPassword,
            }
            
            this.userService.addUserList(signupDetails).subscribe((response)=>{
              this.router.navigate(["/login"]);
          },(responseError) => 
            this.error=(responseError.error.message)); 
      }
  }

}
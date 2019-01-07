import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {User} from '../../user';
import {Router} from '@angular/router';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.css']
})
export class ListuserComponent implements OnInit {
  users:User[] = [];
  constructor(private _userService:UserService, private _router:Router) { }

  ngOnInit() {
    this._userService.getUsers().subscribe((users:User[])=>{
      console.log(users);
      this.users= users;
    },(error)=>{
      console.log(error);
    })
  }

  updateUser(user){
    //this._userService.updateUser(user).subscribe((users))
    this._userService.setter(user);
    this._router.navigate(['/op']);
  }

  createUser(){
    //this._userService.createUser(user).subscribe((users))
    let user = new User();
    this._userService.setter(user);
    this._router.navigate(['/op']);
  }
}

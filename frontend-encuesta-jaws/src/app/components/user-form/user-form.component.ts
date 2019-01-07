import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {User} from '../../user';
import {Router} from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  user:User;
  languages: string[] = ['JAVA', 'C#'];
  constructor(private _userService:UserService, private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
  }

  processForm(){
    if(this.user.id==undefined){
      this._userService.createUser(this.user).subscribe((user)=>{
        console.log(user);
        swal({
          position: 'top',
          type: 'success',
          title: `Su voto ha sido registrado con éxito`,
          showConfirmButton: false,
          timer: 1500
        });

      this.user.nombres = '';
      this.user.apellidos = '';
      this.user.edad = null;
      this.user.eleccion = null;
        //this._router.navigate(['/']);
      },(error)=>{
        console.log(error);
      })
    }else{
      this._userService.updateUser(this.user).subscribe((user)=>{
        console.log(user);
        swal({
          position: 'top',
          type: 'success',
          title: `El registro se ha actualizado con éxito`,
          showConfirmButton: false,
          timer: 1500
        });
        this._router.navigate(['/']);
      },(error)=>{
        console.log(error);
      })
    }
  }

}

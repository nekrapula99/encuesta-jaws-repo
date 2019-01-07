import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from '../user'

@Injectable({
  providedIn: 'root'
})
export class UserService {
  //Actualizar con el DNS que em entrega mi instancia en AWS
  //private baseUrl:string = 'http://localhost:8090/encuesta';
  private baseUrl:string = 'https://jo6tas47ne.execute-api.us-east-1.amazonaws.com/prod/encuesta';
  //private baseUrl:string = 'http://ec2-3-87-41-40.compute-1.amazonaws.com:8090/encuesta';
  //private baseUrl:string = 'http://balancer-encuesta-593375171.us-east-1.elb.amazonaws.com/encuesta';

  private headers = new Headers({'Content-Type':'application/json'});
  //private options = new RequestOptions({headers:this.headers});
  private user =new User();

  constructor(private httpClient: HttpClient) { }

  getUsers(){
    return this.httpClient.get(this.baseUrl+'/users') //,this.options
    //.map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  
  createUser(user:User){
    return this.httpClient.post(this.baseUrl+'/user',user);
    //.map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  updateUser(user:User){
    return this.httpClient.put(this.baseUrl+'/user',user);
    //.map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  errorHandler(error:Response){
    //return Observable.throw(error||"SERVE ERROR")
  }

  setter(user:User){
    this.user=user;

  }
  getter(){
    return this.user;
  }

}

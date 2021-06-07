import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RolesService {

  constructor(
    private http: HttpClient
  ) { }

  findAllRoles(){

    const url = "http://localhost:8080/roles/getallroles";

    return this.http.get<any>(url,{observe: 'response'});
  }

  createRole(role: any):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/roles/createrole";

    console.log(role);

    return this.http.post<any>(url,role);
  }

  updateRole(quality: any):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/roles/updaterole";

    return this.http.put<any>(url,quality);
  }

  deleteRole(Id: string):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/roles/deleterole/" +Id;

    return this.http.delete<any>(url);
  }


}

import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TraitService {

  constructor(
    private http: HttpClient
  ) { }

  findAllTraits():Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/traits/getalltraits";

    return this.http.get<any>(url, {observe: "response"});
  }

  createTrait(trait: any):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/traits/createtrait";

    return this.http.post<any>(url,trait);
  }

  updateTrait(trait: any):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/traits/updatetrait";

    // console.log(trait);

    return this.http.put<any>(url,trait);
  }

  deleteTrait(Id: string):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/traits/deletetrait/" +Id;
    // console.log(Id);

    return this.http.delete<any>(url);
  }

}

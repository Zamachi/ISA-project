import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }

  findAllCategories():Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/category/findallcategories";

    return this.http.get<any>(url,{observe: 'response'});
  }
}

import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }

  findAllCategories():Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/category/findallcategories";

    return this.http.get<any>(url,{observe: 'response'});
  }

  createCategory(category: any):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/category/createcategory";

    console.log(category);


    return this.http.post<any>(url,category);
  }

  updateCategory(category: any):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/category/updatecategory";

    return this.http.put<any>(url,category);
  }

  deleteCategory(Id: string):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/category/deletecategorybyid/" +Id;

    return this.http.delete<any>(url);
  }


}

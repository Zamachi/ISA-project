import { HttpClient, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QualityService {

  constructor(private http: HttpClient) { }

  findAllQualities(){

    const url = "http://localhost:8080/quality/getallqualities";

    return this.http.get<any>(url,{observe: 'response'});
  }

  createCategory(quality: any):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/quality/createquality";

    console.log(quality);


    return this.http.post<any>(url,quality);
  }

  updateCategory(quality: any):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/quality/updatequality";

    return this.http.put<any>(url,quality);
  }

  deleteCategory(Id: string):Observable<HttpResponse<any>>{

    const url = "http://localhost:8080/quality/deletequality/" +Id;

    return this.http.delete<any>(url);
  }

}

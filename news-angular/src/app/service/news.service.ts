import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewsModel } from '../model/NewsModel';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  constructor(private http: HttpClient) {

  }

  public findAll() : Observable<HttpResponse<NewsModel[]>> {
    return this.http.get<NewsModel[]>("http://localhost:8080/news/findall", {observe: "response"});
  }
}

import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {

  constructor(private http: HttpClient) { }

  public findAllCountries() : Observable<HttpResponse<any[]> >{
    return this.http.get<any[]>("https://restcountries.eu/rest/v2/all", { observe: "response"} );
  }
}

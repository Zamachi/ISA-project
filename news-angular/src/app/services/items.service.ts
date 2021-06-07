import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  constructor(private client: HttpClient) { }

  public findAll(): Observable<HttpResponse<Item[]>>{
    var headers_object = new HttpHeaders().set("Content-Type",'application/json');//.set("Authorization",localStorage.getItem("token") ? "Bearer "+localStorage.getItem("token"):"");

    return this.client.get<Item[]>("http://localhost:8080/items/findallitems", {observe: "response", headers: headers_object});
  }

  public findAllBySlug(slug: string) : Observable<HttpResponse<Item[]>>{
    let data = new HttpParams().set("slug", slug);
    return this.client.get<Item[]>("http://localhost:8080/items/finditemsbyslug", {observe: "response", params: data });
  }

  public findAllByItemName(ItemName: string) : Observable<HttpResponse<Item[]>>{

    var headers_object = new HttpHeaders();
    headers_object.append('Content-Type', 'application/json');
    headers_object.append("Authorization", "Basic " + btoa("petar:admin"));

    let data = new HttpParams().set("ItemName", ItemName);
    return this.client.get<Item[]>("http://localhost:8080/items/finditemsbyname", {observe: "response", params: data, headers: headers_object });

  }

  public buyItem(username: String, item_id: String){

    const url = "http://localhost:8080/items/buyitem";

    const body = {
      "username": username,
      "item_id": item_id
    };

    return this.client.post<any>(url, body, { observe: 'response' });
  }

  public createItem(item: any){
    const url = "http://localhost:8080/items/additem";


    return this.client.post<any>(url, item, { observe: 'response' });
  }

  public findMyItems(username: string){

    const url = "http://localhost:8080/items/fetchuserpurchases/" + username;


    return this.client.get<any>(url, { observe: 'response' });

  }

}

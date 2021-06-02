import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { Item } from '../models/item';
import { ItemsService } from '../services/items.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit, AfterViewInit {

  items = new MatTableDataSource<Item>();
  ItemName: String;
  slug: String;
  displayedColumns = [
    "itemName",
    "level",
    "owner",
    "dateCreated",
    "basePrice",
    "amount",
    "total"
  ];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private activeRoute: ActivatedRoute, private itemService: ItemsService) { }

  ngAfterViewInit(): void {
    this.items.sort = this.sort;
    this.items.paginator = this.paginator;
  }

  ngOnInit(): void {
    this.activeRoute.params.subscribe(value => {
      this.ItemName = value['ItemName'];
      this.slug = value['slug'];
    })

    if(this.ItemName != undefined && this.ItemName != ''){
      this.findAllByItemName;
    }
    else if(this.slug != undefined && this.slug != ''){

      this.findAllBySlug();
    }else{
      this.findAll();
    }
  }

  private findAll() : any {
    return this.itemService.findAll().subscribe(value => { this.items.data = value.body;  });
  }

  private findAllBySlug() : any {
    return this.itemService.findAllBySlug(this.slug.toString()).subscribe(value => { this.items.data = value.body as Item[]; });
  }
  private findAllByItemName() : any {
    return this.itemService.findAllByItemName(this.ItemName.toString()).subscribe(value => { this.items.data = value.body as Item[]; });
  }

  doFilter(filterValue: string){
    this.items.filter = filterValue.trim().toLowerCase();
  }

}

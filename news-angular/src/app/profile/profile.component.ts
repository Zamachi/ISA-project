import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Category } from '../models/category';
import { Item } from '../models/item';
import { Quality } from '../models/quality';
import { Roles } from '../models/roles';
import { Trait } from '../models/trait';
import { User } from '../models/user';
import { CategoryService } from '../services/category.service';
import { ItemsService } from '../services/items.service';
import { QualityService } from '../services/quality.service';
import { TraitService } from '../services/trait.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit, AfterViewInit {
  user: User;

  errorExists = false;
  errorText = '';

  traits: Array<Trait>;
  qualities: Array<Quality>;
  categories: any;

  //NOTE: item variables

  item_name: String;
  basePrice: Number;
  category: Category;
  amount: Number;
  owner: String;
  level: Number;
  trait: Trait;
  quality: Quality;

  //NOTE: item variables

  purchases = new MatTableDataSource<Item>();
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

  constructor(
    private categoryService: CategoryService,
    private traitService: TraitService,
    private qualityService: QualityService,
    private itemService: ItemsService,
    private snackBar: MatSnackBar
  ) {}
  ngAfterViewInit(): void {
    this.purchases.sort = this.sort;
    this.purchases.paginator = this.paginator;
  }

  ngOnInit(): void {
    this.qualityService.findAllQualities().subscribe((data) => {
      this.qualities = data.body;
    });

    this.traitService.findAllTraits().subscribe((data) => {
      this.traits = data.body;
    });

    this.categoryService.findAllCategories().subscribe((data) => {
      let parents = data.body.map((value) => value.parent);

      let new_parents = parents
        .map((value) => value?.name)
        .filter((value) => value !== undefined)
        .filter((value, index, self) => self.indexOf(value) === index);

      let new_parents_01: any = [];

      new_parents.forEach((value, index, self) => {
        let children: any = data.body
          .filter((value) => value.parent !== null)
          .filter((valueNotNull) => valueNotNull.parent.name == value);

        // console.log(children);
        new_parents_01.push({ name: value, children: children });
      }, new_parents_01);

      this.categories = new_parents_01;
    });

    this.itemService
    .findMyItems(localStorage
    .getItem("username"))
    .subscribe( data => this.purchases.data = data.body);

  }

  onSubmit(form: NgForm) {
    this.itemService.createItem({
      "itemName":form.value.item_name,
      "basePrice":form.value.basePrice,
      "amount":form.value.amount,
      "level":form.value.level,
      "category":form.value.category,
      "trait":form.value.trait,
      "quality":form.value.quality,
      "owner":{"username": localStorage.getItem('username') }
    }).subscribe( data =>{
        if(data.status == 200){
          this.snackBar.open("Item uploaded successfully!", "OK");
          // location.reload();
        }
    } );
  }
}

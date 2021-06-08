import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../models/item';
import { User } from '../models/user';
import { ItemsService } from '../services/items.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit, AfterViewInit {
  items = new MatTableDataSource<Item>();
  slug: String;
  loggedInUser: String;
  complexServich: any;
  displayedColumns = [
    'itemName',
    'level',
    'owner',
    'dateCreated',
    'basePrice',
    'amount',
    'total',
    'buy?',
  ];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private activeRoute: ActivatedRoute,
    private itemService: ItemsService,
    private _snackBar: MatSnackBar,
    private router: Router
  ) { this.complexServich = this.router.getCurrentNavigation().extras.state;}

  ngAfterViewInit(): void {
    this.items.sort = this.sort;
    this.items.paginator = this.paginator;
  }

  ngOnInit(): void {
    this.loggedInUser =
      localStorage.length > 0 ? localStorage.getItem('username') : '';
    this.activeRoute.params.subscribe((value) => {
      this.slug = value['slug'];
    });

    if (this.complexServich != undefined && this.complexServich != '' && this.complexServich != null) {
        // console.log(this.complexServich);
      this.complexSearch(this.complexServich);
    } else if (this.slug != undefined && this.slug != '') {
      this.findAllBySlug();
    } else {
      this.findAll();
    }
  }

  private findAll(): any {
    return this.itemService.findAll().subscribe((value) => {
      this.items.data = value.body;
    });
  }

  private findAllBySlug(): any {
    return this.itemService
      .findAllBySlug(this.slug.toString())
      .subscribe((value) => {
        this.items.data = value.body as Item[];
      });
  }
  private complexSearch(item): any {
    return this.itemService
      .complexSearch(item)
      .subscribe((value) => {
        this.items.data = value.body as Item[];
      });
  }

  doFilter(filterValue: string) {
    this.items.filter = filterValue.trim().toLowerCase();
  }

  buyComponent(
    username: String,
    item_id: String,
    item_price: Number,
    amount: Number
  ) {
    // console.log(username, item_id);
    if (username == '' || username == null || username == 'null') {
      this._snackBar.open('You have to log in to be able to buy!', 'Close', {
        duration: 3000,
      });
      localStorage.clear();
      this.router.navigate(['/login']);
    } else if (
      Number(localStorage.getItem('goldAmount')) -
        item_price.valueOf() * amount.valueOf() <
      0
    ) {
      this._snackBar.open(
        "You don't have enough gold to buy this item!",
        'Close',
        { duration: 3000 }
      );
    } else {
      // console.log("Ulogovani ste");
      this.itemService.buyItem(username, item_id).subscribe((data) => {
        if (data.ok)
          localStorage.setItem(
            'goldAmount',
            String(
              Number(localStorage.getItem('goldAmount')) -
                item_price.valueOf() * amount.valueOf()
            )
          );

        this._snackBar.open('Successfully bought item!', 'Close', {
          duration: 3000,
        });
      });
    }
  }
}

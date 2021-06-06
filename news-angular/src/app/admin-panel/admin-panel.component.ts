import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Category } from '../models/category';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  radioCUD: any;

  //NOTE: categories

  newCategoryName: String;
  parentCategory: String;
  categories: Array<Category>;

  updateCategory: Category;
  updateCategoryParent: String;
  updateCategoryName: String;

  deleteCategory: any;

  //NOTE: categories
  constructor(
    private categoryService: CategoryService
  ) { }

  ngOnInit(): void {
    this.categoryService.findAllCategories()
    .subscribe( data => { console.log(
     data.body) });


  }

  onSubmitCategory(form: NgForm){

    if(this.radioCUD === "create")
    {

    }
    else if(this.radioCUD === "update"){

    }else{

    }

  }

}

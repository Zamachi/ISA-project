import { Options } from '@angular-slider/ngx-slider';
import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl } from '@angular/forms';
import { ActivatedRoute, Router, ParamMap, NavigationExtras } from '@angular/router';
import { Quality } from '../models/quality';
import { Trait } from '../models/trait';
import { CategoryService } from '../services/category.service';
import { QualityService } from '../services/quality.service';
import { TraitService } from '../services/trait.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  selectedCategory: any;
  selectedTrait: any;
  selectedQuality: any;

  kontrolaForme = new FormControl();

  //NOTE: Arrays
  categories: any;
  traits: Array<Trait>;
  qualities: Array<Quality>;
  //NOTE: Arrays

  levelSliderLow: Number = 1;
  levelSliderHigh: Number = 50;
  levelSliderOption: Options = {
    floor: 1,
    ceil: 50,
  };

  amountSliderLow: Number = 1;
  amountSliderHigh: Number = 200;
  amountSliderOption: Options = {
    floor: 1,
    ceil: 200,
  };

  priceSliderLow: Number = 1;
  priceSliderHigh: Number = 1000000;
  pricetSliderOption: Options = {
    floor: 1,
    ceil: 1000000,
  };

  constructor(private route: Router,
    private categoryService: CategoryService,
    private traitService: TraitService,
    private qualityService: QualityService) {

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

  }

  onSubmitSimple(formSimple: NgForm) {
      this.route.navigate(["/items/simpleSearch", formSimple.value.simpleSearch]);
  }

  onSubmit(form:NgForm){
    const search = form.value.search;
    const category = form.value.category;
    const trait = form.value.trait;
    const quality = form.value.quality;

    const complexSearch = {
      "search": search,
      "category": typeof(category) === 'string' ? category:category.name,
      "trait":typeof(trait) === 'string' ? trait:trait.traitName,
      "quality":typeof(quality) === 'string' ? quality:quality.qualityName,
      "levelLow":form.value.level[0],
      "levelHigh":form.value.level[1],
      "amountLow":form.value.amount[0],
      "amountHigh":form.value.amount[1],
      "priceLow":form.value.price[0],
      "priceHigh":form.value.price[1]
    };

    this.route.navigateByUrl("/items/complexSearch/", {state :complexSearch});
  }

}

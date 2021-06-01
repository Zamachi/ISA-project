import { Options } from '@angular-slider/ngx-slider';
import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl } from '@angular/forms';

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

  categories = [ //TODO: zameniti sa servisom koji dovlaci kategorije
    {
      name: 'weapons',
      subcategory: [
        { value: 'axe-0', viewValue: 'Axe' },
        { value: 'sword-1', viewValue: 'Sword' },
        { value: 'mace-2', viewValue: 'Mace' },
      ],
    },
    {
      name: 'armors',
      subcategory: [
        { value: 'light-0', viewValue: 'Light' },
        { value: 'heavy-1', viewValue: 'Heavy' },
        { value: 'medium-2', viewValue: 'Medium' },
      ],
    },
  ];

  traits: Array<String> = ['test'];
  qualities: Array<String> = ['test'];

  levelSliderLow: Number = 0;
  levelSliderHigh: Number = 100;
  levelSliderOption: Options = {
    floor: 0,
    ceil: 100,
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

  constructor() {}

  ngOnInit(): void {}

  onSubmit(form: NgForm) {
    console.log('radi');
  }
}

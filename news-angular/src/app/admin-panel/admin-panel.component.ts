import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Category } from '../models/category';
import { Quality } from '../models/quality';
import { Trait } from '../models/trait';
import { CategoryService } from '../services/category.service';
import { QualityService } from '../services/quality.service';
import { TraitService } from '../services/trait.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  radioCUD: any;

  //NOTE: categories

  newCategoryName: String;
  parentCategory: Category;
  categories: Array<Category>;

  updateCategory: String;
  updateCategoryParent: String;
  updateCategoryName: String;

  deleteCategoryId: any;

  //NOTE: categories

  //NOTE: qualities

  newQualityName: String;
  cssColors = [
    "AntiqueWhite",
"Aqua",
"Aquamarine",
"Azure",
"Beige",
"Bisque",
"Black",
"BlanchedAlmond",
"Blue",
"BlueViolet",
"Brown",
"BurlyWood",
"CadetBlue",
"Chartreuse",
"Chocolate",
"Coral",
"CornflowerBlue",
"Cornsilk",
"Crimson",
"Cyan",
"DarkBlue",
"DarkCyan",
"DarkGoldenRod",
"DarkGray",
"DarkGrey",
"DarkGreen",
"DarkKhaki",
"DarkMagenta",
"DarkOliveGreen",
"DarkOrange",
"DarkOrchid",
"DarkRed",
"DarkSalmon",
"DarkSeaGreen",
"DarkSlateBlue",
"DarkSlateGray",
"DarkSlateGrey",
"DarkTurquoise",
"DarkViolet",
"DeepPink",
"DeepSkyBlue",
"DimGray",
"DimGrey",
"DodgerBlue",
"FireBrick",
"FloralWhite",
"ForestGreen",
"Fuchsia",
"Gainsboro",
"GhostWhite",
"Gold",
"GoldenRod",
"Gray",
"Grey",
"Green",
"GreenYellow",
"HoneyDew",
"HotPink",
"IndianRed ",
"Indigo  ",
"Ivory",
"Khaki",
"Lavender",
"LavenderBlush",
"LawnGreen",
"LemonChiffon",
"LightBlue",
"LightCoral",
"LightCyan",
"LightGoldenRodYellow",
"LightGray",
"LightGrey",
"LightGreen",
"LightPink",
"LightSalmon",
"LightSeaGreen",
"LightSkyBlue",
"LightSlateGray",
"LightSlateGrey",
"LightSteelBlue",
"LightYellow",
"Lime",
"LimeGreen",
"Linen",
"Magenta",
"Maroon",
"MediumAquaMarine",
"MediumBlue",
"MediumOrchid",
"MediumPurple",
"MediumSeaGreen",
"MediumSlateBlue",
"MediumSpringGreen",
"MediumTurquoise",
"MediumVioletRed",
"MidnightBlue",
"MintCream",
"MistyRose",
"Moccasin",
"NavajoWhite",
"Navy",
"OldLace",
"Olive",
"OliveDrab",
"Orange",
"OrangeRed",
"Orchid",
"PaleGoldenRod",
"PaleGreen",
"PaleTurquoise",
"PaleVioletRed",
"PapayaWhip",
"PeachPuff",
"Peru",
"Pink",
"Plum",
"PowderBlue",
"Purple",
"RebeccaPurple",
"Red",
"RosyBrown",
"RoyalBlue",
"SaddleBrown",
"Salmon",
"SandyBrown",
"SeaGreen",
"SeaShell",
"Sienna",
"Silver",
"SkyBlue",
"SlateBlue",
"SlateGray",
"SlateGrey",
"Snow",
"SpringGreen",
"SteelBlue",
"Tan",
"Teal",
"Thistle",
"Tomato",
"Turquoise",
"Violet",
"Wheat",
"White",
"WhiteSmoke",
"Yellow",
"YellowGreen"
  ];
  newQualityColor: String;

  updateQuality: Quality;
  updateQualityName: String;
  qualities: Array<Quality>;
  updateQualityColor: String;

  deleteQualityId: String;
  //NOTE: qualities

  //NOTE: traits
  traits: Array<Trait>;

  newTraitName: String;

  updateTrait: Trait;
  updateTraitName: String;

  deleteTraitId: String;

  //NOTE: traits
  constructor(
    private categoryService: CategoryService,
    private qualityService: QualityService,
    private traitService: TraitService
    ) { }

  ngOnInit(): void {
    this.categoryService.findAllCategories()
    .subscribe( data => {
      // console.log(data.body);
      this.categories = data.body });

    this.qualityService.findAllQualities()
    .subscribe( data => {
      // console.log(data.body);
      this.qualities = data.body });

    this.traitService.findAllTraits().subscribe(
      data => {
        this.traits = data.body
      }
    );

  }

  onSubmitCategory(form: NgForm){

    if(this.radioCUD === "create")
    {
      const category = {
        "name":form.value.categoryName,
        "parent": form.value.parentCategory
      };

      this.categoryService
      .createCategory(category)
      .subscribe();

    }
    else if(this.radioCUD === "update"){
      const category = {
        "id": form.value.updateCategory,
        "name":form.value.updateCategoryName,
        "parent" : form.value.updateCategoryParent
      };

      console.log(category);


      this.categoryService
      .updateCategory(category)
      .subscribe();

    }else{
      this.categoryService.deleteCategory(form.value.deleteCategory).subscribe();
    }

  }

  onSubmitQuality(form: NgForm){
    if(this.radioCUD === "create")
    {
      const quality = {
        "qualityName": form.value.newQualityName,
        "color": form.value.newQualityColor
      };
      this.qualityService.createCategory(quality).subscribe();

    }
    else if(this.radioCUD === "update"){
      const quality = {
        "id": form.value.updateQuality,
        "qualityName": form.value.updateQualityName,
        "color": form.value.updateQualityColor
      };
      // console.log(quality);

      this.qualityService.updateCategory(quality).subscribe();

    }else{
      this.qualityService.deleteCategory(form.value.deleteQualityId).subscribe();
    }
  }

  onSubmitTrait(form: NgForm){
    if(this.radioCUD === "create")
    {
      const trait = {
        "traitName" : form.value.newTraitName
      };

      this.traitService.createTrait(trait).subscribe();
    }
    else if(this.radioCUD === "update"){
      const trait = {
        "id":form.value.updateTrait,
        "traitName":form.value.updateTraitName
      };

      this.traitService.updateTrait(trait).subscribe();

    }else{
      this.traitService.deleteTrait(form.value.deleteTraitId).subscribe();
    }
  }

}

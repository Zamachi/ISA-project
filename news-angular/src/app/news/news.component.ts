import { Component, OnInit } from '@angular/core';
import { NewsModel } from '../model/NewsModel';
import { NewsService } from '../service/news.service';


@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  news: NewsModel[] | null = [];
  constructor(private newsService: NewsService) { }

  ngOnInit(): void {
    this.findAll();
  }

  private findAll() : any {
    return this.newsService.findAll().subscribe(value => { this.news = value.body;  });
  }
}

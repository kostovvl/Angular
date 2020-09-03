import { Component, OnInit } from '@angular/core';
import {Article} from '../model/model.article';
import {ArticleData} from '../data/data.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  public articles: Article[] = [];
  public articleService: ArticleData;

  constructor() {
    this.articleService = new ArticleData;
   }

  ngOnInit(): void {
    this.articles = this.articleService.getData();
  }

}

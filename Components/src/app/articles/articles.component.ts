import { Component, OnInit } from '@angular/core';
import {ArticleData} from '../data/data';
import {Article} from '../model/article.model';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  articles: Article[];
  articleData: ArticleData;

  constructor() { 
    this.articleData = new ArticleData();
  }

  ngOnInit(): void {
    this.articles = this.articleData.getData();
  }

}

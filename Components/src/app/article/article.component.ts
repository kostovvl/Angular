import { Component, OnInit, Input } from '@angular/core';
import {Article} from '../models/articles.model'

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  private symbols : number = 250;
  @Input() article : Article;
  @Input() articleDesc: string;
  descToShow: string;
  articleDescLen: number;
  showReadMoreBtn: boolean = true;
  showHideBtn: boolean = false;
  imageIsShown: boolean = false;
  imageButtonTitle: string = 'Show Image';


  constructor() {
    this.articleDescLen = 0;
    this.descToShow = '';
   }

  ngOnInit(): void {
  }

  readMore(): void {
    this.articleDescLen += this.symbols;

    if (this.articleDesc.length >= this.articleDesc.length) {
      this.descToShow = this.articleDesc.substring(0, this.articleDescLen);
      this.articleDescLen = this.symbols; 
      this.showReadMoreBtn = false;
      this.showHideBtn = true;
    } else {
      this.descToShow = this.articleDesc;
    }    
  } 

  toggleImage(): void {
    if (this.imageIsShown) {
      this.imageButtonTitle = 'Hide Image';
    } 

    if (!this.imageIsShown) {
      this.imageButtonTitle = 'Show Image'
    }
    this.imageIsShown = !this.imageIsShown;
  }

  hideDesc(): void {
    this.descToShow = '';
    this.articleDescLen = 0;
    this.showHideBtn = false;
    this.showReadMoreBtn = true;
  }

}

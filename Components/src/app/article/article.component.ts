import { Component, OnInit, Input } from '@angular/core';
import {Article} from '../model/article.model';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  private symbolsNumber: number = 250;
  @Input() article: Article; 
  @Input() articleDesc: string;
  descToShow: string;
  articleDescLen: number;
  showReadMoreBtn: boolean = true;
  showHideBtn: boolean = false;
  imageIsShown: boolean = false;
  imageBtnTitle: string = 'Show Image';

  constructor() {
    this.descToShow = '';
    this.articleDescLen = 0;
   }

  ngOnInit(): void {
  }

  readMore(): void {
    this.articleDescLen += this.symbolsNumber;

    if (this.articleDescLen > this.articleDesc.length) {
      this.showReadMoreBtn = false;
      this.showHideBtn = true;
      this.descToShow = this.articleDesc;
    } else {
      this.descToShow = this.articleDesc.substring(0, this.articleDescLen);
    }
  }

  hideDesc() : void {
    this.showHideBtn = false;
    this.showReadMoreBtn = true;
    this.descToShow = ''; 
    this.articleDescLen = 0;
  }

  toggleImage() : void {
    this.imageIsShown = !this.imageIsShown;

    this.imageBtnTitle = this.imageIsShown? 'Hide Image' : 'Show Image';
  }

}

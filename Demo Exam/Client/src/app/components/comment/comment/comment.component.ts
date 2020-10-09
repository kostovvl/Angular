import { Component, Input, OnInit } from '@angular/core';
import Comment from 'src/app/core/model/comment.model';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input('comment') comment: Comment

  constructor() { }

  ngOnInit(): void {
  }

}

import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import Comment from 'src/app/core/model/comment.model';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input('comment') comment: Comment
  @Output('delete') delete: EventEmitter<number> = new EventEmitter;

  constructor() { }

  ngOnInit(): void {
  }

  editComment() {

  }

  deleteComment(id: number) {
   return this.delete.emit(id);
  }

}

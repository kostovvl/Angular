import { Component, Input, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input() commentInfo: Comment;
  @Output() deleteEvent: EventEmitter<number> = new EventEmitter;

  constructor() { }

  ngOnInit() {
  }

  deleteComment(id: number) {
    this.deleteEvent.emit(id);
  }

  isAuthor() {
    return this.commentInfo['creatorId'] == localStorage.getItem('userId');
  }

}

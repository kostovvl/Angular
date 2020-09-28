import { Component, Input, OnInit, EventEmitter, Output} from '@angular/core';
import Comment from 'src/app/components/common/models/comment.model'

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input() commentInfo: Comment;
  @Output() deleteEvent: EventEmitter<number> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  isAuthor() {
    const authorId = this.commentInfo.creatorId;
    const loggedId = localStorage.getItem('userId');
    let result = authorId == loggedId;
    return result;
  }

  deleteComment(id : number) {
    return this.deleteEvent.emit(id);
  }

}

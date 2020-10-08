import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import Post from 'src/app/core/model/post.model';
import { AdminService } from 'src/app/core/service/admin.service';
import { AuthService } from 'src/app/core/service/auth.service';
import { PostService } from 'src/app/core/service/post.service';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {

  @Input('post') post: Post;
  @Output('approve') approveEvent: EventEmitter<string> = new EventEmitter;
  @Output('delete') deleteEvent: EventEmitter<string> = new EventEmitter;


  constructor(
    private authService: AuthService,
    private adminService: AdminService,
    private postService: PostService,
    private router: Router
    ) { }

  ngOnInit(): void {
  }

  isAdmin() {
    return this.authService.isAdmin();
  }

  approvePost() {
     this.adminService.approvePost(this.post.id).subscribe(data => {
      this.approveEvent.emit('approved');
     });
     
  }

  deletePost(id: number) {
    return this.postService.delete(this.post.id).subscribe(data => {
      this.deleteEvent.emit('deleted');
    })
  }

}

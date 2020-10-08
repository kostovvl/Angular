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
      this.router.navigate([ '/admin' ]);
     });
     
  }

  deletePost(id: number) {
    return this.postService.delete(id).subscribe(data => {
      this.router.navigate( ['/admin'] );
    })
  }

}

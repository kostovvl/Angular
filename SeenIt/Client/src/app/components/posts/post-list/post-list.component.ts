import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, UrlSegment, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { PostService } from 'src/app/core/services/post.service';


@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  allPosts$: Observable<Object>;

  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.url.subscribe((segmentArr: UrlSegment[]) => {
      if (segmentArr.length === 1) {
        this.allPosts$ = this.postService.getAll() 
      } else {
       this.allPosts$ = this.postService.getUserPosts()
      }
    })
  }

  onDeletePost(id: string) {
    this.postService.deletePost(id)
      .subscribe(() => {
       this.allPosts$ = this.postService.getAll()
      })
  }

  isAuthor(creatorId: string) {
   
    let userId = localStorage.getItem('userId');
    let result = creatorId == userId;

    return result
  }

  deletePost(id: string) {
    this.postService.deletePost(id)
      .subscribe(() => {
        this.allPosts$ = this.postService.getAll()
      })
  }
}
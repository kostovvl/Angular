import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import Post from 'src/app/core/model/post.model';
import { PostService } from 'src/app/core/service/post.service';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {

  post: Post

  constructor(
    private postService: PostService,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    let postId = this.route.snapshot.params['id'];
    this.postService.postDetails(postId)
    .subscribe(data => {this.post = data})
  }

}

import { Injectable, } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from '../../../node_modules/rxjs'
import  Movie  from '../models/Movie'

const POPULAR_URL = 'http://localhost:8080/popular';
const IN_THEATER_URL = 'http://localhost:8080/in_theater';


@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  constructor(private http: HttpClient) { }

  getPopular(): Observable<Movie[]> {
   return this.http.get<Movie[]>('https://api.themoviedb.org/3/movie/popular?api_key=3954e7ab993e8e5f832230b29248785b');
  }

  getInTheaters(): Observable<Movie[]> {
    return this.http.get<Movie[]>('https://api.themoviedb.org/3/movie/top_rated?api_key=3954e7ab993e8e5f832230b29248785b');
}
}


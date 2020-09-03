import {Article} from '../model/article.model';
import { data } from './seed';

export class ArticleData{

    public articles: Article[] = [];

    getData() : Article[] {

        const dummyData = data;

        data.forEach(dummyArticle => {
            const currentArticle = new Article(dummyArticle.title, 
                dummyArticle.description, dummyArticle.author, dummyArticle.imageUrl);
                this.articles.push(currentArticle);
        })

        return this.articles;
    }
}
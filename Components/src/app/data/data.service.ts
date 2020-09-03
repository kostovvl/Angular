import {Article} from '../model/model.article'
import { data } from './seed';

export class ArticleData{

    articles: Article[] = [];

    getData() : Article[] {

        const seedData = data;

        seedData.forEach(mockArticle => {
            const newArticle = new Article(
                mockArticle.title, mockArticle.description, mockArticle.author, mockArticle.imageUrl);
                this.articles.push(newArticle);
        })
        return this.articles;
    }

}
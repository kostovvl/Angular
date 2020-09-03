import { Article } from "../models/articles.model";
import { data } from "./seed";

export class ArticleData{
    getData() : Article[] {

        let articles : Article[] = [];

        data.forEach(articleDatum => {
            const curr = new Article(articleDatum.title, articleDatum.description, 
                articleDatum.author, articleDatum.imageUrl);
            articles.push(curr);
        })

        return articles;
    }
}
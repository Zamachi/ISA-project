import { AuthorModel } from './AuthorModel';
import { NewsLocalizationModel } from './NewsLocalizationModel';
import { TagsModel } from './TagsModel';

export class NewsModel {
  id: String = "";
  tags: Array<TagsModel> = new Array();
  slug: String = "";
  datePublish: Date;
  numberOfVisits: Number;
  author: AuthorModel;
  newsLocalizations: NewsLocalizationModel;
}

import { TagsModel } from './TagsModel';

export class AuthorModel {
  id: String= "" ;
  tags: Array<TagsModel>= new Array() ;
  slug: String= "" ;
  username: String= "" ;
  password: String= "" ;
  firstName: String= "" ;
  lastName: String= "" ;
  dateBirth: Date ;
  city: String= "" ;
  country: String= "" ;
}

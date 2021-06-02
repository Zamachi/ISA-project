export interface Category{
  id: String;
  name: String;
  slug: String | null;
  parent: Category | null;

}

import { Category } from "./category";
import { User } from "./user";

export interface Item{
  id:any | null;
  itemName: String;
  basePrice: Number;
  category: Category;
  amount: Number;
  level: Number;
  owner: User;
  sold: boolean;
  dateCreated: Date;
  buyer: User | null;
  slug: String | null;
}

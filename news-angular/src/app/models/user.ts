import { Roles } from "./roles";

export interface User{
id: String;
slug: String | null;
username: String;
password: String;
email: String;
dateCreated: Date;
country: String;
goldAmount: Number;
isActive: boolean;
userRoles: Array<Roles>;
}

import type { IUser } from "../types/IUser";

export const saveUser = (user: IUser) => {
  const parseUser = JSON.stringify(user);
  localStorage.setItem("userData", parseUser);
};
export const getUSer = () => {
  return localStorage.getItem("userData");
};
export const removeUser = () => {
  localStorage.removeItem("userData");
};
export const getUsers = () => {
  const usersStorage =  localStorage.getItem("users");
  if (!usersStorage) {
    return [];
  }

  try {
    const users:IUser[] = JSON.parse(usersStorage);
    return users;
  } catch(error) {
    console.error("Error al obtener los usuarios: ", error);
    return [];
  }
};
export const saveUsers = (users: IUser[]) => {
  const parseUsers: string = JSON.stringify(users);
  localStorage.setItem("users", parseUsers);
}
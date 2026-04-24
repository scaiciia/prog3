import type { IUser } from "../../../types/IUser";
import { getUsers, saveUsers } from "../../../utils/localStorage";

const form = document.getElementById("form") as HTMLFormElement;
const inputEmail = document.getElementById("email") as HTMLInputElement;
const inputPassword = document.getElementById("password") as HTMLInputElement;

if (form && inputEmail && inputPassword) {
    form.addEventListener("submit", (e: SubmitEvent) => {
        e.preventDefault();
        const valueEmail:string = inputEmail.value;
        if (valueEmail.trim() == "") {
            alert("El campo email debe tener un correo.");
            console.error("El campo de email esta vacio.");
        }

        const valuePassword:string = inputPassword.value;
        if (valuePassword == "") {
            alert("Debe ingresar una contraseña.");
            console.error("El campo de password esta vacio.");
        }

        const usuarios: IUser[] = getUsers();

        const usuario: IUser = {
            email: valueEmail,
            password: valuePassword,
            loggedIn: false,
            role: "client"
        }

        usuarios.push(usuario);

        saveUsers(usuarios);
        alert("Usuario registrado con exito.");
    });
}
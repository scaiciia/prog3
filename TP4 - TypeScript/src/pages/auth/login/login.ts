import type { IUser } from "../../../types/IUser";
import type { Rol } from "../../../types/Rol";
import { navigate } from "../../../utils/navigate";
import { getUsers } from "../../../utils/localStorage";

const form = document.getElementById("form") as HTMLFormElement;
const inputEmail = document.getElementById("email") as HTMLInputElement;
const inputPassword = document.getElementById("password") as HTMLInputElement;
const selectRol = document.getElementById("rol") as HTMLSelectElement;

if (form && inputEmail && inputPassword && selectRol) {
  form.addEventListener("submit", (e: SubmitEvent) => {
    e.preventDefault();
    const valueEmail = inputEmail.value;
    if (valueEmail.trim() == "") {
      alert("El campo email debe tener un correo.");
      console.error("El campo de email esta vacio.")
      return;
    }

    const valuePassword = inputPassword.value;
    if (valuePassword == "") {
      alert("Debe ingresar una contraseña.");
      console.error("El campo de password esta vacio.");
      return;
    }

    const valueRol = selectRol.value as Rol;
    if (!valueRol) {
      alert("Debe seleccionar un rol.");
      console.error("El campo rol se esta vacio.");
      return;
    }

    const usuarios: IUser[] = getUsers();
    if (usuarios.length == 0) {
      alert("No hay usuarios registrados en el sistema.");
      console.error("No hay usuarios registrados");
      return;
    }

    if (!usuarios.find(u => u.email == valueEmail && u.password == valuePassword)) {
      alert("El email y/o contraseña son incorrectos");
      console.error("Usuario y/o contraseña son incorrectos.");
      return;
    }

    try {
      const user: IUser = {
        email: valueEmail,
        password: valuePassword,
        role: valueRol,
        loggedIn: true,
      };

      const parseUser = JSON.stringify(user);
      localStorage.setItem("userData", parseUser);

      if (valueRol === "admin") {
        navigate("/src/pages/admin/home/home.html");
      } else if (valueRol === "client") {
        navigate("/src/pages/client/home/home.html");
      }
    } catch(error) {
      console.error("Error al intentar loggear. Intentelo nuevamente.");
    }

  });
}
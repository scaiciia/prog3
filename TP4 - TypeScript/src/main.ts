import type { IUser } from "./types/IUser";
import { logout } from "./utils/auth";
import { getUSer } from "./utils/localStorage";
import { navigate } from "./utils/navigate";

function isIndexOrLogin(path: string): boolean {
    return path === "/" || path === "/src/pages/auth/login/login.html"
}

document.addEventListener("DOMContentLoaded", () => {
    const user: string | null = getUSer();
    const path:string = window.location.pathname
    if (!user) {
        console.log("No hay usuario.")
        if (!path.includes("/auth/")) {
            navigate("/src/pages/auth/login/login.html");
        }
        return;
    }

    try {
        const parseUser: IUser = JSON.parse(user);
        if (!parseUser.loggedIn) {
            console.log("El usuario no esta loggeado")
            navigate("/src/pages/auth/login/login.html");
        }

        console.log(window.location.pathname)
        if ((path.includes("/client/") && parseUser.role === "admin") || (isIndexOrLogin(path) && parseUser.role === "admin")) {
            console.log("El usuario es admin");
            navigate("/src/pages/admin/home/home.html");
        }

        if ((path.includes("/admin/") && parseUser.role !== "admin") || (isIndexOrLogin(path) && parseUser.role !== "admin")) {
            console.log("El usuario no es admin.");
            navigate("/src/pages/client/home/home.html");
        }
    
    } catch(error) {
        console.error("Error en la sesión, limpiando datos...");
        logout();
    }
})
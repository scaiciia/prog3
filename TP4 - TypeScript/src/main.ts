import type { IUser } from "./types/IUser";
import { getUSer } from "./utils/localStorage";
import { navigate } from "./utils/navigate";

document.addEventListener("DOMContentLoaded", () => {
    const user: string | null = getUSer();
    if (!user) {
        console.log("No hay usuario.")
        navigate("/src/pages/auth/login/login.html");
    } else {
        const parseUser: IUser = JSON.parse(user);
        if (!parseUser.loggedIn) {
            console.log("El usuario no esta loggeado")
            navigate("/src/pages/auth/login/login.html");
        }

        console.log(window.location.pathname)
        if ((window.location.pathname.includes("/client/") && parseUser.role === "admin") || (window.location.pathname === "/" && parseUser.role === "admin")) {
            console.log("El usuario es admin");
            navigate("/src/pages/admin/home/home.html");
        }

        if ((window.location.pathname.includes("/admin/") && parseUser.role !== "admin") || (window.location.pathname === "/" && parseUser.role !== "admin")) {
            console.log("El usuario no es admin.");
            navigate("/src/pages/client/home/home.html");
        }

    }
})
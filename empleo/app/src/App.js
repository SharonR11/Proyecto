import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

import Navbar from './Navbar/index';
import Index from './pages/index';
import Login from './pages/Login';
import Home from './pages'; // Importa el componente Home y asegúrate de que esté definido en el archivo correspondiente
import Registrarse from './pages/Registrase';
import Favoritos from './pages/Favoritos'
import Postulaciones from './pages/Postulaciones';



function App() {
  const [loggedIn, setLoggedIn] = useState(false);

  useEffect(() => {
    // Verificar si el usuario ya ha iniciado sesión previamente
    const isLoggedIn = localStorage.getItem('isLoggedIn');
    if (isLoggedIn) {
      setLoggedIn(true);
    }
  }, []);

  const handleLogin = () => {
    setLoggedIn(true);
    localStorage.setItem('isLoggedIn', 'true');
  };

  const handleLogout = () => {
    setLoggedIn(false);
    localStorage.removeItem('isLoggedIn');
  };

  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} /> {/* aqui se asignan las rutas a la que quieres dirigir*/}
          <Route path="/Login" element={<Login />} />
          <Route path="/Registrarse" element={<Registrarse />} />
          <Route path= "/Favoritos" element={<Favoritos/>} />
          <Route path="/postulaciones" element={<Postulaciones />} />


        </Routes>
      </Router>
      {/* Aquí puedes agregar el resto del contenido de tu página */}
    </>
  );
}

export default App;

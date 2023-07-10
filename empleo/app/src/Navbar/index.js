import React from 'react';
import { NavLink as Link } from 'react-router-dom';
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink
} from './NavbarElements';
import '../styles/NavbarElements.css'; // Importa el archivo CSS para los estilos personalizados

const Navbar = () => {
  return (
    <>
      <Nav>
        <Link to="/">
          <img src={require('../images/logo.png')} alt='logo' width="auto" height="70"/>
        </Link>
        <Bars />
        <NavMenu>
          <NavLink to="/Favoritos">Favoritos</NavLink>
          <NavLink to="/postulaciones">Postulaciones</NavLink>
          <NavLink to="/Login">Buscar ofertas de trabajo</NavLink>
        </NavMenu>
        <NavBtn>
          <div style={{padding:'10px'}}>
          <NavBtnLink to="/Login">Login</NavBtnLink>
          <NavBtnLink to="/Registrarse">Registrarse</NavBtnLink>
          </div>
        </NavBtn>
      </Nav>
    </>
  );
};

export default Navbar;

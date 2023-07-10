import styled from 'styled-components';
import { NavLink as Link } from 'react-router-dom';
import { FaBars } from 'react-icons/fa';

// Estilos para la barra de navegación
export const Nav = styled.nav`
  background: #6592a6;// color navbar
  height: 70px;
  display: flex;
  justify-content: space-between;
  padding: 0.5rem calc((100vw - 1000px) / 9); //posicionamiento del logo
`;
/* Agrega un relleno en el lado izquierdo y derecho del navbar */

// Estilos para los enlaces de navegación
export const NavLink = styled(Link)`
  color: #f0d0c7;
  display: flex;
  align-items: center;
  text-decoration: none;
  padding: 0 1rem;
  height: 100%;
  cursor: pointer;
  // Estilos para el enlace activo
  &.active {
    color: #f0d0c7;
  }
`;

// Estilos para el icono de las barras (modo responsivo)
export const Bars = styled(FaBars)`
  display: none;
  color: #f0d0c7;

  /* Estilos para el modo responsivo */
  @media screen and (max-width: 768px) {
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    transform: translate(-100%, 75%);/* Mueve el icono de las barras hacia la esquina superior derecha */
    font-size: 1.8rem;
    cursor: pointer;
  }
`;
// Estilos para el menú de navegación
export const NavMenu = styled.div`
  display: flex;
  align-items: center;
  margin-right: 24px;/* Margen derecho del menú de navegación */

  /* Ocultar el menú en modo responsivo */
  @media screen and (max-width: 768px) {
    display: none;
  }
`;

// Estilos para el botón de navegación
export const NavBtn = styled.nav`
  display: flex;
  align-items: center;
  margin-right: 24px;/* Margen derecho del botón de navegación */

  /* Ocultar el menú en modo responsivo */
  @media screen and (max-width: 768px) {
    display: none;
  }
`;

// Estilos para los enlaces del botón de navegación
export const NavBtnLink = styled(Link)`
  border-radius: 4px;
  background: #f0d0c7;//botom de color
  padding: 13px 22px;
  color: #9a0745;
  border: none;
  outline: none;
  cursor: pointer;
  transition: all 0.2s ease-in-out;
  text-decoration: none;

  // Estilos al pasar el cursor sobre el enlace
  &:hover {
    transition: all 0.2s ease-in-out;
    background: #e4836d;
    color: #9a0745;
  }
  
  /* Ajustar margen izquierdo en modo responsivo */
  @media screen and (max-width: 768px) {
    margin-left: 8px;
  }
  // Aplica margen izquierdo y derecho a los botones
  &:not(:last-child) {
    margin-right: 80px;
  }
  
`;

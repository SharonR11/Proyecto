import React, { useState, useEffect } from 'react';
import { Alert } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import Pageindex from './pagindex';

function Login() {
  const navigate = useNavigate();
  const [correolog, setCorreolog] = useState('');
  const [contraseñalog, setContraseñalog] = useState('');
  const [flag, setFlag] = useState(false);
  const [isLoggedIn, setLoggedIn] = useState(false);

  useEffect(() => {
    const userLoggedIn = localStorage.getItem('isLoggedIn');
    if (userLoggedIn === 'true') {
      setLoggedIn(true);
    }
  }, []);

  function handleLogin(e) {
    e.preventDefault();
    let contra = localStorage.getItem('sanskarPassword').replace(/"/g, '');
    const corre = localStorage.getItem('sanskarCorreo').replace(/"/g, '');

    if (!correolog || !contraseñalog) {
      setFlag(true);
      console.log('EMPTY');
    } else if (contraseñalog !== contra || correolog !== corre) {
      setFlag(true);
    } else {
      setLoggedIn(true);
      localStorage.setItem('isLoggedIn', 'true');
      setFlag(false);
      navigate('/otra-pagina');
    }
  }

  function handleLogout() {
    setLoggedIn(false);
    localStorage.removeItem('isLoggedIn');
  }

  return (
    <div>
      {isLoggedIn ? (
        <div>
          <h1>Bienvenido a tus publicaciones</h1>
          <button onClick={handleLogout}>Cerrar sesión</button>
          <Pageindex />
        </div>
      ) : (
        <form onSubmit={handleLogin}>
          <h3>LOGIN</h3>
          <div className="form-group">
            <label>Correo</label>
            <input
              type="text"
              className="form-control"
              placeholder="Ingresar correo electrónico"
              onChange={(event) => setCorreolog(event.target.value)}
            />
          </div>
          <div className="form-group">
            <label>Contraseña</label>
            <input
              type="password"
              className="form-control"
              placeholder="Ingresar contraseña"
              onChange={(event) => setContraseñalog(event.target.value)}
            />
          </div>

          <button type="submit" className="btn btn-dark btn-lg btn-block">
            Login
          </button>

          {flag && (
            <Alert color="primary" variant="warning">
              Por favor, ingrese la información correcta
            </Alert>
          )}
        </form>
      )}
    </div>
  );
}

export default Login;

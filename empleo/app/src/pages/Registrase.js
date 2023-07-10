import React, { useState } from 'react';
import { Form, Alert } from 'react-bootstrap';
import Login from './Login';
import { Image } from 'react-bootstrap';
import logo from '../images/logo.png';
import axios from 'axios';

function Registrarse() {
  const [nombres, setNombres] = useState('');
  const [apellidos, setApellidos] = useState('');
  const [carrera, setCarrera] = useState('');
  const [dni, setDni] = useState('');
  const [email, setEmail] = useState('');
  const [telefono, setTelefono] = useState('');
  const [password, setPassword] = useState('');
  const [foto, setFoto] = useState(null);

  const [flag, setFlag] = useState(false);
  const [login, setLogin] = useState(true);

  const handleFileChange = (event) => {
    const file = event.target.files[0];
    setFoto(URL.createObjectURL(file));
  };

  function handleFormSubmit(e) {
    e.preventDefault();

    if (!nombres || !apellidos || !carrera || !dni || !email || !telefono || !password || !foto) {
      setFlag(true);
    } else {
      setFlag(false);

      const formData = new FormData();
      formData.append('nombres', nombres);
      formData.append('apellidos', apellidos);
      formData.append('carrera', carrera);
      formData.append('dni', dni);
      formData.append('email', email);
      formData.append('telefono', telefono);
      formData.append('password', password);
      formData.append('foto', foto);

      axios.post('http://localhost:8080/api/v1/estudiante/save', formData) // Actualiza la URL para que coincida con tu ruta en el backend
        .then(response => {
          // La solicitud POST fue exitosa, puedes realizar acciones adicionales si es necesario
          console.log(response.data);
          setLogin(!login);
        })
        .catch(error => {
          // Ocurrió un error durante la solicitud POST
          console.error(error);
        });
    }
  }

  function handleClick() {
    setLogin(!login);
  }

  return (
    <div className="registration-container">
      <div className="image-container">
        <Image src={logo} alt="Logo" className="logo-image" />
      </div>
      <div className="form-container">
        {login ? (
          <form onSubmit={handleFormSubmit}>
            <h1>Registrar</h1>

            {/* NOMBRES */}
            <div className="form-group">
              <label>Nombres</label>
              <input
                type="text"
                className="form-control"
                placeholder="Ingresar nombres"
                value={nombres}
                onChange={(event) => setNombres(event.target.value)}
              />
            </div>

            {/* APELLIDOS */}
            <div className="form-group">
              <label>Apellidos</label>
              <input
                type="text"
                className="form-control"
                placeholder="Ingresar apellidos"
                value={apellidos}
                onChange={(event) => setApellidos(event.target.value)}
              />
            </div>

            {/* CARRERA */}
            <div className="form-group">
              <label>Carrera</label>
              <input
                type="text"
                className="form-control"
                placeholder="Ingresar carrera"
                value={carrera}
                onChange={(event) => setCarrera(event.target.value)}
              />
            </div>

            {/* DNI */}
            <div className="form-group">
              <label>DNI</label>
              <input
                type="text"
                className="form-control"
                placeholder="Ingresar DNI"
                value={dni}
                onChange={(event) => setDni(event.target.value)}
              />
            </div>

            {/* EMAIL */}
            <div className="form-group">
              <label>Email</label>
              <input
                type="email"
                className="form-control"
                placeholder="Ingresar correo electrónico"
                value={email}
                onChange={(event) => setEmail(event.target.value)}
              />
            </div>

            {/* TELEFONO */}
            <div className="form-group">
              <label>Teléfono</label>
              <input
                type="phone"
                className="form-control"
                placeholder="Ingresar número de teléfono"
                value={telefono}
                onChange={(event) => setTelefono(event.target.value)}
              />
            </div>

            {/* FOTO */}
            <div className="form-group">
              <label>Foto</label>
              <input
                type="file"
                className="form-control"
                onChange={handleFileChange}
              />
            </div>

            {/* CONTRASEÑA */}
            <div className="form-group">
              <label>Contraseña</label>
              <input
                type="password"
                className="form-control"
                placeholder="Ingresar contraseña"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
              />
            </div>

            <button type="submit" className="btn btn-dark btn-lg btn-block">
              Registrar
            </button>
           <p onClick={handleClick} className="forgot-password text-right">
              Ya está registrado {''}
              iniciar sesión
            </p>

            {flag && (
              <Alert color="primary" variant="danger">
                Por favor, complete todos los campos
              </Alert>
            )}
          </form>
        ) : (
          <div>
            <h2>Bienvenido, {nombres}</h2>
            {foto && <Image src={foto} alt="Foto de perfil" className="profile-image" />}
            <Login />
          </div>
        )}
      </div>
    </div>
  );
}

export default Registrarse;

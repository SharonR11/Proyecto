import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/Favoritos.css'; // Importar el archivo CSS para los estilos

function Favoritos() {
  const navigate = useNavigate();
  const [postulaciones, setPostulaciones] = useState([]);

  const jobsData = [
    {
      id: 1,
      title: 'Desarrollador Front-end',
      company: 'ABC Tech',
      location: 'Ciudad de México',
      salary: '$50,000 - $60,000',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum ligula eget dolor gravida, eu bibendum dolor fermentum.',
    },
    {
      id: 2,
      title: 'Diseñador Gráfico',
      company: 'XYZ Studio',
      location: 'Buenos Aires',
      salary: '$40,000 - $50,000',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum ligula eget dolor gravida, eu bibendum dolor fermentum.',
    },
    // Agrega más trabajos aquí...
  ];

  const handleApplyJob = (jobId) => {
    // Busca el trabajo seleccionado en los datos de los trabajos disponibles
    const selectedJob = jobsData.find((job) => job.id === jobId);

    if (selectedJob) {
      // Agrega el trabajo a las postulaciones
      setPostulaciones((prevPostulaciones) => [...prevPostulaciones, selectedJob]);
      alert('Trabajo aplicado con éxito');

      // Redirige a la sección de postulaciones
      navigate('/postulaciones');
    }
  };

  return (
    <div className="jobs-container">
      <h1>Trabajos Disponibles</h1>
      <div className="cards-container">
        {jobsData.map((job) => (
          <div className="job-card" key={job.id}>
            <div
              className="company-logo"
              style={{ backgroundImage: `url(${job.companyLogo})` }}
            ></div>
            <div className="job-title">{job.title}</div>
            <div className="company-name">{job.company}</div>
            <div className="job-location">{job.location}</div>
            <div className="job-details">
              <div className="job-salary">{job.salary}</div>
              <button className="apply-btn" onClick={() => handleApplyJob(job.id)}>
                Aplicar
              </button>
            </div>
            <div className="job-description">
              <p>{job.description}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Favoritos;

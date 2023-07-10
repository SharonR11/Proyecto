import React, { useState } from 'react';
import '../styles/Postulaciones.css'

function Postulaciones() {
    const [jobsData, setJobsData] = useState([
        {
          id: 1,
          title: 'Desarrollador Front-end',
          company: 'ABC Tech',
          location: 'Ciudad de México',
          salary: '$50,000 - $60,000',
          description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum ligula eget dolor gravida, eu bibendum dolor fermentum.',
          applied: false,
          status: 'Sin seguimiento',
        },
        {
          id: 2,
          title: 'Diseñador Gráfico',
          company: 'XYZ Studio',
          location: 'Buenos Aires',
          salary: '$40,000 - $50,000',
          description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum ligula eget dolor gravida, eu bibendum dolor fermentum.',
          applied: true,
          status: 'En revisión',
        },
        // Agrega más trabajos aquí...
      ]);
    
      const handleApply = (id) => {
        setJobsData(prevData => {
          return prevData.map(job => {
            if (job.id === id) {
              return { ...job, applied: true, status: 'En revisión' };
            }
            return job;
          });
        });
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
                  {!job.applied ? (
                    <button className="apply-btn" onClick={() => handleApply(job.id)}>
                      Aplicar
                    </button>
                  ) : (
                    <div className="job-status">{job.status}</div>
                  )}
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
export default Postulaciones;

import React, { useState, useEffect } from 'react';
import backgroundImage from '../images/imagen4.jpg';
import '../styles/Index.css'
import '@fortawesome/fontawesome-free/css/all.css';

function Home() {
  const [jobs, setJobs] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const [userLocation, setUserLocation] = useState(null);
  const [nearbyJobs, setNearbyJobs] = useState([]);

  useEffect(() => {
    const fetchJobs = async () => {
      try {
        // Llamada a la API para obtener los trabajos
        const response = await fetch('https://api.example.com/jobs');
        const data = await response.json();
        setJobs(data);
      } catch (error) {
        console.log(error);
        // Manejar errores en la llamada a la API
      }
    };

    fetchJobs();
  }, []);

  useEffect(() => {
    if (searchQuery === '' && userLocation) {
      // Filtrar trabajos cercanos si hay ubicación pero no hay consulta de búsqueda
      const nearbyJobsData = jobs.filter((job) => job.location === userLocation);
      setNearbyJobs(nearbyJobsData);
    } else {
      // Filtrar trabajos basado en la consulta de búsqueda
      const filteredJobs = jobs.filter((job) => {
        const { title, location, email } = job;
        const lowerCaseQuery = searchQuery.toLowerCase();
        return (
          (title?.toLowerCase().includes(lowerCaseQuery) || false) ||
          (location?.toLowerCase().includes(lowerCaseQuery) || false) ||
          (email?.toLowerCase().includes(lowerCaseQuery) || false)
        );
      });
      setNearbyJobs(filteredJobs);
    }
  }, [searchQuery, userLocation, jobs]);

  const handleSearch = (e) => {
    setSearchQuery(e.target.value);
  };

  const handleLocation = () => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position) => {
          const { latitude, longitude } = position.coords;
          setUserLocation({ latitude, longitude });
        },
        (error) => {
          console.log(error);
          // Manejar errores en la obtención de la ubicación
        }
      );
    } else {
      console.log('Geolocation is not supported by this browser.');
      // Manejar la falta de soporte para geolocalización en el navegador
    }
  };

  return (
    <div
      style={{
        backgroundImage: `url(${backgroundImage})`,
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '100vh',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        flexDirection: 'column',
      }}
    >
      <h3 className='formu'>Buscar trabajos</h3>

      <div className="search-container">
  <input
    type="text"
    value={searchQuery}
    onChange={handleSearch}
    placeholder="Buscar trabajos..."
    style={{ marginRight: '10px' }} className='formu'
  />
  <button onClick={handleLocation}>
    <i className="fas fa-search"></i>
  </button>
</div>



      <ul>
        {nearbyJobs.map((job) => (
          <li key={job.id}>
            <h4>{job.title}</h4>
            <p>Ubicación: {job.location}</p>
            <p>Email: {job.email}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Home;

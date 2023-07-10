import React, { useState, useEffect } from "react";
import Pageindex from './index';

function Pagindex() {
  const [searchTerm, setSearchTerm] = useState("");
  const [searchResults, setSearchResults] = useState([]);

  const handleInputChange = (event) => {
    setSearchTerm(event.target.value);
  };

  useEffect(() => {
    // Realiza la llamada a la API o realiza la lógica de búsqueda aquí
    // Actualiza los resultados de búsqueda en el estado setSearchResults([])
  }, [searchTerm]);

  return (
    <div>
      <input
        type="text"
        placeholder="Buscar..."
        value={searchTerm}
        onChange={handleInputChange}
      />
      <ul>
        {searchResults.map((result) => (
          <li key={result.id}>{result.name}</li>
        ))}
      </ul>
      
      {searchResults.length > 0 && <Pageindex />}
    </div>
  );
}

export default Pagindex;

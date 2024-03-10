import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Data_Component() {
  const [data, setData] = useState(false);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Fetch data from the Spring API
    axios.get('http://localhost:9091/getData')
      .then(response => {
      
        setData(response.data);
        setLoading(false);
      })
      .catch(error => {

        console.error('Error fetching data: ', error);
        setLoading(false);
      });
  }, []);
  return (
    <div>
      {loading ? (
        <p>Loading data...</p>
      ) : (
        <div>
          <h2>Name: {data.name}</h2>
          <h2>Name: {data.name}</h2>
        </div>
      )}
    </div>
  );
}

export default Data_Component;
